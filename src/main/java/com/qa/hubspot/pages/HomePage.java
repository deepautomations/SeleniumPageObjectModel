package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * By locators for the HomePage
	 * 
	 */
	By homepageDashBoard=By.cssSelector("h1.dashboard-selector__title");
	By dropdown=By.xpath("//a[@id='account-menu']");
	By userinfo=By.cssSelector("div.user-info-email");
	
	public String getHomePageTitle() {
		return(driver.getTitle());
	}
	
	public String getHomePageDashBoard() {
		if (driver.findElement(homepageDashBoard).isDisplayed()) {
		
		return driver.findElement(homepageDashBoard).getText();
		}
		return null;
		
	}
	
	public String getUserAccount() {
		driver.findElement(dropdown).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(driver.findElement(userinfo).isDisplayed()) {
		return driver.findElement(userinfo).getText();
		}
		return null;
		
	}
}
