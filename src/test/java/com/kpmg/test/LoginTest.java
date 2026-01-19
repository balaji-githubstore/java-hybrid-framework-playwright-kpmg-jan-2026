package com.kpmg.test;

import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper {
	
	@Test
	public void validLoginTest()
	{
		page.locator("xpath=//input[@name='username']").fill("Admin");
		//enter password
		//click on login
		//Assert the header - Dashboard
	}

}
