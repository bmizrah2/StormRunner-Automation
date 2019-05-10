package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerCreateTestPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	//Clicking Load Tests tab by css selector  ($$("a.stm-tst-home"))
	private static final By2 loadTestsTab = new By2("Clicking 'Load Tests' tab", By.cssSelector("a.stm-tst-load-tests"));

	//"Create" button by css selector $$("div.stm-tst-create")
	//private static final By2 createButton = new By2("Clicking 'Create' button", By.id("div.stm-tst-create"));

	//"Create" by CSS
	private static final By2 createButton = new By2("Clicking 'Create' button", By.cssSelector("div.stm-tst-create"));

	// Test name input field
	private static final By2 testNameInput = new By2("Entering new Test Name", By.cssSelector("input.stm-tst-test-name-header"));

	// Description field
	private static final By2 descriptionField = new By2("Entering new Test Name", By.cssSelector("textarea.stm-tst-edit-description"));

	// TEST NAME column header
	private static final By2 testNameHeader = new By2("TEST NAME column header ", By.xpath("//div[@title='TEST NAME']"));

	// Tool Bar
	private static final By2 toolBar = new By2("Tool Bar exist ", By.xpath("//div[@class='stm-tst-tool-bar']"));

	// Create text of the button
	private static final By2 createText = new By2("'Create' text", By.xpath("//div[contains(text(),'Create')]"));

	// Edit text of the button
	private static final By2 editText = new By2("'Edit' text", By.xpath("//div[contains(text(),'Edit')]"));

	// "New TEst" title of a new Test ==>  $x("//a[@title='New Test']")
	private static final By2 newTestTitle = new By2("'New Test' Title", By.xpath("//a[@title='New Test']"));

	//Distribution tab in left pane menu
	private static final By2 distributionTab = new By2("'Distribution' tab in left menu", By.cssSelector("div.stm-tst-distribution-tab"));

	//'Edit Locations' button in Distribution tab
	private static final By2 editLocationsButton = new By2("Entering new Test Name", By.cssSelector("div.stm-tst-add-Location"));

	//For selecting 'Mumbai' region
	private static final By2 mumbaiRegionInCloudLocations = new By2("Selecting 'Mumbai' region", By.xpath("//div[contains(text(),'Mumbai')]"));

	//For selecting 'California' region
	private static final By2 californiaRegionInCloudLocations = new By2("Selecting 'California' region", By.xpath("//div[contains(text(),'California')]"));

	//For selecting 'Ireland' region
	private static final By2 irelandRegionInCloudLocations = new By2("Selecting 'Ireland' region", By.xpath("//div[contains(text(),'Ireland')]"));

	//'OK' button in "Cloud Locations" dialog
	private static final By2 okButtonInCloudLocations = new By2("Clicking 'OK' in 'Cloud Locations' dialog", By.cssSelector("button.stm-tst-btn-primary"));

	// % of total distribution for 'MUMBAI' region
	private static final By2 mumbaiDistributionTotal = new By2("Entering % of distribution for 'Mumbai' region", By.xpath("//td[contains(text(),'Mumbai')]//..//input[contains(@class,'stm-tst-distribution-input')]"));

	// % of total distribution for 'CALIFORNIA' region
	private static final By2 californiaDistributionTotal = new By2("Entering % of distribution for 'California' region", By.xpath("//td[contains(text(),'California')]//..//input[contains(@class,'stm-tst-distribution-input')]"));

	// % of total distribution for 'IRELAND' region
	private static final By2 irelandDistributionTotal = new By2("Entering % of distribution for 'Ireland' region", By.xpath("//td[contains(text(),'Ireland')]//..//input[contains(@class,'stm-tst-distribution-input')]"));

	// % of total distribution for 'VIRGINIA' region
	private static final By2 virginiaDistributionTotal = new By2("Entering % of distribution for 'Virginia' region", By.xpath("//td[contains(text(),'Virginia')]//..//input[contains(@class,'stm-tst-distribution-input')]"));

	// 'Run Test' button
	private static final By2 runTestButton = new By2("'Run Test' button", By.cssSelector("div.stm-tst-run"));

	// 'Remove icon'(x) for Virginia region
	private static final By2 removeVirginiaIcon = new By2("'Remove Icon' (x) for Virginia region", By.xpath("//td[contains(text(),'Virginia')]//..//div[contains(@class,'stm-tst-removeRegion')]"));

	//Scripts tab in left pane menu
	private static final By2 scriptsTab = new By2("'Scripts' tab in left menu", By.cssSelector("div.stm-tst-scripts-tab"));

	//Adding a script to a test from existing repository
	private static final By2 addScriptFromAssetsButton = new By2("'Add from Assets' button", By.cssSelector("button.stm-tst-add-from-repository"));

	//Clicking first script in the grid
	//private static String Name = MainConfig.StormRunnerSitescopeServerName;
	private static final By2 script_1 = new By2("Clicking a script in the grid", By.cssSelector("div.stm-tst-row-12_01_Web_PeaceFul_71_NOV_2016"));
	private static final By2 scriptPrefix = new By2("Clicking a script in the grid", By.cssSelector("div.stm-tst-row-"));

	//Clicking 'Add' for adding the script to the test
	private static final By2 addButtonInScriptsDialog = new By2("'Add' button in 'Scripts' dialog", By.cssSelector("button.stm-tst-btn-primary"));




	//WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));


	public StormRunnerCreateTestPage(WebDriver driver) throws Exception {
		//super(driver, loadTestsTab,createButton);
		//super(driver,createButton);
		//super(driver,testNameHeader);
		//super(driver,toolBar);
		super(driver,newTestTitle);

	}


	// StornRunner - Write the Test name field
	public void writeToTestNameField(String userTestNameInput) {
		bot.writeToElement(testNameInput, userTestNameInput);
	}


	// StormRunner - Write Description to a new test 
	public void writeToDescriptionField(String descriptionInput) {
		bot.writeToElement(descriptionField, descriptionInput);
	}

	// Clicking on 'Scripts' Tab in "Create Load Test"
	public void clickOnScriptsTab() throws Exception {
		bot.click(scriptsTab);
	}

	//Clicking on the 'Add From Assets' button
	public void clickOnAddFromAssetsButton() throws Exception{
		bot.click(addScriptFromAssetsButton);
	}


	public void clickOnScriptInScriptsDialog(String scriptName) throws InterruptedException {
		By2 fullScriptName = new By2("Script: "+scriptName+"", By.cssSelector("div.stm-tst-row-"+ scriptName));
		bot.click(fullScriptName);

	}

	//Clicking 'Add' in 'Scripts' dialog
	public void clickAddScriptInScriptsDialog() throws InterruptedException {
		bot.click(addButtonInScriptsDialog);
	}

	//Clicking 'Distribution' tab in left menu
	public void clickOnDistributionTab() throws InterruptedException {
		bot.click(distributionTab);
	}

	//Clicking 'Edit Locations' button in 'Distribution' page
	public void clickOnEditLocationsButton() throws InterruptedException {
		bot.click(editLocationsButton);
	}

	//Selecting a region from "Cloud Locations" dialog
	public void selectingRegionFromCloudLocations(String regionName) throws InterruptedException {
		By2 selectedRegion = new By2("Selecting"+ regionName + "region", By.xpath("//div[contains(text(),'"+ regionName+"')]"));
		bot.click(selectedRegion);
	}

	// Clicking 'OK' in 'Cloud Locations' dialog
	public void clickOkInCloudLocationsDialog() throws InterruptedException {
		bot.click(okButtonInCloudLocations);
	}


	public void enterPercentageToRegion(String regionName, int percentage) throws InterruptedException {
		By2 regionDistributionTotal = new By2("Entering % of distribution for "+regionName+" region", By.xpath("//td[contains(text(),'"+regionName+"')]//..//input[contains(@class,'stm-tst-distribution-input')]"));
		bot.writeToElement(regionDistributionTotal, String.valueOf(percentage));
	}


	public static String getRunTestTitle() {
		String actualRunTestTitle = bot.getElementTitle(runTestButton);
		return actualRunTestTitle;
	}


	public void deletingRegionFromTestDistribution(String regionName) throws InterruptedException {
		By2 removeSelectedRegion = new By2("'Remove Icon' (x) for "+regionName+" Virginia region", By.xpath("//td[contains(text(),'"+regionName+"')]//..//div[contains(@class,'stm-tst-removeRegion')]"));
		bot.click(removeSelectedRegion);
	}




}
