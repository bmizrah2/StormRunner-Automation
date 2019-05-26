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
	private static final By2 editLocationsButton = new By2("'Edit Locations' button", By.cssSelector("div.stm-tst-add-Location"));

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

	// Params for creating Advanced Scheduling Scenario
	// Expand script properties
	private static final By2 expandScriptPropertiesIcon = new By2("'Expand Script properties' icon of selected script", By.cssSelector("div.stm-tst-expandable-buttons-cell"));

	// 'Advanced scheduling mode' option 
	private static final By2 advancedSchedulingMode = new By2("'Advanced Scheduling' mode", By.cssSelector("label.stm-tst-select-advanced-mode-label"));

	// 'Edit' button of 'Advanced' mode
	private static final By2 editAdvancedSchedulingMode = new By2("'Edit' button of 'Advanced' mode", By.cssSelector("button.stm-tst-configure-advanced-scheduling"));

	//--------------------
	// 1st 'Ramp up' hours
	private static final By2 rampUpHours = new By2("'Hours' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-hours')]"));

	// 1st 'Ramp up' Minutes
	private static final By2 rampUpMinutes = new By2("'Minutes' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-minutes')]"));

	// 1st 'Ramp up' seconds
	private static final By2 rampUpSeconds = new By2("'Seconds' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-seconds')]"));

	// 1st 'Ramp up' Vusers field
	private static final By2 rampUpVusers = new By2("'Vusers' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-advanced-step-vusers')]"));
	
	// 1st 'Ramp up' Total Vusers field
	private static final By2 rampUpTotalVusers = new By2("'Total Vusers' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-advanced-step-total-vusers')]"));
	
	// ----------
	// 1st 'Duration' hours
	private static final By2 durationHours = new By2("'Hours' of Duration step", By.xpath("//div[contains(text(),'Duration')]//..//..//input[contains(@class,'stm-tst-hours')]"));

	// 1st 'Duration' Minutes
	private static final By2 durationMinutes = new By2("'Minutes' of Duration step", By.xpath("//div[contains(text(),'Duration')]//..//..//input[contains(@class,'stm-tst-minutes')]"));

	// 1st 'Duration' seconds
	private static final By2 durationSeconds = new By2("'Seconds' of Duration step", By.xpath("//div[contains(text(),'Duration')]//..//..//input[contains(@class,'stm-tst-seconds')]"));

	//-----------------
	// 1st 'Tear down' hours
	private static final By2 tearDownHours = new By2("'Hours' of 'Tear down' step", By.xpath("//div[contains(text(),'Tear down')]//..//..//input[contains(@class,'stm-tst-hours')]"));

	// 1st 'Tear down' Minutes
	private static final By2 tearDownMinutes = new By2("'Minutes' of 'Tear down' step", By.xpath("//div[contains(text(),'Tear down')]//..//..//input[contains(@class,'stm-tst-minutes')]"));

	// 1st 'Tear down' seconds
	private static final By2 tearDownSeconds = new By2("'Seconds' of 'Tear down' step", By.xpath("//div[contains(text(),'Tear down')]//..//..//input[contains(@class,'stm-tst-seconds')]"));

	// 1st 'Tear down' Vusers field
	private static final By2 tearDownVusers = new By2("'Vusers' of Tear down step", By.xpath("//div[contains(text(),'Tear down')]//..//..//input[contains(@class,'stm-tst-advanced-step-vusers')]"));

	// 'Apply' button
	private static final By2 applyButtonInSchedulingDialog = new By2("'Apply' button of 'Advanced Scheduling' dialog", By.cssSelector("button.stm-tst-advanced-sch-save-btn"));
	

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

	// Click on 'Expand script properties' icon
	public void clickOnExpandScriptProperties() throws InterruptedException {
		bot.click(expandScriptPropertiesIcon);
	}

	// click 'Advanced' scheduling mode
	public void clickOnAdvancedSchedulingOption() throws InterruptedException {
		bot.click(advancedSchedulingMode);
	}

	// Click 'Edit' advanced scheduling mode
	public void clickOnEditAdvancedSchedulingButton() throws InterruptedException {
		bot.click(editAdvancedSchedulingMode);
	}


	public void enterHoursInterval(String stepName, int numberOfHours) throws InterruptedException{
		By2 hoursIntervalForStep = new By2("Entering number of hours for "+stepName+" step ", By.xpath("//div[contains(text(),'"+stepName+"')]//..//..//input[contains(@class,'stm-tst-hours')]"));
		//private static final By2 rampUpHours = new By2("'Hours' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-hours')]"));
		bot.writeToElement(hoursIntervalForStep, String.valueOf(numberOfHours));
	}


	public void enterMinutesInterval(String stepName, int numberOfMinutes) throws InterruptedException{
		By2 minutesIntervalForStep = new By2("Entering number of Minutes for "+stepName+" step ", By.xpath("//div[contains(text(),'"+stepName+"')]//..//..//input[contains(@class,'stm-tst-minutes')]"));
		//private static final By2 rampUpHours = new By2("'Hours' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-hours')]"));
		bot.writeToElement(minutesIntervalForStep, String.valueOf(numberOfMinutes));
		
	}


	public void enterSecondsInterval(String stepName, int numberOfSeconds) throws InterruptedException{
		By2 secondsIntervalForStep = new By2("Entering number of Seconds for "+stepName+" step ", By.xpath("//div[contains(text(),'"+stepName+"')]//..//..//input[contains(@class,'stm-tst-seconds')]"));
		bot.writeToElement(secondsIntervalForStep, String.valueOf(numberOfSeconds));
		
	}


	public void enterVusers(String stepName, int numberOfVusers) throws InterruptedException{
		By2 vusersForStep = new By2("Entering number of Vusers for "+stepName+" step ", By.xpath("//div[contains(text(),'"+stepName+"')]//..//..//input[contains(@class,'stm-tst-advanced-step-vusers')]"));
		//private static final By2 rampUpVusers = new By2("'Vusers' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-advanced-step-vusers')]"));
		bot.writeToElement(vusersForStep, String.valueOf(numberOfVusers));
	}


	public void enterTotalVusers(String stepName, int numberOfTotalVusers) throws InterruptedException{
		By2 totalVusersForStep = new By2("Entering Total number of Vusers for "+stepName+" step ", By.xpath("//div[contains(text(),'"+stepName+"')]//..//..//input[contains(@class,'stm-tst-advanced-step-total-vusers')]"));
		//private static final By2 rampUpTotalVusers = new By2("'Total Vusers' of Ramp up step", By.xpath("//div[contains(text(),'Ramp up')]//..//..//input[contains(@class,'stm-tst-advanced-step-total-vusers')]"));
		bot.writeToElement(totalVusersForStep, String.valueOf(numberOfTotalVusers));
	}


	public void clickApplyInAdvancedSchedulingDialog() throws InterruptedException {
		bot.click(applyButtonInSchedulingDialog);
	}


	
	
	
	
	


}
