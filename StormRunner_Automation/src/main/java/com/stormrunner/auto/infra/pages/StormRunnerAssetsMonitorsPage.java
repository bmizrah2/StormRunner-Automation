package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.web.By2;

public class StormRunnerAssetsMonitorsPage extends AbstractPage {

	// constructor for AssetsMonitors page
	public StormRunnerAssetsMonitorsPage(WebDriver driver) throws Exception {
		super(driver,createMonitorButton);
	}

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
	
	// For Checking the checkbox of Monitor for deletion
	private static final By2 checkingMonitorForDeletion = new By2("Clicking the checkbox of the monitor for deletion", By.cssSelector("div.stm-tst-row-"+ monitorName));

	// Pressing 'yes' in confirmation dialog for deleting the monitor
	private static final By2 yesButtonInConfirmMonitorDeletion = new By2("'Yes' button in confirmation dialog for deleting the monitor", By.cssSelector("div.stm-tst-Yes"));

	// MONITORS link in upper menu in ASSETS tab
	private static final By2 monitorsLinkInUpperTab = new By2("'monitors' link in upper menu", By.cssSelector("div.stm-tst-monitor-tab"));

	// 'New Monitor' title 
	private static final By2 newMonitorTitle = new By2("The new Monitor title", By.xpath("//div[@title='"+MainConfig.StormRunnerSitescopeServerName+"']"));

	// Get all lines of monitors
	private static final By2 allMonitorsRows = new By2("Getting all monitors rows", By.xpath("//div[contains(@class,'ui-grid-coluiGrid-0011')]"));



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
	}

	// Click on the Sitescope monitor row for deletion
	public void clickOnMonitorForDeletion() throws Exception{
		bot.moveToElementAndClickIt(checkingMonitorForDeletion);
	}

	// Click on 'Delete' for deleting the Sitescope monitor
	public void clickOnDeleteMonitor() throws Exception{
		bot.click(deleteMonitorButton);
	}

	// Click on 'Yes' for confirming the deletion of the Sitescope monitor
	public void clickOnYesToConfirmDeletionOfMonitor() throws Exception{
		bot.click(yesButtonInConfirmMonitorDeletion);
	}

	// Get title of new monitor
	public String getNewAddedMonitor() {
		String actualNewAddedMonitor = bot.getElementText(newMonitorTitle);
		return actualNewAddedMonitor;
	}

	// Check if monitor exist in grid
	public boolean isMonitorExistInGrid(String monitorName) throws Exception {
		Boolean isMonitorExist = bot.isTextExistInColumn(driver, allMonitorsRows, monitorName);
		return isMonitorExist;
	}


}