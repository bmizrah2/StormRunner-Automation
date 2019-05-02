package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerLoadTestsPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));


	//Clicking Load Tests tab by css selector  ($$("a.stm-tst-home"))
	private static final By2 loadTestsTab = new By2("Clicking 'Load Tests' tab", By.cssSelector("a.stm-tst-load-tests"));


	//"Create" button by css selector $$("div.stm-tst-create")
	//private static final By2 createButton = new By2("Clicking 'Create' button", By.id("div.stm-tst-create"));

	//"Create" by CSS
	private static final By2 createButton = new By2("Clicking 'Create' button", By.cssSelector("div[class='stm-tst-create']"));


	// Test name input field
	private static final By2 testNameInput = new By2("Entering new Test Name", By.id("input.stm-tst-test-name-header"));


	// Description field
	private static final By2 descriptionField = new By2("Entering new Test Name", By.id("textarea.stm-tst-edit-description"));

	// TEST NAME column header
	private static final By2 testNameHeader = new By2("TEST NAME column header ", By.xpath("//div[@title='TEST NAME']"));

	// Tool Bar
	private static final By2 toolBar = new By2("Tool Bar exist ", By.xpath("//div[@class='stm-tst-tool-bar']"));

	// Create text of the button
	private static final By2 createText = new By2("'Create' text", By.xpath("//div[contains(text(),'Create')]"));

	// Edit text of the button
	private static final By2 editText = new By2("'Edit' text", By.xpath("//div[contains(text(),'Edit')]"));

	// Line of new created test
	//private static final By2 newTestLine = new By2("'Test created in grid'", By.cssSelector("a.stm-tst-row-"+MainConfig.StormRunnerTestName));
	private static final By2 newTestLine = new By2("'Test created in grid'", By.xpath("//a[contains(text(),\'"+MainConfig.StormRunnerTestName+"\')]"));

	// 'Delete' Button
	private static final By2 deleteButton = new By2("'Delete' button", By.cssSelector("div.stm-tst-delete"));

	// 'Delete' button in Confirmation dialog
	private static final By2 deleteButtonInConfirmationDialog = new By2("'Delete' button in confirmation dialog", By.cssSelector("div.stm-tst-Delete"));


	//getting all lines of 
	private static final By2 allTestsRows = new By2("Getting all tests rows", By.xpath("//a[contains(@class,'stm-tst-row')]"));

	


	//"a.stm-tst-row-This-is-an-Automated-Test----"
	//WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));


	public StormRunnerLoadTestsPage(WebDriver driver) throws Exception {
		//super(driver, loadTestsTab,createButton);
		//super(driver,createButton);
		//super(driver,testNameHeader);
		//super(driver,toolBar);
		super(driver,createText,editText);

	}


	// StornRunner - Write the Test name field
	public void writeToTestNameField(String userTestNameInput) {
		bot.writeToElement(testNameInput, userTestNameInput);
	}



	public void writeToDescriptionField(String descriptionInput) {
		// TODO Auto-generated method stub
		bot.writeToElement(descriptionField, descriptionInput);
	}

	public StormRunnerCreateTestPage clickOnCreateButton () throws Exception{
		bot.click(createText);
		return new StormRunnerCreateTestPage(driver);
	}

	// Clicking 'Delete' button for deleting a test
	public StormRunnerCreateTestPage clickOnDeleteButton () throws Exception{
		bot.click(deleteButton);
		return new StormRunnerCreateTestPage(driver);
	}

	// Clicking on 'Delete' in Confirmation message
	public StormRunnerCreateTestPage clickOnDeleteButtonInConfirmationDialog () throws Exception{
		bot.click(deleteButtonInConfirmationDialog);
		return new StormRunnerCreateTestPage(driver);
	}


	public static String getNewAddedTest() {
		String actualNewAddedTest = bot.getElementText(newTestLine);
		return actualNewAddedTest;
	}

	
	public boolean IsTestExistInGrid(String testName){
		Boolean isTestExist = bot.isTextExistInColumn(driver, allTestsRows, testName);
		return isTestExist;
	}
	
	

	//			public StormRunnerHomePage clickLaunchButton() throws Exception{
	//				bot.click(launchButton);
	//				TabAndIframeUtils.switchToTabByTitle(driver, "Home", 15000);
	//				return new StormRunnerHomePage(driver); 
	//			}


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
