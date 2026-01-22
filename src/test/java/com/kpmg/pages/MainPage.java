package com.kpmg.pages;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Page;

/**
 * All common elements like menu will be handled here
 */
public class MainPage extends PlaywrightKeywords {

	private Page page;

	public MainPage(Page page) {
		super(page);
		this.page = page;
	}

}
