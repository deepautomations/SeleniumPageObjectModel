package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.utilities.ElementUtil;

public class ContactPage extends BasePage {
	private WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		eleutil=new ElementUtil(this.driver);
		
	}
	
	/*
	 * Locators
	 */
	By createContactsPrimary=By.xpath("//span[text()='Create contact']");
	
	By email=By.xpath("//input[@name='textInput' and @type='text']");
	By firstName=By.xpath("//input[@data-field='firstname']");
	By lastName=By.xpath("//input[@data-field='lastname']");
	By jobTitle=By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary=By.xpath("(//span[text()='Create contact'])[last()]");
	By contactBackLink=By.xpath("(//*[text()='Contacts'])[1]");
	
	/*
	 * Page Actions
	 */
	
	public String getContactPageTitle() {
		return eleutil.waitForTitleToBePresent(Constants.CONTACT_PAGE_TITLE, 10);
	}
	
	
	public void createContact(String email , String firstName, String lastName,String jobTitle) {
		//eleutil.waitForElementToBeVisible(createContactsPrimary, 10);
		eleutil.waitForElementPresent(createContactsPrimary, 10);
		eleutil.doClick(createContactsPrimary);
		eleutil.waitForElementPresent(this.email, 10);
		eleutil.doSendKeys(this.email, email);
		eleutil.doSendKeys(this.firstName, firstName);
		eleutil.doSendKeys(this.lastName, lastName);
		
		//eleutil.waitForElementToBeVisible(this.jobTitle, 10);
		eleutil.waitForElementPresent(this.jobTitle, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		eleutil.doSendKeys(this.jobTitle, jobTitle);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
		eleutil.waitForElementPresent(createContactSecondary, 10);
		eleutil.doActionsClick(createContactSecondary);	
		eleutil.waitForElementPresent(contactBackLink, 10);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleutil.doClick(contactBackLink);
		
	}
}
