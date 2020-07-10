package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.utilities.ElementUtil;

public class LoginPage extends BasePage {

	private WebDriver driver;
	BasePage basePage;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil=new ElementUtil(this.driver);
		
	}
	
	/**
	 * By locators for the login page
	 * 
	 */

	By SignUp = By.linkText("Sign up");
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");

	
	public String getLoginPageTitle() {
		return eleutil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);

	}

	public boolean verifySignUpLink() {
		
		return eleutil.doIsDisplayed(SignUp);

	}

	public HomePage doLogin(String username, String password) {
		eleutil.waitForElementPresent(this.username, 10);
		eleutil.doSendKeys(this.username, username);
		eleutil.doSendKeys(this.password, password);
		eleutil.doClick(loginBtn);
		return new HomePage(driver);

	}

}
