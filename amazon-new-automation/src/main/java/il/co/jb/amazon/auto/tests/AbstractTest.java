package il.co.jb.amazon.auto.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.jb.amazon.auto.infra.config.MainConfig;
import il.co.jb.amazon.auto.infra.web.WebDriverFactory;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTest {

	protected ReportDispatcher report = ReportManager.getInstance();
	protected WebDriver driver;

	@BeforeMethod
	public void beforeTest() throws IOException {
		
		MainConfig.initFromFile("src/main/resources/config/MainConfig.properties");
		
		if (driver == null) {
			
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType);
		}
	}
	
	public void browseToUrl(String url) {
		report.log("Browsing to URL: " + url);
		driver.get(url);
	}
	
	@AfterMethod
	public void afterTest() {
		
		if (driver != null && MainConfig.closeBrowserAtTestEnd) {
			driver.close();
		}
	}
}
