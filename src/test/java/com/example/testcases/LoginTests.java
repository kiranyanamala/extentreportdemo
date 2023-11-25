package com.example.testcases;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

	LoginPage objLogin;

	@Test(priority = 0)
	public void verifyLoginPageTitle() throws InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		Thread.sleep(3000);
		// Verify login page text
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
	}

	@Test(priority = 1)
	public void verifyforgetPasswordLink() {

		String expectedText = objLogin.getforgotPasswordLinkText();
		Assert.assertTrue(expectedText.contains("Forgot your password?"));

	}

	@Test(priority = 2)
	public void HomeTest() throws InterruptedException {
		// login to application
		objLogin.login("Admin1", "admin1234");
		Thread.sleep(3000);
		String expectedError = objLogin.getErrorMessage();

		// Verify home page
		Assert.assertTrue(expectedError.contains("Invalid credentials"));
	}

	@Test(priority = 3)
	public void verifyLinkedIn() {

		System.out.println("Actual linkedIn Text :" + objLogin.isEnabledLinkedIn());
		assertTrue(objLogin.isEnabledLinkedIn());

		System.out.println("Im in skip exception");
		throw new SkipException("Skipping this exception");
	}

}