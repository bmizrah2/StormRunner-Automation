package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;

public class StormRunnerAssetsLoadGeneratorsPage extends AbstractPage {

	// constructor for AssetsLoadGenerators page
	public StormRunnerAssetsLoadGeneratorsPage(WebDriver driver) throws Exception {
		super(driver,createLoadGeneratorButton);
	}


	// 'Create' Load Generator button
	private static final By2 createLoadGeneratorButton = new By2("Create new Load Generator", By.id("addLoadGenerator"));

	// Load Generator name field 
	private static final By2 loadGeneratorNameField = new By2("Load Generator Name Field", By.cssSelector("input.stm-tst-textbox-loadGenerator-name"));

	// Load Generator Description field
	private static final By2 loadGeneratorDescriptionField = new By2("Entering Description for Load Generator", By.cssSelector("textarea.stm-tst-textbox-description"));

	// Clicking "Save" button to create new Load Generator
	private static final By2 saveNewLoadGeneratorButton = new By2("Clicking 'Save' button in New Load Generator dialog", By.cssSelector("button.stm-tst-save-btn"));

	// Clicking "Delete" in main menu for deleting the Load Generator
	private static final By2 deleteLoadGeneratorButton = new By2("Choosing 'Delete' in Main Menu for deleting the Load Generator", By.cssSelector("div.stm-tst-delete"));

	// For replacing all " " & "." to "-" in the class name
	private static String loadGeneratorName = MainConfig.StormRunnerLoadGeneratorName.replace(".", "-").replace(" ", "-");

	// For Checking the Load Generator for deletion
	private static final By2 checkingLoadGeneratorForDeletion = new By2("Clicking the checkbox of the Load Generator for deletion", By.cssSelector("div.stm-tst-row-"+ loadGeneratorName));

	// Load Generator prefix name for getting all rows
	private static final By2 allLoadGeneratorsRows = new By2("'All Load Generators rows'", By.cssSelector(".ui-grid-coluiGrid-0012"));

	// For getting the title of the new added load generator
	private static final By2 loadGeneratorTitle = new By2("'Load Generator name'", By.cssSelector("div.stm-tst-row-"+ loadGeneratorName));

	// Pressing 'yes' in confirmation dialog for deleting the load generator
	private static final By2 yesButtonInConfirmLoadGeneratorDeletion = new By2("Clicking 'Yes' button in confirmation dialog for deleting the Load Generator", By.cssSelector("div.stm-tst-Yes"));

	// MONITORS link in upper menu in ASSETS tab
	private static final By2 loadGeneratorsLinkInUpperTab = new By2("Clicking the Load Generators link in upper menu", By.cssSelector("div.stm-tst-lg-tab"));

	// The 'NAME' header of the the grid
	private static final By2 nameHeaderColumn = new By2("'NAME' header column", By.xpath("//div[contains(@title,'NAME')]"));
	//"//div[contains(@title,'NAME')]"


	// Click on "Load Generators" link in upper menu of Assets tab
	public void clickOnLoadGeneratorsLinkInUpperMenu() throws Exception{
		bot.click(loadGeneratorsLinkInUpperTab);
	}


	// Click on CREATE new monitor button
	public void clickOnCreateLoadGeneratorButton() throws Exception{
		bot.click(createLoadGeneratorButton);
	}


	// Enter Load Generator server name
	public void writeToLoadGeneratorNameField(String userLoadGeneratorNameInput) throws Exception {
		bot.writeToElement(loadGeneratorNameField, userLoadGeneratorNameInput);
	}


	// Enter Load Generator Description
	public void writeToLoadGeneratorDescriptionField(String userLoadGeneratorDescriptionInput) throws Exception {
		bot.writeToElement(loadGeneratorDescriptionField, userLoadGeneratorDescriptionInput);
	}


	// Click on "Save" in New Load Generator Dialog
	public void clickOnSaveInNewLoadGeneratorDialog() throws Exception{
		bot.click(saveNewLoadGeneratorButton);
		Thread.sleep(2000);
	}

	// Click on the Load Generator row for deletion
	public void clickOnLoadGeneratorForDeletion() throws Exception{
		bot.moveToElementAndClickIt(checkingLoadGeneratorForDeletion);
	}

	// Click on 'Delete' for deleting the Load Generator server
	public void clickOnDeleteLoadGenerator() throws Exception{
		bot.click(deleteLoadGeneratorButton);
	}

	// Click on 'Yes' for confirming the deletion of the Load Generator
	public void clickOnYesToConfirmDeletionOfLoadGenerator() throws Exception{
		bot.click(yesButtonInConfirmLoadGeneratorDeletion);
	}

	// Getting the Load Generator name from the grid 
	public String getNewAddedLoadGenerator() {
		String actualNewAddedLoadGeneratorTitle = bot.getElementText(loadGeneratorTitle);
		return actualNewAddedLoadGeneratorTitle; 
	}

	// Check if Load Generator exist in grid
	public boolean isLoadGeneratorExistInGrid(String loadGeneratorName) throws Exception {
		Boolean isLoadGeneratorExist = bot.isTextExistInColumn(driver, allLoadGeneratorsRows, loadGeneratorName);
		return isLoadGeneratorExist;
	}


	// wait for the load generators page to appear	
	public void waitForLoadGeneratorsPageToAppear() {
		bot.waitForElementToBeClickable(nameHeaderColumn);
	}



}