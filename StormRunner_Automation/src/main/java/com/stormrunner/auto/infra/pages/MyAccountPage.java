package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class MyAccountPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	// Account Name
	private static final By2 expectedAccountName = new By2("Expected Account Name", By.xpath("//div[@title='Benny Java Automation']"));

	// Launch Button
	private static final By2 launchButton = new By2("Launch Button", By.xpath("//a[text()='Launch']"));


	//WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));


	public MyAccountPage(WebDriver driver) throws Exception {
		super(driver, expectedAccountName);
	}

	//ORIG
	//public int getCartCounterValue() {

	//	String cartCounterText = bot.getElementText(cartCounterSpan);
	//	int cartCounter = Integer.parseInt(cartCounterText);
	//	return cartCounter;
	//}


	//StormRunner
	public static String getAccountName() {
		String actualAccountName = bot.getElementText(expectedAccountName);
		return actualAccountName;
	}

	//StormRunner - Click on Launch
	// Option1
	//	public void clickLaunchButton() {
	//		bot.click(launchButton);
	//	}


	//StormRunner - Click on Launch
	// Option2
	public StormRunnerHomePage clickLaunchButton() throws Exception{
		bot.click(launchButton);
		TabAndIframeUtils.switchToTabByTitle(driver, "Home", 40000);
		return new StormRunnerHomePage(driver); 
	}



}		
//public AmazonSearchResultsPage clickOnGoButton() throws Exception {
//	bot.click(goButton);
//	return new AmazonSearchResultsPage(driver);


//	public void clickOnContinueButton() throws Exception {
//		bot.click(continueAfterEnteringUserName);	
//	driver.findElement(By.xpath("//a[text()='Launch']")).click();



