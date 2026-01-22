package com.kpmg.pages;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Page;

public class DashboardPage  extends PlaywrightKeywords {
	
	private Page page;

	public DashboardPage(Page page) {
		super(page);
		this.page = page;
	}

	public String getDashboardHeader()
	{
		return page.locator("xpath=//h6[contains(normalize-space(),'Dashb')]").innerText();
	}
}
