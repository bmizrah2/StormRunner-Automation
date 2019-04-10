package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerLoadTestsPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));
	

	//Clicking Load Tests tab by css selector  ($$("a.stm-tst-home"))
	private static final By2 loadTestsTab = new By2("Clicking 'Load Tests' tab", By.cssSelector("a.stm-tst-load-tests"));
	
	
	//"Create" button by css selector $$("div.stm-tst-create")
	private static final By2 createButton = new By2("Clicking 'Create' button", By.id("div.stm-tst-create"));
	
		
	// Test name input field
	private static final By2 testNameInput = new By2("Entering new Test Name", By.id("input.stm-tst-test-name-header"));
	
	
	// Description field
	private static final By2 descriptionField = new By2("Entering new Test Name", By.id("textarea.stm-tst-edit-description"));
	
	
	
	
	//WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));
	
		
	public StormRunnerLoadTestsPage(WebDriver driver) throws Exception {
		super(driver, loadTestsTab,createButton);
	}
	
	
	
	// StornRunner - Write the Test name field
			public void writeToTestNameField(String userTestNameInput) {
					bot.writeToElement(testNameInput, userTestNameInput);
				}



			public void writeToDescriptionField(String descriptionInput) {
				// TODO Auto-generated method stub
				bot.writeToElement(descriptionField, descriptionInput);
			}
	
			public StormRunnerHomePage clickLaunchButton() throws Exception{
				bot.click(launchButton);
				TabAndIframeUtils.switchToTabByTitle(driver, "Home", 10000);
				return new StormRunnerHomePage(driver); 
			}
			
	
	//ORIG
	//public int getCartCounterValue() {
		
	//	String cartCounterText = bot.getElementText(cartCounterSpan);
	//	int cartCounter = Integer.parseInt(cartCounterText);
	//	return cartCounter;
	//}
	
	
	//StormRunner
//	public static String getAccountName() {
//		String actualAccountName = bot.getElementText(expectedAccountName);
//		return actualAccountName;
//	}
	
	
	
}
