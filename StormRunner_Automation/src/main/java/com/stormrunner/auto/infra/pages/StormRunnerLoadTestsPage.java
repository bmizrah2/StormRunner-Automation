package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;

public class StormRunnerLoadTestsPage extends AbstractPage {


	//Clicking Load Tests tab by css selector  ($$("a.stm-tst-home"))
	private static final By2 loadTestsTab = new By2("Clicking 'Load Tests' tab", By.cssSelector("a.stm-tst-load-tests"));

	//"Create" button by CSS
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
	private static final By2 newTestLine = new By2("'Test created in grid'", By.xpath("//a[contains(text(),\'"+MainConfig.StormRunnerTestName+"\')]"));

	// 'Delete' Button
	private static final By2 deleteButton = new By2("'Delete' button", By.cssSelector("div.stm-tst-delete"));

	// 'Delete' button in Confirmation dialog
	private static final By2 deleteButtonInConfirmationDialog = new By2("'Delete' button in confirmation dialog", By.cssSelector("div.stm-tst-Delete"));

	//getting all lines of tests
	private static final By2 allTestsRows = new By2("Getting all monitors rows", By.xpath("//a[contains(@class,'stm-tst-row')]"));


	// Constructor
	public StormRunnerLoadTestsPage(WebDriver driver) throws Exception {
		super(driver,createText,editText);
	}


	// Write to Test name field
	public void writeToTestNameField(String userTestNameInput) {
		bot.writeToElement(testNameInput, userTestNameInput);
	}

	// Write to test 'Description' field 
	public void writeToDescriptionField(String descriptionInput) {
		// TODO Auto-generated method stub
		bot.writeToElement(descriptionField, descriptionInput);
	}

	// Clicking on 'Create'
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

	// Get the new added Test name
	public static String getNewAddedTest() {
		String actualNewAddedTest = bot.getElementText(newTestLine);
		return actualNewAddedTest;
	}

	// Check if test exist in grid
	public boolean isTestExistInGrid(String testName) throws Exception{
		Boolean isTestExist = bot.isTextExistInColumn(driver, allTestsRows, testName);
		return isTestExist;
	}



}
