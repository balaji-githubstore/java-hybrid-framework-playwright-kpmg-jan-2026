package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.kpmg.base.AutomationWrapper;

/**
 * Test class to automate Facebook invalid login scenario using Playwright.
 */
public class FacebookLoginTest extends AutomationWrapper {

    @Test(groups = {"regression"})
    public void invalidFacebookLoginTest() {
        // Navigate to Facebook login page
        page.navigate("https://www.facebook.com/");

        // Enter invalid credentials
        page.locator("input[name='email']").fill("invaliduser@example.com");
        page.locator("input[name='pass']").fill("wrongpassword");

        // Click the login button
        page.locator("button[name='login']").click();

        // Wait for error message to appear
        page.waitForSelector("div._9ay7"); // Facebook's error message class (may change)
        String errorMsg = page.locator("div._9ay7").innerText();

        // Assert error message is displayed and contains expected text
        Assert.assertTrue(errorMsg.toLowerCase().contains("incorrect"),
                "Expected error message for invalid login, but got: " + errorMsg);
    }
}
