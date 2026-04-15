package com.kpmg.pages;

import com.microsoft.playwright.Page;

/**
 * All common elements like menu will be handled here
 */
public class MainPage {
	
	private Page page;

	public MainPage(Page page) {
		this.page = page;
	}

}
