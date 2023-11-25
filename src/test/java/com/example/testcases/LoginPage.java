package com.example.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTests {

	WebDriver driver;

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/h5")
	WebElement titleText;

	@FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement login;

	@FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
	WebElement errorMessage;

	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	WebElement forgetPasswordLink;

	@FindBy(xpath = "//*[@id='social-icons']/a[1]/img")
	WebElement linkedInIcon;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Set user name in textbox
	public void setUserName(String strUserName) {
		userName.sendKeys(strUserName);
	}

	// Set password in password textbox
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	// Click on login button
	public void clickLogin() {
		login.click();
	}

	// Get the title of Login Page
	public String getLoginTitle() {
		return titleText.getAttribute("innerText");
	}

	// Get the text of forgotPasswordLink
	public String getforgotPasswordLinkText() {
		return forgetPasswordLink.getAttribute("innerText");
	}

	// Get the errorMessage
	public String getErrorMessage() {
		return errorMessage.getAttribute("innerText");
	}

	// Verify linkedInIcon is enabled
	public Boolean isEnabledLinkedIn() {
		return linkedInIcon.isEnabled();
	}

	public void login(String strUserName, String strPasword) {

		// Fill user name
		this.setUserName(strUserName);

		// Fill password
		this.setPassword(strPasword);

		// Click Login button
		this.clickLogin();
	}
}