package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.pages.LoginPage;

public class LoginUITest extends AutomationWrapper {

	@Test(groups = { "smoke", "regression" })
	public void titleTest() {
		String actualTitle = page.title();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test(groups = { "regression" })
	public void headerTest() {
		String actualHeader = page.locator("xpath=//h5[text()='Login']").innerText();
		Assert.assertEquals(actualHeader, "Login");
	}

	@Test(groups = { "regression" })
	public void placeholderTest() {
		LoginPage login = new LoginPage(page);

		Assert.assertEquals(login.getUsernamePlaceholder(), "Username");
		Assert.assertEquals(login.getPasswordPlaceholder(), "Password");
	}
}
