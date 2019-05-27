package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerHomePage extends AbstractStormRunnerPage {

	public StormRunnerHomePage(WebDriver driver, By2[] pageUniqueElements) throws Exception {
		super(driver, pageUniqueElements);
	}


	//'Home' tab by css selector  ($$("a.stm-tst-home"))
	private static final By2 homeButton = new By2("Home tab button", By.cssSelector("a.stm-tst-home"));

	// 'Assets' tab by css selector $$("stm-tst-assets")
	private static final By2 assetsButton = new By2("Assets tab button", By.cssSelector("a.stm-tst-assets"));

	//"Create a Test" button by id
	private static final By2 createTest = new By2("Create a Test button", By.id("CreateTest"));


	private static final StormRunnerHomePage StormRunnerHomePage = null;

	// constructor
	public StormRunnerHomePage(WebDriver driver) throws Exception {
		super(driver, homeButton);
	}

	// Clicking on 'LoadTests' tab
	public StormRunnerLoadTestsPage clickCreateTestsTab() throws Exception{
		bot.click(createTest);
		TabAndIframeUtils.switchToTabByTitle(driver, "Load Tests", 10000);
		return new StormRunnerLoadTestsPage(driver); 
	}

	// Clicking on 'Assets' tab
	public StormRunnerAssetsMonitorsPage clickAssetsTab() throws Exception{
		bot.click(assetsButton);
		return new StormRunnerAssetsMonitorsPage(driver); 
	}


	// Clicking on AssetsLoadGenerators tab
	public StormRunnerAssetsLoadGeneratorsPage clickAssetsLoadGeneratorsTab() throws Exception{
		bot.click(assetsButton);
		return new StormRunnerAssetsLoadGeneratorsPage(driver); 
	}


	//Click on 'Home' button
	public StormRunnerHomePage clickOnHomeTab() throws Exception {
		bot.click(homeButton);
		return StormRunnerHomePage;
	}

	// Wait for 'Home' page to be visible	
	public void waitToHomePageToBeVisible() {
		bot.waitForElementToBeClickable(homeButton);
	}


}
