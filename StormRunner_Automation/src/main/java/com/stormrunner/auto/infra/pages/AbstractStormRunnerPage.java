package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.web.By2;

public abstract class AbstractStormRunnerPage extends AbstractPage {

	private static final By2 loadTestsMenuLink = new By2("'Load Tests' Menu Link", By.cssSelector(".stm-tst-load-tests"));
	private static final By2 assetsMenuLink = new By2("'Assets' Menu Link", By.cssSelector(".stm-tst-assets"));
	private static final By2 resultsMenuLink = new By2("'Results' Menu Link", By.cssSelector(".stm-tst-results"));
	private static final By2 homeMenuLink = new By2("'Home' Menu Link", By.cssSelector(".stm-tst-home"));
	
	
	public AbstractStormRunnerPage(WebDriver driver, By2... pageUniqueElements) throws Exception {
		super(driver, pageUniqueElements);
	}
	
	// Click LOAD TESTS of main menu
	public StormRunnerLoadTestsPage clickLoadTestsMenuLink() throws Exception {
		bot.click(loadTestsMenuLink);
		return new StormRunnerLoadTestsPage(driver);
	}

	// Click ASSETS of main menu	
	public StormRunnerAssetsScriptsPage clickAssetsMenuLink() throws Exception {
		bot.click(assetsMenuLink);
		return new StormRunnerAssetsScriptsPage(driver);
	}
	
	// Click RESULTS of main menu
	public StormRunnerResultsPage clickResultsMenuLink() throws Exception {
		bot.click(resultsMenuLink);
		return new StormRunnerResultsPage(driver);
	}
	
	public StormRunnerHomePage clickHomeMenuLink() throws Exception {
		bot.click(homeMenuLink);
		return new StormRunnerHomePage(driver);
	}
	
	
	
}
