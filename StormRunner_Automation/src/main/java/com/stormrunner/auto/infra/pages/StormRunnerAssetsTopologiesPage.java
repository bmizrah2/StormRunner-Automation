package com.stormrunner.auto.infra.pages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.entities.Topology;
import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerAssetsTopologiesPage extends AbstractPage {

	// constructor for AssetsMonitors page
	public StormRunnerAssetsTopologiesPage(WebDriver driver) throws Exception {
		super(driver,createTopologyButton);
	}

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	//Main identifier when pressing on "Assets" tab --> for constructor
	private static final By2 uploadScriptButton = new By2("Uploading a script", By.id("uploadScript"));

	//Create Topology button
	private static final By2 createTopologyButton = new By2("Create new topology", By.cssSelector("div.stm-tst-create"));

	//Entering Topology name
	private static final By2 topologyNameField = new By2("Topology Name Field", By.cssSelector("input.stm-tst-textbox-name"));

	// Topology Description field
	private static final By2 topologyDescriptionField = new By2("Topology Description field", By.cssSelector("input.stm-tst-textbox-description"));

	//Clicking on monitor to be part of topology 
	private static final By2 monitorForTopology = new By2("Monitor for Topology", By.cssSelector("div.stm-tst-row-2.3.4.5"));

	// Clicking "Save" button to create new Topology
	private static final By2 saveNewTopologyButton = new By2("'Save' button in New Topology dialog", By.cssSelector("button.stm-tst-save-btn"));

	// Clicking "Delete" in main menu for deleting the Topology
	private static final By2 deleteTopologyButton = new By2("'Delete' in Main Menu for deleting the Topology", By.cssSelector("div.stm-tst-delete"));


	// For replacing all " " & "." to "-" in the class name
	private static String topologyName = MainConfig.StormRunnerTopologyName.replace(".", "-").replace(" ", "-");


	// For Checking the Topology checkbox for deleting
	private static final By2 checkingTopologyForDeletion = new By2("Topology checkbox for deletion", By.cssSelector("div.stm-tst-row-"+ topologyName));
	//private static final By2 checkingMonitorForDeletion2 = new By2("Clicking the checkbox of the monitor for deletion", By.cssSelector("input.ng-not-empty"));
	//private static final By2 newTestLine = new By2("'Test created in grid'",                                            

	// Pressing 'yes' in confirmation dialog for deleting the Topology
	private static final By2 yesButtonInConfirmTopologyDeletion = new By2("'Yes' button in confirmation dialog for deleting the Topology", By.cssSelector("div.stm-tst-Yes"));


	// TOPOLOGIES link in upper menu under ASSETS tab
	private static final By2 topologiesLinkInUpperTab = new By2("Topologies link in upper menu", By.cssSelector("div.stm-tst-topologies-tab"));

	// "New Monitor" title of a new Load Generator ==>  $x("//a[@title='New Test']")
	//private static final By2 newMonitorTitle = new By2("The new Monitor title", By.cssSelector(MainConfig.StormRunnerSitescopeServerName));
	//private static final By2 newTopologyTitle = new By2("Topology title", By.xpath("//div[@title='"+MainConfig.StormRunnerTopologyName+"']"));
	//private static final By2 newTopologyTitle = new By2("Topology title", By.xpath("//a[contains(@title,'"+MainConfig.StormRunnerTopologyName+"']"));
	//private static String topologyName = MainConfig.StormRunnerTopologyName.replace(".", "-").replace(" ", "-");
	private static final By2 newTopologyTitle = new By2("Topology title", By.cssSelector("div.stm-tst-row-"+topologyName));

	//Message presented when all topologies are deleted
	//private static final By2 noDataInGridMessage = new By2("'No Data' link", By.xpath("//div[text()='There is no data for this asset.']"));
	private static final By2 noDataInGridMessage = new By2("'No Data' link", By.xpath("//div[contains(text(),'There is no data for this asset.')]"));



	//By.xpath("//div[contains(@class,'modal')]

	// Get all lines of Topologies
	private static final By2 allTopologiesRows = new By2("Getting all Topologies rows", By.xpath("//div[contains(@class,'ui-grid-coluiGrid-00FS')]"));

	//Checking all monitors
	private static final By2 allTopologiesCheckbox = new By2("All Topologies checkbox", By.cssSelector("div.stm-tst-select-all-checkbox"));



	// Click on "Topologies" link in upper menu of Assets tab
	public void clickOnTopologiesLinkInUpperMenu() throws Exception{
		bot.click(topologiesLinkInUpperTab);
	}


	// Click on CREATE new Topology button
	public void clickOnCreateTopologyButton() throws Exception{
		bot.click(createTopologyButton);
	}


	// Enter Topology name
	public void writeToTopologyNameField(String userTopologyNameInput) throws Exception {
		bot.writeToElement(topologyNameField, userTopologyNameInput);
	}


	// Enter Topology Description
	public void writeToTopologyDescriptionField(String userTopologyDescriptionInput) throws Exception {
		bot.writeToElement(topologyDescriptionField, userTopologyDescriptionInput);
	}


	// Click on "Save" in New Topology Dialog
	public void clickOnSaveInNewTopologyDialog() throws Exception{
		bot.click(saveNewTopologyButton);
		Thread.sleep(2000);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on the Topology row for deletion
	public void clickOnTopologyForDeletion() throws Exception{
		bot.moveToElementAndClickIt(checkingTopologyForDeletion);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Click on 'Delete' for deleting the Topology
	public void clickOnDeleteSelectedTopologies() throws Exception{
		bot.click(deleteTopologyButton);
		//	return new StormRunnerAssetsPage(driver);
	}

	// Click on the checkbox of selecting ALL topologies
	public void clickOnCheckboxSelectingAllTopologies() throws Exception{
		bot.click(allTopologiesCheckbox);
	}

	// Click on 'Yes' for confirming the deletion of the Topology
	public void clickOnYesToConfirmDeletionOfTopology() throws Exception{
		bot.click(yesButtonInConfirmTopologyDeletion);
		//	return new StormRunnerAssetsPage(driver);

	}

	// Get topology title
	public String getNewAddedTopology() {
		String actualNewAddedTopology = bot.getElementText(newTopologyTitle);
		return actualNewAddedTopology;
	}

	// Get all lines of topologies
	public boolean isTopologyExistInGrid(String topologyName) throws Exception {
		Boolean isTopologyExist = bot.isTextExistInColumn(driver, allTopologiesRows, topologyName);
		return isTopologyExist;
	}





	public void clickOnMonitorToBePartOfTopology(String monitorName) throws InterruptedException {
		//By2 selectedMonitorName = new By2("Monitor: "+monitorName+"", By.cssSelector("div.stm-tst-row-"+ monitorName));
		//By2 selectedMonitorName = new By2("Monitor: "+monitorName+"", By.xpath("//div[contains(text(),'"+monitorName+"']"));
		By2 selectedMonitorName = new By2("Monitor: "+monitorName+"", By.xpath("//div[contains(@class,'modal')]//div[contains(text(),'"+monitorName+"')]"));
		bot.moveToElementAndClickIt(selectedMonitorName);
	}


	// Getting 'No Data' message
	public Object getNoDataMessage() {
		String actualNoDataMessage = bot.getElementText(noDataInGridMessage);
		return actualNoDataMessage;

	}


	//	public int getNumberOfLinesInFile (String fileName) throws Exception{
	//		return bot.getNumberOfLinesInTopologiesFile(fileName);
	//	}


	//	public int getNumberOfLinesInTopologiesFile(String fileName) throws Exception {
	//
	//		//FileInputStream fstream = new FileInputStream("src/main/resources/config/Topologies.csv");
	//		FileInputStream fileStream = new FileInputStream(fileName);
	//
	//		BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));
	//
	//		int numOfLines = 0;
	//		String line;
	//
	//		ArrayList<Topology> topologies = new ArrayList<Topology>();
	//
	//		while ((line = br.readLine()) != null) {
	//
	//			if (numOfLines > 0) {
	//				String[] splitStr = line.split(",");
	//				Topology topology = new Topology(splitStr[0],splitStr[1]);
	//				topologies.add(topology);
	//			}
	//			numOfLines++;
	//		}
	//		br.close();
	//		
	//		return numOfLines;
	//	}









}