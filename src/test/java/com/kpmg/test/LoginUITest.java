package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginUITest {

	Playwright playwright;
	Page page;

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

	@Test
	public void titleTest() {
		String actualTitle = page.title();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void headerTest() {
		String actualHeader = page.locator("xpath=//h5[text()='Login']").innerText();
		Assert.assertEquals(actualHeader, "Login");
	}
}
