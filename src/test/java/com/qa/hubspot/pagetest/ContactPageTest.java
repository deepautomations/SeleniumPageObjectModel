package com.qa.hubspot.pagetest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.ContactPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utilities.ExcelUtil;

public class ContactPageTest extends BaseTest {
	ContactPage contactPage;
	HomePage homePage;

	@BeforeClass
	public void contactPageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.gotoContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactPageTitleTest() {
		String contactPageTitle = contactPage.getContactPageTitle();
		Assert.assertEquals(contactPageTitle, Constants.CONTACT_PAGE_TITLE);
	}

	@DataProvider
	public Object[][] getContactTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACT_SHEET);
		return data;

	}

	@Test(priority = 2, dataProvider = "getContactTestData")
	public void createContactTest(String email, String firtName, String lastName, String jobTitle) {
		contactPage.createContact(email, firtName, lastName, jobTitle);
	}

}
