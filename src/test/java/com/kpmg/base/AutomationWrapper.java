package com.kpmg.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
/**
 * Browser and Report Configuration 
 */
public class AutomationWrapper {
	
	private Playwright playwright;
	protected Page page;

	/**
	 * Available browser name is chrome or msedge
	 * https://playwright.dev/java/docs/browsers#google-chrome--microsoft-edge
	 * @param browserName
	 */
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browserName) 
	{
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false).setChannel(browserName));
		BrowserContext context = browser.newContext();
		page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com");
	}

	@AfterMethod
	public void teardown() {
		playwright.close();
	}

}
