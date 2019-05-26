package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerAssetsScriptsPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	//Sending a uniqe element for AssetsPage constructor
	private static final By2 uploadScriptButton = new By2("'Upload' button", By.id("uploadScript"));

	// RTS Button
	//private static final By2 runtimeSettingsButton = new By2("Runtime Settings button", By.id("runtime-settings-btn"));

	//Clicking Assets tab by css selector  ($$("a.stm-tst-assets"))
	private static final By2 assetsTab = new By2("'Assets' tab", By.cssSelector("a.stm-tst-assets"));

	// For clicking "Expand Lables Pane"
	//private static final By2 expandLabelsPaneIcon = new By2("Clicking 'Expand Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-open"));
	//private static final By2 expandLabelsPaneIcon = new By2("Clicking 'Expand Labels Pane' icon", By.id("labels-toggle"));

	// option 2
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
	//private static final By2 assignLabelsIcon = new By2("Clicking 'Assign Labels' icon", By.id("assign-labels-dropdown"));

	// For clicking the checkbox of the new added label (need to add label name suffix)
	//private static final By2 newLabelCheckbox = new By2("Clicking the checkbox of the added label", By.cssSelector("label.stm-tst-checkbox-label-This-is-an-automated-LABEL-NAME"));
	private static final By2 newLabelCheckbox = new By2("checkbox of the added label", By.cssSelector("label.stm-tst-checkbox-label-"+ MainConfig.StormRunnerLabelName));

	// "Save" button in the labels drop down list
	private static final By2 saveCheckedLabelButton = new By2("'Save' for the checked label", By.cssSelector("div.stm-tst-save-btn"));

	// Clicking the "Drop down" menu of the label in the left pane
	private static final By2 labelDropDownMenu = new By2("'...' for opening the label's drop down menu", By.cssSelector("div.btn.btn--icon.btn--integrated.dropdown-toggle"));

	//option2 - label drop down menu of new added label
	private static final By2 labelDropDownMenu2 = new By2("'...' for opening the label's drop down menu", By.xpath("//div[contains(@class,'stm-tst-label-toggleMenu-drop')][2]"));

	// option3 - label drop down of ...
	private static final By2 labelDropDownMenu3 = new By2("'...' for opening the label's drop down menu", By.xpath("//div[contains(text(),'StormRunner_Label')]/../..//div[contains(@class,'stm-tst-label-toggleMenu-drop')]"));

	
	//Label assigned for a script in a row
	private static final By2 labelAssignedInRow = new By2("Label assigned to a script in a row", By.cssSelector("div.stm-tst-row-"+MainConfig.StormRunnerLabelName));
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
		//	return new stormRunnerAssetsPage(driver);
	}

	// option 2 to move and then click
	public void moveToExpandButtonAndClickIt() throws Exception{
		bot.moveToElementAndClickIt(expandLabelsPaneIcon);

	}

	public void moveToCollapseButtonAndClickIt() throws Exception{
		bot.moveToElementAndClickIt(collapseLabelsPaneIcon);

	}

	// Clicking "Create label" button in labels pane
	public void clickOnCreateLabelButton() throws Exception{
		bot.click(createLabelButton);
	}


	// StornRunner - Write to LABEL NAME field
	public void writeToLabelNameField(String userLabelNameInput) throws Exception {
		bot.writeToLabelNameField(labelNameField, userLabelNameInput);

	}

	// Click on "Save" in "New Label" dialog
	public void clickOnSaveInNewLabelDialog() throws Exception{
		bot.click(saveNewLabelButton);
		//	return new stormRunnerAssetsPage(driver);

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


	// Click 'drop down menu' for label option
	public void clickOnRemoveLabelOptionInDropDownMenu() throws Exception{
		bot.moveToElementAndClickIt(removeLabelOptionInDropDownMenu);
	}


	// Click 'drop down menu' for label option
	public void clickOnRemoveButtonInRemoveLabelDialog() throws Exception{
		bot.click(removeButtonInConfirmationDialog);
	}

	


	public StormRunnerAssetsScriptsPage(WebDriver driver) throws Exception {
		//super(driver, loadTestsTab,createButton);
		//super(driver,createButton);
		//super(driver,testNameHeader);
		//super(driver,toolBar);
		super(driver,uploadScriptButton);

	}


	public Boolean isLabelExistInGrid(String labelName) throws Exception {
		Boolean isLabelExist = bot.isTextExistInColumn(driver, allLabelsRows, labelName);
		return isLabelExist;
	}
	


}