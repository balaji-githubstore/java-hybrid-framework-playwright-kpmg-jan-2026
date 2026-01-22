package com.kpmg.base;

import com.microsoft.playwright.Page;

public class PlaywrightKeywords {

	private Page page;

	public PlaywrightKeywords(Page page) {
		this.page = page;
	}

	public void clickOnElement(String selector) {
		page.locator(selector).click();
	}

	public void sendInputText(String selector, String text) {
		page.locator(selector).fill(text);
	}
}
