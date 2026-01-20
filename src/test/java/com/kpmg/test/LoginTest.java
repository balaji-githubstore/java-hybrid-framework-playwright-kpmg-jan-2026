package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest() {
		page.locator("xpath=//input[@name='username']").fill("Admin");
		page.locator("xpath=//input[@name='password']").fill("admin123");
		page.locator("xpath=//button[contains(normalize-space(),'Login')]").click();

		String actualValue = page.locator("xpath=//h6[contains(normalize-space(),'Dashb')]").innerText();
		Assert.assertEquals(actualValue, "Dashboard");
	}
	
	@DataProvider
	public Object[][] invalidLoginData()
	{
		Object[][] data=new Object[2][3]; 
		
		data[0][0]="saul";
		data[0][1]="saul123";
		data[0][2]="Invalid credentials";
		
		data[1][0]="john";
		data[1][1]="john123";
		data[1][2]="Invalid credentials";
		
		return data;
	}
	

	@Test(dataProvider = "invalidLoginData")
	public void invalidLoginTest(String username, String password, String expectedError) 
	{
		page.locator("xpath=//input[@name='username']").fill(username);
		page.locator("xpath=//input[@name='password']").fill(password);
		page.locator("xpath=//button[contains(normalize-space(),'Login')]").click();

		String actualError = page.locator("xpath=//p[contains(normalize-space(),'Invalid')]").innerText();
		Assert.assertEquals(actualError, expectedError);
	}
}
