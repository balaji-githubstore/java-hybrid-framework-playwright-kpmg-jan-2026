package com.kpmg.base;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
/**
 * Browser and Report Configuration 
 */
public class AutomationWrapper {
	
	private Playwright playwright;
	protected Page page;

	@BeforeMethod
	public void setup() {
		
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext context = browser.newContext();
		page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com");
	}

	@AfterMethod
	public void teardown() {
		playwright.close();
	}

}
