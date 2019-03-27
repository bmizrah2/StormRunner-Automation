package com.stormrunner.auto.infra.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.stormrunner.auto.infra.config.MainConfig;

public class WebDriverFactory {

	public static WebDriver getWebDriver(WebDriverType webDriverType) {
		
		WebDriver driver = null;
		
		switch(webDriverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case INTERNET_EXPLORER:
			System.setProperty("webdriver.ie.driver", "webdrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(MainConfig.webDriverImplicitWaitInSeconds, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
}
