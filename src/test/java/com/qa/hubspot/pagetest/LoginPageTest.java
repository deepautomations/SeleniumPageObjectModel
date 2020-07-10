package com.qa.hubspot.pagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.constants.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test (priority=1)
	public void verifyLoginPageTitleTest() {
		String loginPageTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, Constants.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void verifySignUpLink() {
		Assert.assertTrue(loginPage.verifySignUpLink());
	}
	
	public void getContactTestData() {
		
	}
	@Test(priority=3)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

}
