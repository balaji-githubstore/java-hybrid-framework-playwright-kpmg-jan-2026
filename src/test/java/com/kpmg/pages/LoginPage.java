package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	private String usernameLocator = "xpath=//input[@name='username']";
	private String passwordLocator = "xpath=//input[@name='password']";
	private String loginLocator = "xpath=//button[contains(normalize-space(),'Login')]";
	private String errorLocator = "xpath=//p[contains(normalize-space(),'Invalid')]";

	public LoginPage(Page page) {
		this.page = page;
	}

	public void enterUsername(String username) {
		page.locator(usernameLocator).fill(username);
	}

	public void enterPassword(String password) {
		page.locator(passwordLocator).fill(password);
	}

	public void clickOnLogin() {
		page.locator(loginLocator).click();
	}

	public String getInvalidErrorMessage() {
		return page.locator(errorLocator).innerText();
	}

	public String getUsernamePlaceholder() {
		return page.locator(usernameLocator).getAttribute("placeholder");
	}

	public String getPasswordPlaceholder() {
		return page.locator(passwordLocator).getAttribute("placeholder");
	}
}
