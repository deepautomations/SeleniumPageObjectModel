package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;
	BasePage basePage;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
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
		return driver.getTitle();

	}

	public boolean verifySignUpLink() {
		return (driver.findElement(SignUp).getText().equals("Sign up"));

	}

	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginBtn).click();
		return new HomePage(driver);

	}

}
