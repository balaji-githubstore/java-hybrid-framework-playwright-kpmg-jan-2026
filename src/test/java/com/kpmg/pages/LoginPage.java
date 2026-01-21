package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	
	public static void enterUsername(Page page,String username)
	{
		page.locator("xpath=//input[@name='username']").fill(username);
	}
	
	public static void enterPassword(Page page,String password)
	{
		page.locator("xpath=//input[@name='password']").fill(password);
	}
	
}
