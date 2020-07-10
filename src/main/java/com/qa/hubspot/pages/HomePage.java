package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.utilities.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(this.driver);
	}

	/**
	 * By locators for the HomePage
	 * 
	 */
	By homepageDashBoard = By.cssSelector("h1.dashboard-selector__title");
	By dropdown = By.xpath("//a[@id='account-menu']");
	By userinfo = By.cssSelector("div.user-info-email");
	By primaryContactLink=By.id("nav-primary-contacts-branch");
	By secondaryConctactLink=By.id("nav-secondary-contacts");

	public String getHomePageTitle() {

		return eleutil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getHomePageDashBoard() {
		if (eleutil.doIsDisplayed(homepageDashBoard)) {

			return eleutil.doGetText(homepageDashBoard);
		}
		return null;

	}

	public String getUserAccount() {
		eleutil.waitForElementPresent(userinfo, 15);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleutil.doClick(userinfo);
		if (eleutil.doIsDisplayed(userinfo)) {
			return eleutil.doGetText(userinfo);
		}
		return null;

	}
	
	public ContactPage gotoContactsPage() {
		clickOnContact();
		return new ContactPage(driver);
	}
	
	private void clickOnContact() {
		//eleutil.waitForElementToBeVisible(primaryContactLink, 10);
		eleutil.waitForElementPresent(primaryContactLink, 10);
		eleutil.doClick(primaryContactLink);
		eleutil.waitForElementPresent(secondaryConctactLink, 5);
		//eleutil.waitForElementToBeVisible(secondaryConctactLink, 5);
		eleutil.doClick(secondaryConctactLink);
		
	}
	
	
}
