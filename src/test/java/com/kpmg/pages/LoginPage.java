package com.kpmg.pages;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Page;

public class LoginPage extends PlaywrightKeywords {

	private Page page;

	private String usernameLocator = "xpath=//input[@name='username']";
	private String passwordLocator = "xpath=//input[@name='password']";
	private String loginLocator = "xpath=//button[contains(normalize-space(),'Login')]";
	private String errorLocator = "xpath=//p[contains(normalize-space(),'Invalid')]";

	public LoginPage(Page page) {
		super(page);
		this.page = page;

	}

	public void enterUsername(String username) {
//		page.locator(usernameLocator).fill(username);
		super.sendInputText(usernameLocator, username);
	}

	public void enterPassword(String password) {
//		page.locator(passwordLocator).fill(password);
		super.sendInputText(passwordLocator, password);
	}

	public void clickOnLogin() {
//		page.locator(loginLocator).click();
		super.clickOnElement(loginLocator);
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
