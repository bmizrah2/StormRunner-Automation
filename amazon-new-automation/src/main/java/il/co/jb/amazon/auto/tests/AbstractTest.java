package il.co.jb.amazon.auto.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import il.co.jb.amazon.auto.infra.config.MainConfig;
import il.co.jb.amazon.auto.infra.reports.ConsoleReporter;
import il.co.jb.amazon.auto.infra.web.WebDriverFactory;

public abstract class AbstractTest {

	protected WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		
		if (driver == null) {
			
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType);
		}
	}
	
	public void browseToUrl(String url) {
		ConsoleReporter.report("Browsing to URL: " + url);
		driver.get(url);
	}
	
	@AfterTest
	public void afterTest() {
		
		if (driver != null && MainConfig.closeBrowserAtTestEnd) {
			driver.close();
		}
	}
}
