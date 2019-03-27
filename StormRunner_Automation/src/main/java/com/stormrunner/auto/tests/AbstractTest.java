package com.stormrunner.auto.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.WebDriverFactory;

public class AbstractTest {

	protected WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		
		if (driver == null) {
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType);
		}
	}
	
	@AfterTest
	public void afterTest() {
		
		if (driver != null && MainConfig.closeBrowserAtTestEnd) {
			driver.close();
		}
	}
}
