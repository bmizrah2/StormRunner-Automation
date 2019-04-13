package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerMainMenuPage extends AbstractStormRunnerPage {

//	public StormRunnerMainMenuPage(WebDriver driver, By2[] pageUniqueElements) throws Exception {
//		super(driver, pageUniqueElements);
//		// TODO Auto-generated constructor stub
//	}

//	private static final StormRunnerMainMenuPage StormRunnerMainMenuPage = null;

	
	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	//Home tab by css selector  ($$("a.stm-tst-home"))
	private static final By2 homeButton = new By2("Home tab button", By.cssSelector("a.stm-tst-home"));

	//Load Tests tab by css selector  ($$("a.stm-tst-load-tests"))
	private static final By2 loadTestsButton = new By2("Load Tests tab button", By.cssSelector("a.stm-tst-load-tests"));
		
	// Assets tab css selector $$("stm-tst-assets")
	private static final By2 assetsButton = new By2("Assets tab button", By.cssSelector("a.stm-tst-assets"));

	// Results tab css selector $$("stm-tst-results")
	private static final By2 resultsButton = new By2("Results tab button", By.cssSelector("a.stm-tst-results"));

	
	//"Create a Test" button by id
	//private static final By2 createTest = new By2("Create a Test button", By.id("CreateTest"));

	//private static final StormRunnerMainMenuPage StormRunnerHomePage = null;

	//WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));


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
		public StormRunnerAssetsPage clickAssetsTab () throws Exception{
		bot.click(assetsButton);
		return new StormRunnerAssetsPage(driver);
		}
		
		
	// Click on Results tab
		public StormRunnerResultsPage clickResultsTab () throws Exception{
		bot.click(resultsButton);
		return new StormRunnerResultsPage(driver);
		}
			
	
	

	//ORIG
	//public int getCartCounterValue() {

	//	String cartCounterText = bot.getElementText(cartCounterSpan);
	//	int cartCounter = Integer.parseInt(cartCounterText);
	//	return cartCounter;
	//}


	//StormRunner
	//public void clickOnHomeTab() {
	//	bot.click(homeButton);
	//}

	//option2
	//public StormRunnerMainMenuPage clickOnHomeTab() {
	//	bot.click(homeButton);
	//	return StormRunnerHomePage;
	//}


//	public StormRunnerAssetsPage clickOnAssetsTab() {
//		bot.click(assetsButton);
//		return StormRunnerAssetsPage;
//	}
	
	

}
