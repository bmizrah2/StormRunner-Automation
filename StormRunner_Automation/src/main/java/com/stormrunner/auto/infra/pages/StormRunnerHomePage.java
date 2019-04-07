package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;

public class StormRunnerHomePage extends AbstractPage {

	public StormRunnerHomePage(WebDriver driver, By2[] pageUniqueElements) throws Exception {
		super(driver, pageUniqueElements);
		// TODO Auto-generated constructor stub
	}

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));
	
	//Home tab by css selector  ($$("a.stm-tst-home"))
		private static final By2 homeButton = new By2("Home tab button", By.cssSelector("a.stm-tst-home"));
		
		
		//"Create a Test" button by id
		private static final By2 createTest = new By2("Create a Test button", By.id("CreateTest"));
	
	
		
	
	
	
	
	//WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));
	
		
	public StormRunnerHomePage(WebDriver driver) throws Exception {
		super(driver, homeButton);
	}
	
	//ORIG
	//public int getCartCounterValue() {
		
	//	String cartCounterText = bot.getElementText(cartCounterSpan);
	//	int cartCounter = Integer.parseInt(cartCounterText);
	//	return cartCounter;
	//}
	
	
	//StormRunner
	public void clickOnHomeTab() {
		bot.click(homeButton);
	}
	
	
	
}
