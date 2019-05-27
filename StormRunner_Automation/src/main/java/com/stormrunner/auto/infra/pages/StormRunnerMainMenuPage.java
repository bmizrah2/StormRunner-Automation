package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.web.By2;

public class StormRunnerMainMenuPage extends AbstractStormRunnerPage {


	//'Home' tab by css selector  ($$("a.stm-tst-home"))
	private static final By2 homeButton = new By2("Home tab button", By.cssSelector("a.stm-tst-home"));

	//'Load Tests' tab by css selector  ($$("a.stm-tst-load-tests"))
	private static final By2 loadTestsButton = new By2("Load Tests tab button", By.cssSelector("a.stm-tst-load-tests"));

	// 'Assets' tab css selector $$("stm-tst-assets")
	private static final By2 assetsButton = new By2("Assets tab button", By.cssSelector("a.stm-tst-assets"));

	// 'Results' tab css selector $$("stm-tst-results")
	private static final By2 resultsButton = new By2("Results tab button", By.cssSelector("a.stm-tst-results"));

	// Constructor
	public StormRunnerMainMenuPage(WebDriver driver) throws Exception {
		super(driver, homeButton);
	}

	// Click on HOME tab
	public StormRunnerHomePage clickHomeTab () throws Exception{
		bot.click(homeButton);
		return new StormRunnerHomePage(driver); 
	}


	// Click on LOAD TESTS tab
	public StormRunnerLoadTestsPage clickCreateTestsTab() throws Exception{
		bot.click(loadTestsButton);
		//TabAndIframeUtils.switchToTabByTitle(driver, "Load Tests", 10000);
		return new StormRunnerLoadTestsPage(driver); 
	}

	// Click on Assets tab
	public StormRunnerAssetsScriptsPage clickAssetsTab () throws Exception{
		bot.click(assetsButton);
		return new StormRunnerAssetsScriptsPage(driver);
	}


	// Click on Results tab
	public StormRunnerResultsPage clickResultsTab () throws Exception{
		bot.click(resultsButton);
		return new StormRunnerResultsPage(driver);
	}


}
