package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper {
	
	@Test
	public void validLoginTest()
	{
		page.locator("xpath=//input[@name='username']").fill("Admin");
		page.locator("xpath=//input[@name='password']").fill("admin123");
		page.locator("xpath=//button[contains(normalize-space(),'Login')]").click();

		String actualValue=page.locator("xpath=//h6[contains(normalize-space(),'Dashb')]").innerText();
		Assert.assertEquals(actualValue, "Dashboard");
	}
	
	@Test
	public void invalidLoginTest()
	{
		page.locator("xpath=//input[@name='username']").fill("john");
		page.locator("xpath=//input[@name='password']").fill("john123");
		page.locator("xpath=//button[contains(normalize-space(),'Login')]").click();
		
		String actualError=page.locator("xpath=//p[contains(normalize-space(),'Invalid')]").innerText();
		Assert.assertEquals(actualError, "Invalid credentials");

	}

}
