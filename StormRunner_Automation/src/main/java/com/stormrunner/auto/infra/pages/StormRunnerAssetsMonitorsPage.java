package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerAssetsMonitorsPage extends AbstractPage {

	// constructor for AssetsMonitors page
	public StormRunnerAssetsMonitorsPage(WebDriver driver) throws Exception {
		super(driver,createMonitorButton);
	}

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	//Create Monitor button
	private static final By2 createMonitorButton = new By2("Create new monitor", By.cssSelector("div.stm-tst-create"));
	private static final By2 uploadScriptButton = new By2("Uploading a script", By.id("uploadScript"));



	// SiteScope Monitor option
	private static final By2 sitescopeMonitorType = new By2("SiteScoe Monitor Type", By.cssSelector("div.stm-tst-sitescope"));

	//Clicking on server name field
	private static final By2 sitescopeServerNameField = new By2("SiteScope Server Name Field", By.cssSelector("input.stm-tst-textbox-server-name"));

	// SiteScope Description field
	private static final By2 sitescopeDescriptionField = new By2("Entering Description for SiteScope Monitor", By.cssSelector("textarea.stm-tst-textbox-description"));

	// SiteScop User name	
	private static final By2 sitescopeUserNameField = new By2("Entering User Name to connect SiteScope Monitor", By.cssSelector("input.stm-tst-textbox-user-name"));

	// Clicking "Save" button to create SiteScope monitor
	private static final By2 saveNewMonitorButton = new By2("'Save' button in monitor dialog", By.cssSelector("button.stm-tst-save-btn"));

	// Clicking "Delete" in main menu for deleting the monitor
	private static final By2 deleteMonitorButton = new By2("'Delete' in Main Menu for deleting the Monitor", By.cssSelector("div.stm-tst-delete"));

	// For replacing all " " & "." to "-" in the class name
	private static String monitorName = MainConfig.StormRunnerSitescopeServerName.replace(".", "-").replace(" ", "-");
	// For Checking the Monitor for deleting

	private static final By2 checkingMonitorForDeletion = new By2("Clicking the checkbox of the monitor for deletion", By.cssSelector("div.stm-tst-row-"+ monitorName));
	//private static final By2 checkingMonitorForDeletion2 = new By2("Clicking the checkbox of the monitor for deletion", By.cssSelector("input.ng-not-empty"));
	//private static final By2 newTestLine = new By2("'Test created in grid'",                                            

	// Preesing 'yes' in confirmation dialog for deleting the monitor
	private static final By2 yesButtonInConfirmMonitorDeletion = new By2("'Yes' button in confirmation dialog for deleting the monitor", By.cssSelector("div.stm-tst-Yes"));


	// MONITORS link in upper menu in ASSETS tab
	private static final By2 monitorsLinkInUpperTab = new By2("'monitors' link in upper menu", By.cssSelector("div.stm-tst-monitor-tab"));

	// "New Monitor" title of a new Load Generator ==>  $x("//a[@title='New Test']")
	//private static final By2 newMonitorTitle = new By2("The new Monitor title", By.cssSelector(MainConfig.StormRunnerSitescopeServerName));
	private static final By2 newMonitorTitle = new By2("The new Monitor title", By.xpath("//div[@title='"+MainConfig.StormRunnerSitescopeServerName+"']"));

	// Get all lines of monitors
	private static final By2 allMonitorsRows = new By2("Getting all monitors rows", By.xpath("//div[contains(@class,'ui-grid-coluiGrid-0011')]"));

	
	
	
	
	
	
	// option 2
	//private static final By2 expandLabelsPaneIcon = new By2("Clicking 'Expand Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-open"));

	// For clicking "Collapse Labels Pane"
	//private static final By2 collapseLabelsPaneIcon = new By2("Clicking 'Collapse Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-close"));

	// For Clicking "Create label" button
	//private static final By2 createLabelButton = new By2("Clicking 'Create Label' button", By.cssSelector("div.stm-tst-create-label"));


	// For clicking "Save" in the "New Label" dialog
	//private static final By2 saveNewLabelButton = new By2("Clicking 'Save' button", By.cssSelector("button.stm-tst-save-btn"));

	// For clicking "Assign Labels" icon
	//private static final By2 assignLabelsIcon = new By2("Clicking 'Assign Labels' icon", By.cssSelector("div.stm-tst-assign-labels"));
	//private static final By2 assignLabelsIcon = new By2("Clicking 'Assign Labels' icon", By.id("assign-labels-dropdown"));

	// For clicking the checkbox of the new added label (need to add label name suffix)
	//private static final By2 newLabelCheckbox = new By2("Clicking the checkbox of the added label", By.cssSelector("label.stm-tst-checkbox-label-This-is-an-automated-LABEL-NAME"));
	//private static final By2 newLabelCheckbox = new By2("Clicking the checkbox of the added label", By.cssSelector("label.stm-tst-checkbox-label-"+ MainConfig.StormRunnerLabelName));

	// "Save" button in the labels drop down list
	//private static final By2 saveCheckedLabelButton = new By2("Clicking 'Save' for the checked label", By.cssSelector("div.stm-tst-save-btn"));

	// Clicking the "Drop down" menu of the label in the left pane
	//private static final By2 labelDropDownMenu = new By2("Clicking '...' for opening the label's drop down menu", By.cssSelector("div.btn.btn--icon.btn--integrated.dropdown-toggle"));

	//option2 - label drop down menu of new added label
	//private static final By2 labelDropDownMenu2 = new By2("Clicking '...' for opening the label's drop down menu", By.xpath("//div[contains(@class,'stm-tst-label-toggleMenu-drop')][2]"));

	// option3 - label drop down of ...
	//private static final By2 labelDropDownMenu3 = new By2("Clicking '...' for opening the label's drop down menu", By.xpath("//span[contains(text(),'StormRunner_Label')]/../..//div[contains(@class,'stm-tst-label-toggleMenu-drop')]"));


	//Label assigned for a script in a row
	//private static final By2 labelAssignedInRow = new By2("Label assigned to a script in a row", By.cssSelector("div.stm-tst-row-"+MainConfig.StormRunnerLabelName));
	//private static final By2 expectedLabelName = new By2("The expected label name assigned to a script", By.cssSelector("div.stm-tst-row-"+MainConfig.StormRunnerLabelName));





	// Clicking "Remove" button in confirmation dialog for removing the label
	//private static final By2 removeButtonInConfirmationDialog = new By2("Clicking 'Remove' in confirmation dialog for removing the label", By.cssSelector("button.stm-tst-ok-button"));


	// Click on "Monitors" link in upper menu of Assets tab
	public void clickOnMonitorsLinkInUpperMenu() throws Exception{
		bot.click(monitorsLinkInUpperTab);
	}


	// Click on CREATE new monitor button
	public void clickOnCreateMonitorButton() throws Exception{
		bot.click(createMonitorButton);
	}


	// Click on "SiteScope" monitor type
	public void clickOnSitescopeMonitorType() throws Exception{
		bot.click(sitescopeMonitorType);
	}


	// Enter Sitescope server name field and enter server name
	public void writeToSitescopeServerNameField(String userSitescopeServerNameInput) throws Exception {
		bot.writeToElement(sitescopeServerNameField, userSitescopeServerNameInput);
	}


	// Enter Sitescope Description field and enter description
	public void writeToSitescopeDescriptionField(String userSitescopeDescriptionInput) throws Exception {
		bot.writeToElement(sitescopeDescriptionField, userSitescopeDescriptionInput);
	}

	// Enter Sitescope User Name field and enter user name
	public void writeToSitescopeUserNameField(String userSitescopeUserNameInput) throws Exception {
		bot.writeToElement(sitescopeUserNameField, userSitescopeUserNameInput);
	}

	// Click on "Save" in New SiteScope Monitor Dialog
	public void clickOnSaveInNewMonitorDialog() throws Exception{
		bot.click(saveNewMonitorButton);
		Thread.sleep(2000);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on the Sitescope monitor row for deletion
	public void clickOnMonitorForDeletion() throws Exception{
		bot.moveToElementAndClickIt(checkingMonitorForDeletion);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on 'Delete' for deleting the Sitescope monitor
	public void clickOnDeleteMonitor() throws Exception{
		bot.click(deleteMonitorButton);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on 'Yes' for confirming the deletion of the Sitescope monitor
	public void clickOnYesToConfirmDeletionOfMonitor() throws Exception{
		bot.click(yesButtonInConfirmMonitorDeletion);
		//	return new StormRunnerAssetsPage(driver);

	}


	public String getNewAddedMonitor() {
		String actualNewAddedMonitor = bot.getElementText(newMonitorTitle);
		return actualNewAddedMonitor;
	}


	public boolean isMonitorExistInGrid(String monitorName) throws Exception {
		Boolean isMonitorExist = bot.isTextExistInColumn(driver, allMonitorsRows, monitorName);
		return isMonitorExist;
	}

	
	
	
//	public boolean IsTestExistInGrid(String testName){
//		Boolean isTestExist = bot.isTextExistInColumn(driver, allTestsRows, testName);
//		return isTestExist;
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