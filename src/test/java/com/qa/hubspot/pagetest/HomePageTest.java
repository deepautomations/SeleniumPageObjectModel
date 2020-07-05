package com.qa.hubspot.pagetest;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;

public class HomePageTest extends BaseTest {
	HomePage homePage;
	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String homePageTitle=homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, Constants.HOME_PAGE_TITLE,"Home page title is not correct...");
	}
	@Test(priority=2)
	public void verifyHomePageHeader() {
		String homePageHeader=homePage.getHomePageDashBoard();
		Assert.assertEquals(homePageHeader, Constants.HOME_PAGE_HEADER,"Home page header is not present ...");
	}
	@Test(priority=3)
	public void verifyUserAccountTest() {
		String userAcc=homePage.getUserAccount();
		Assert.assertEquals(userAcc.trim(), prop.getProperty("username").trim());
	}
	

}
