package com.kpmg.base;

import java.lang.reflect.Method;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Browser and Report Configuration
 */
public class AutomationWrapper {

	public static final Logger log = LogManager.getLogger();

	private Playwright playwright;
	protected Page page;

	private static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void init() {
		if (extent == null) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
			extent.attachReporter(spark);
		}
	}

	@AfterSuite
	public void end() {
		extent.flush();
	}

	/**
	 * Available browser name is chrome or msedge
	 * https://playwright.dev/java/docs/browsers#google-chrome--microsoft-edge
	 * 
	 * @param browserName
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(@Optional("chrome") String browserName, Method mtd) {

		test = extent.createTest(mtd.getName());
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel(browserName));
		BrowserContext context = browser.newContext();
		page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com");
		log.info("Navigating to login page");
	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result, Method mtd) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Base64.getEncoder().encodeToString(page.screenshot()));
			test.fail(result.getThrowable());
			log.error("Test FAILED: " + mtd.getName(), result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
			log.info("Test PASSED: " + mtd.getName());
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			log.warn("Test SKIPPED: " + mtd.getName(), result.getThrowable());
		}
		
		log.info("Test completed " + mtd.getName());
		playwright.close();
	}

}
