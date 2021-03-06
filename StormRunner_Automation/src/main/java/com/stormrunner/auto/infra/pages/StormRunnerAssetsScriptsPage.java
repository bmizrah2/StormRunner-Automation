package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;

public class StormRunnerAssetsScriptsPage extends AbstractPage {


	//Sending a unique element for AssetsPage constructor
	private static final By2 uploadScriptButton = new By2("'Upload' button", By.id("uploadScript"));

	//Clicking Assets tab by css selector  ($$("a.stm-tst-assets"))
	private static final By2 assetsTab = new By2("'Assets' tab", By.cssSelector("a.stm-tst-assets"));

	// For clicking "Expand Lables Pane"
	private static final By2 expandLabelsPaneIcon = new By2("'Expand Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-open"));

	// For clicking "Collapse Labels Pane"
	private static final By2 collapseLabelsPaneIcon = new By2("'Collapse Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-close"));

	// For Clicking "Create label" button
	private static final By2 createLabelButton = new By2("'Create Label' button", By.cssSelector("div.stm-tst-create-label"));

	// Label name field in "New Label" dialog
	private static final By2 labelNameField = new By2("'Label Name' field", By.cssSelector("input.stm-tst-label-name"));

	// For clicking "Save" in the "New Label" dialog
	private static final By2 saveNewLabelButton = new By2("'Save' button", By.cssSelector("button.stm-tst-save-btn"));

	// For clicking "Assign Labels" icon
	private static final By2 assignLabelsIcon = new By2("'Assign Labels' icon", By.cssSelector("div.stm-tst-assign-labels"));

	// For clicking the checkbox of the new added label (need to add label name suffix)
	private static final By2 newLabelCheckbox = new By2("checkbox of the added label", By.cssSelector("label.stm-tst-checkbox-label-"+ MainConfig.StormRunnerLabelName));

	// 'Save' button in the labels drop down list
	private static final By2 saveCheckedLabelButton = new By2("'Save' for the checked label", By.cssSelector("div.stm-tst-save-btn"));

	// label's drop down of ...
	private static final By2 labelDropDownMenu3 = new By2("'...' for opening the label's drop down menu", By.xpath("//div[contains(text(),'StormRunner_Label')]/../..//div[contains(@class,'stm-tst-label-toggleMenu-drop')]"));

	//Label assigned for a script in a row
	private static final By2 expectedLabelName = new By2("'with the expected label name assigned to a script'", By.cssSelector("div.stm-tst-row-"+MainConfig.StormRunnerLabelName));

	// Clicking "Remove" in the drop down menu for removing the label
	private static final By2 removeLabelOptionInDropDownMenu = new By2("'Remove' in Drop Down Menu for deleting the label", By.xpath("//div[contains(text(),'StormRunner_Label')]/../..//div[contains(@class,'stm-tst-remove-label')]"));

	// Clicking "Remove" button in confirmation dialog for removing the label
	private static final By2 removeButtonInConfirmationDialog = new By2("'Remove' in confirmation dialog for removing the label", By.cssSelector("button.stm-tst-ok-button"));

	// All Labels rows
	private static final By2 allLabelsRows = new By2("All Labels rows", By.cssSelector(".stm-tst-row-labels"));


	// Clicking on "Monitors" link
	public void clickOnMonitorsLinkInUpperMenu() throws Exception{
		bot.click(assetsTab);
	}


	// Expanding the Labels pane
	public void clickOnExpandLabelsPaneIcon() throws Exception{
		bot.click(expandLabelsPaneIcon);
	}

	// Collapsing the Labels pane
	public void clickOnCollapseLabelsPaneIcon() throws Exception{
		bot.click(collapseLabelsPaneIcon);
	}

	// option 2 to move and then click
	public void moveToExpandButtonAndClickIt() throws Exception{
		bot.moveToElementAndClickIt(expandLabelsPaneIcon);

	}

	// Click on 'Collapse' button
	public void moveToCollapseButtonAndClickIt() throws Exception{
		bot.moveToElementAndClickIt(collapseLabelsPaneIcon);

	}

	// Clicking "Create label" button in labels pane
	public void clickOnCreateLabelButton() throws Exception{
		bot.click(createLabelButton);
	}


	// Write to LABEL NAME field
	public void writeToLabelNameField(String userLabelNameInput) throws Exception {
		bot.writeToLabelNameField(labelNameField, userLabelNameInput);

	}

	// Click on "Save" in "New Label" dialog
	public void clickOnSaveInNewLabelDialog() throws Exception{
		bot.click(saveNewLabelButton);

	}

	// Clicking on "Assign Labels" drop down button
	public void clickOnAssignLabelsDropDownButton() throws Exception{
		bot.click(assignLabelsIcon);
	}


	// Clicking on the label's checkbox
	public void clickOnLabelCheckbox() throws Exception{
		bot.click(newLabelCheckbox);
	}

	// Click 'Save' for assigning label to script
	public void clickSaveAssigningLabelToScript() throws Exception{
		bot.click(saveCheckedLabelButton);
	}


	// Get the expected label name
	public String getLabelName() {
		String actualLabelName = bot.getElementText(expectedLabelName);
		return actualLabelName;
	}


	// Click 'drop down menu' for label option
	public void clickDropDownMenuOfLabelOptions() throws Exception{
		bot.moveToElementAndClickIt(labelDropDownMenu3);
	}


	// Click 'Remove' from label's options
	public void clickOnRemoveLabelOptionInDropDownMenu() throws Exception{
		bot.moveToElementAndClickIt(removeLabelOptionInDropDownMenu);
	}


	// Click 'Remove' button in confirmation dialog
	public void clickOnRemoveButtonInRemoveLabelDialog() throws Exception{
		bot.click(removeButtonInConfirmationDialog);
	}



	// Constructor
	public StormRunnerAssetsScriptsPage(WebDriver driver) throws Exception {
		super(driver,uploadScriptButton);

	}

	// Check if label exist in grid
	public Boolean isLabelExistInGrid(String labelName) throws Exception {
		Boolean isLabelExist = bot.isTextExistInColumn(driver, allLabelsRows, labelName);
		return isLabelExist;
	}



}