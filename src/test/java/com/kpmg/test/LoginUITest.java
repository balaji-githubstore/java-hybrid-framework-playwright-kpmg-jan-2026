package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {

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
