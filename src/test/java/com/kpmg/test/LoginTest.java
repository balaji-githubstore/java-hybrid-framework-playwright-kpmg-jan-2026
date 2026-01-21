package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.pages.DashboardPage;
import com.kpmg.pages.LoginPage;
import com.kpmg.utilities.DataSource;

public class LoginTest extends AutomationWrapper {

	@Test(dataProviderClass = DataSource.class, dataProvider = "commonDataProvider")
	public void validLoginTest(String username, String password, String expectedValue) {

		LoginPage login = new LoginPage(page);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		DashboardPage dashboard = new DashboardPage(page);
		String actualValue = dashboard.getDashboardHeader();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test(dataProviderClass = DataSource.class, dataProvider = "commonDataProvider")
	public void invalidLoginTest(String username, String password, String expectedError) {

		LoginPage login = new LoginPage(page);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		String actualError = login.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}
}

