package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.utilities.DataSource;

public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest() {
		page.locator("xpath=//input[@name='username']").fill("Admin");
		page.locator("xpath=//input[@name='password']").fill("admin123");
		page.locator("xpath=//button[contains(normalize-space(),'Login')]").click();

		String actualValue = page.locator("xpath=//h6[contains(normalize-space(),'Dashb')]").innerText();
		Assert.assertEquals(actualValue, "Dashboard");
	}

	@Test(dataProviderClass = DataSource.class,dataProvider = "invalidLoginData")
	public void invalidLoginTest(String username, String password, String expectedError) {
		page.locator("xpath=//input[@name='username']").fill(username);
		page.locator("xpath=//input[@name='password']").fill(password);
		page.locator("xpath=//button[contains(normalize-space(),'Login')]").click();

		String actualError = page.locator("xpath=//p[contains(normalize-space(),'Invalid')]").innerText();
		Assert.assertEquals(actualError, expectedError);
	}
}
