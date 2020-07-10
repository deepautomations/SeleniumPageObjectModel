package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	protected ElementUtil eleutil;
	OptionsManager optionManager;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		optionManager=new OptionsManager(prop);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver=new ChromeDriver();
			tldriver.set(new ChromeDriver(optionManager.setChromeBrowserOptions()));

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver=new FirefoxDriver();
			tldriver.set(new FirefoxDriver(optionManager.setFirefoxBrowserOptions()));
		} else {
			System.out.println(browserName + "is not valid to run this test");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public Properties init_properties() {

		prop = new Properties();
		FileInputStream ip;
		String path=null;
		String env=null;
		
		
		try {
			env=System.getProperty("env");
			System.out.println("The Test environment is -->" + env);
			if (env==null) {
				path="./src/main/java/com/qa/hubspot/properties/config.properties";
			}else {
				switch (env) {
				case "qa":
					path="./src/main/java/com/qa/hubspot/properties/qa.config.properties";
					break;
				case "stage":
					path="./src/main/java/com/qa/hubspot/properties/stage.config.properties";
					break;

				default:
					System.out.println(env +"is not the valid environment for testing ");
					break;
				}
			}
			ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	/*
	 * Method Takes screenshot
	 */
	public String getScreenShot() {
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
		
	}

}
