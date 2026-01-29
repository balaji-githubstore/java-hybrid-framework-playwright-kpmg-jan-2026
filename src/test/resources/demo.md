## Plan: Automate Facebook Invalid Login Test

This plan outlines how to automate a Facebook invalid login scenario using the existing hybrid Playwright-TestNG framework. The test will navigate to Facebook, enter invalid credentials, attempt login, and verify the error message.

### Steps
1. Create a new test class (e.g., `FacebookLoginTest`) in [`com.kpmg.test`](src/test/java/com/kpmg/test/).
2. Implement a test method for invalid login using Playwright’s page object.
3. In the test, navigate to `https://www.facebook.com/`.
4. Enter invalid username and password in the respective fields.
5. Click the login button.
6. Wait for and verify the expected error message is displayed.

### Further Considerations
1. Facebook may change selectors or block automation; selectors may need updates.
2. Should the test data (invalid credentials) be hardcoded or externalized?
3. Error message text may vary by region/language—confirm expected value.
