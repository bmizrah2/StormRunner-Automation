package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerAssetsLoadGeneratorsPage extends AbstractPage {

	// constructor for AssetsLoadGenerators page
	public StormRunnerAssetsLoadGeneratorsPage(WebDriver driver) throws Exception {
		super(driver,createLoadGeneratorButton);
	}

		//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	//Create Monitor button
	//private static final By2 createMonitorButton = new By2("Create new monitor", By.cssSelector("div.stm-tst-create"));
	//private static final By2 createLoadGeneratorButton = new By2("Create new Load Generator", By.cssSelector("div.stm-tst-create"));
	private static final By2 createLoadGeneratorButton = new By2("Create new Load Generator", By.id("addLoadGenerator"));
	
	//private static final By2 uploadScriptButton = new By2("Uploading a script", By.id("uploadScript"));

	// SiteScope Monitor option
	//private static final By2 sitescopeMonitorType = new By2("SiteScoe Monitor Type", By.cssSelector("div.stm-tst-sitescope"));

	//For Entering Load Generator name 
	private static final By2 loadGeneratorNameField = new By2("Load Generator Name Field", By.cssSelector("input.stm-tst-textbox-loadGenerator-name"));

	// SiteScope Description field
	private static final By2 loadGeneratorDescriptionField = new By2("Entering Description for Load Generator", By.cssSelector("textarea.stm-tst-textbox-description"));

	// SiteScop User name	
	//private static final By2 sitescopeUserNameField = new By2("Entering User Name to connect SiteScope Monitor", By.cssSelector("input.stm-tst-textbox-user-name"));

	// Clicking "Save" button to create new Load Generator
	private static final By2 saveNewLoadGeneratorButton = new By2("Clicking 'Save' button in New Load Generator dialog", By.cssSelector("button.stm-tst-save-btn"));

	// Clicking "Delete" in main menu for deleting the Load Generator
	private static final By2 deleteLoadGeneratorButton = new By2("Choosing 'Delete' in Main Menu for deleting the Load Generator", By.cssSelector("div.stm-tst-delete"));

	// For replacing all " " & "." to "-" in the class name
	private static String loadGeneratorName = MainConfig.StormRunnerLoadGeneratorName.replace(".", "-").replace(" ", "-");
	
	// For Checking the Load Generator for deletion
	private static final By2 checkingLoadGeneratorForDeletion = new By2("Clicking the checkbox of the Load Generator for deletion", By.cssSelector("div.stm-tst-row-"+ loadGeneratorName));
	
	// Load Generator prefix name
	//private static final By2 allLoadGeneratorsRows = new By2("'All Load Generators lows'", By.cssSelector("div.stm-tst-row-"));
	//private static final By2 allLoadGeneratorsRows = new By2("'All Load Generators lows'", By.xpath("//div[contains(@class,'stm-tst-row-')]"));
	private static final By2 allLoadGeneratorsRows = new By2("'All Load Generators lows'", By.cssSelector(".ui-grid-coluiGrid-0012"));
	//By.xpath("//div[contains(@class,'container')]//div[contains(text(),'WebPageTest report')]")
	
	
	
	// For getting the title of the new added load generator
	private static final By2 loadGeneratorTitle = new By2("'Load Generator name'", By.cssSelector("div.stm-tst-row-"+ loadGeneratorName));
	
	// Pressing 'yes' in confirmation dialog for deleting the load generator
	private static final By2 yesButtonInConfirmLoadGeneratorDeletion = new By2("Clicking 'Yes' button in confirmation dialog for deleting the Load Generator", By.cssSelector("div.stm-tst-Yes"));


	// MONITORS link in upper menu in ASSETS tab
	private static final By2 loadGeneratorsLinkInUpperTab = new By2("Clicking the Load Generators link in upper menu", By.cssSelector("div.stm-tst-lg-tab"));


	
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
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on the Load Generator row for deletion
	public void clickOnLoadGeneratorForDeletion() throws Exception{
		bot.moveToElementAndClickIt(checkingLoadGeneratorForDeletion);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on 'Delete' for deleting the Load Generator server
	public void clickOnDeleteLoadGenerator() throws Exception{
		bot.click(deleteLoadGeneratorButton);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on 'Yes' for confirming the deletion of the Load Generator
	public void clickOnYesToConfirmDeletionOfLoadGenerator() throws Exception{
		bot.click(yesButtonInConfirmLoadGeneratorDeletion);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Getting the Load Generator name from the grid 
	public String getNewAddedLoadGenerator() {
		String actualNewAddedLoadGeneratorTitle = bot.getElementText(loadGeneratorTitle);
		return actualNewAddedLoadGeneratorTitle; 
	}


	public boolean isLoadGeneratorExistInGrid(String loadGeneratorName) throws Exception {
		Boolean isLoadGeneratorExist = bot.isTextExistInColumn(driver, allLoadGeneratorsRows, loadGeneratorName);
		return isLoadGeneratorExist;
	}

	
//	public boolean isMonitorExistInGrid(String monitorName) throws Exception {
//		Boolean isMonitorExist = bot.isTextExistInColumn(driver, allMonitorsRows, monitorName);
//		return isMonitorExist;
//	}

	
//	public String getNewAddedMonitor() {
//		String actualNewAddedMonitor = bot.getElementText(newMonitorTitle);
//		return actualNewAddedMonitor;
//	}


	//	public void moveToCollapseButtonAndClickIt() throws Exception{
	//		bot.moveToElementAndClickIt(collapseLabelsPaneIcon);
	//
	//	}
	//
	//	// Clicking "Create label" button in labels pane
	//	public void clickOnCreateLabelButton() throws Exception{
	//		bot.click(createLabelButton);
	//	}
	//
	//
	//	// StornRunner - Write to LABEL NAME field
	//	public void writeToLabelNameField(String userLabelNameInput) throws Exception {
	//		bot.writeToLabelNameField(labelNameField, userLabelNameInput);
	//
	//	}
	//
	//
	//
	//	// Clicking on "Assign Labels" drop down button
	//	public void clickOnAssignLabelsDropDownButton() throws Exception{
	//		bot.click(assignLabelsIcon);
	//	}
	//
	//
	//	// Clicking on the label's checkbox
	//	public void clickOnLabelCheckbox() throws Exception{
	//		bot.click(newLabelCheckbox);
	//	}
	//
	//	// Click 'Save' for assigning label to script
	//	public void clickSaveAssigningLabelToScript() throws Exception{
	//		bot.click(saveCheckedLabelButton);
	//	}
	//
	//
	//	// Get the expected label name
	//	public static String getLabelName() {
	//		String actualLabelName = bot.getElementText(expectedLabelName);
	//		return actualLabelName;
	//	}
	//
	//
	//	// Click 'drop down menu' for label option
	//	public void clickDropDownMenuOfLabelOptions() throws Exception{
	//		bot.moveToElementAndClickIt(labelDropDownMenu3);
	//	}
	//
	//
	//	// Click 'drop down menu' for label option
	//	public void clickOnRemoveLabelOptionInDropDownMenu() throws Exception{
	//		bot.moveToElementAndClickIt(removeLabelOptionInDropDownMenu);
	//	}
	//
	//
	//	// Click 'drop down menu' for label option
	//	public void clickOnRemoveButtonInRemoveLabelDialog() throws Exception{
	//		bot.click(removeButtonInConfirmationDialog);
	//	}
	//
	//
	//

	//	}


}