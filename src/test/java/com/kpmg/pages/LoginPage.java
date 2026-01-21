package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	public LoginPage(Page page) {
		this.page = page;
	}

	public void enterUsername(String username) {

		page.locator("xpath=//input[@name='username']").fill(username);
	}

	public void enterPassword(String password) {
		page.locator("xpath=//input[@name='password']").fill(password);
	}

	public void clickOnLogin() {
		page.locator("xpath=//button[contains(normalize-space(),'Login')]").click();
	}

	public String getInvalidErrorMessage() {
		return page.locator("xpath=//p[contains(normalize-space(),'Invalid')]").innerText();
	}
}
