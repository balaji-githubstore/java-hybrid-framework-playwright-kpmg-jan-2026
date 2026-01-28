package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.pages.LoginPage;

public class LoginUITest extends AutomationWrapper {

	@Test(groups = { "smoke", "regression" })
	public void titleTest() {
		String actualTitle = page.title();
		log.info("Actual title " + actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test(groups = { "regression" })
	public void headerTest() {
		String actualHeader = page.locator("xpath=//h5[text()='Login']").innerText();
		log.info("Actual header " + actualHeader);
		Assert.assertEquals(actualHeader, "Login");
	}

	@Test(groups = { "regression" })
	public void placeholderTest() {

		LoginPage login = new LoginPage(page);

		log.info("Verifying username placeholder");
		Assert.assertEquals(login.getUsernamePlaceholder(), "Username1");
		log.info("Verifying password placeholder");
		Assert.assertEquals(login.getPasswordPlaceholder(), "Password");

	}
}
