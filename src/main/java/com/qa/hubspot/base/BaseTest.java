package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected BasePage basePage;
	protected LoginPage loginPage;
	protected Properties prop;
	

	@BeforeTest
	public void PageSetup() {
		basePage=new BasePage();
		prop=basePage.init_properties();
		driver=basePage.init_driver(prop);
		loginPage=new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
