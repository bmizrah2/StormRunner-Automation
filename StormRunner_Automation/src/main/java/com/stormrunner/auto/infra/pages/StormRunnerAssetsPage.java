package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerAssetsPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	//Sending a uniqe element for AssetsPage constructor
	private static final By2 uploadScriptButton = new By2("Uploading a script", By.id("uploadScript"));

	//Clicking Assets tab by css selector  ($$("a.stm-tst-assets"))
	private static final By2 assetsTab = new By2("Clicking 'Assets' tab", By.cssSelector("a.stm-tst-assets"));

	// For clicking "Expand Lables Pane"
	//private static final By2 expandLabelsPaneIcon = new By2("Clicking 'Expand Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-open"));
	//private static final By2 expandLabelsPaneIcon = new By2("Clicking 'Expand Labels Pane' icon", By.id("labels-toggle"));

	// option 2
	private static final By2 expandLabelsPaneIcon = new By2("Clicking 'Expand Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-open"));
	
	// For clicking "Collapse Labels Pane"
	private static final By2 collapseLabelsPaneIcon = new By2("Clicking 'Collapse Labels Pane' icon", By.cssSelector("div.stm-tst-toggle-to-close"));

	// For Clicking "Create label" button
	private static final By2 createLabelButton = new By2("Clicking 'Create Label' button", By.cssSelector("div.stm-tst-create-label"));

	// Label name field in "New Label" dialog
	private static final By2 labelNameField = new By2("Entering 'Label Name' field", By.cssSelector("input.stm-tst-label-name"));

	// For clicking "Save" in the "New Label" dialog
	private static final By2 saveNewLabelButton = new By2("Clicking 'Save' button", By.cssSelector("button.stm-tst-save-btn"));

	// For clicking "Assign Labels" icon
	private static final By2 assignLabelsIcon = new By2("Clicking 'Assign Labels' icon", By.cssSelector("div.stm-tst-assign-labels"));
	//private static final By2 assignLabelsIcon = new By2("Clicking 'Assign Labels' icon", By.id("assign-labels-dropdown"));

	// For clicking the checkbox of the new added label (need to add label name suffix)
	private static final By2 newLabelCheckbox = new By2("Clicking the checkbox of the added label", By.cssSelector("label.stm-tst-checkbox-label-"));

	// "Save" button in the labels drop down list
	private static final By2 saveCheckedLabelButton = new By2("Clicking 'Save' for the checked label", By.cssSelector("div.stm-tst-save-btn"));

	// Clicking the "Drop down" menu of the label in the left pane
	private static final By2 labelDropDownMenu = new By2("Clicking '...' for opening the label's drop down menu", By.cssSelector("div.btn.btn--icon.btn--integrated.dropdown-toggle"));

	// Clicking "Remove" in the drop down menu for removing the label
	private static final By2 removeLabelOptionInDropDownMenu = new By2("Choosing 'Remove' in Drop Down Menu for deleting the label", By.cssSelector("div.stm-tst-remove-label"));

	// Clicking "Remove" button in confirmation dialog for removing the label
	private static final By2 removeButtonInConfirmationDialog = new By2("Clicking 'Remove' in confirmation dialog for removing the label", By.cssSelector("button.stm-tst-btn-primary"));

	// Expanding the Labels pane
	public void clickOnExpandLabelsPaneIcon() throws Exception{
		bot.click(expandLabelsPaneIcon);
	}

	// Collapsing the Labels pane
	public void clickOnCollapseLabelsPaneIcon() throws Exception{
		bot.click(collapseLabelsPaneIcon);
	}

	

	// Clicking "Create label" button in labels pane
	public void clickOnCreateLabelButton() throws Exception{
		bot.click(createLabelButton);
	}


	// StornRunner - Write to LABEL NAME field
	public void writeToLabelNameField(String userLabelNameInput) {
		bot.writeToElement(labelNameField, userLabelNameInput);
	}

	// Click on "Save" in "New Label" dialog
	public void clickOnSaveInNewLabelDialog() throws Exception{
		bot.click(saveNewLabelButton);
	}

	// Clicking on "Assign Labels" drop down button
	public void clickOnAssignLabelsDropDownButton() throws Exception{
		bot.click(assignLabelsIcon);
	}



	public StormRunnerAssetsPage(WebDriver driver) throws Exception {
		//super(driver, loadTestsTab,createButton);
		//super(driver,createButton);
		//super(driver,testNameHeader);
		//super(driver,toolBar);
		super(driver,uploadScriptButton);

	}


}