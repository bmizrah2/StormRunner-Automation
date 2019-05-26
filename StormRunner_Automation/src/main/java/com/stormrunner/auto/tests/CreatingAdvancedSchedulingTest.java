package com.stormrunner.auto.tests;

import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerCreateTestPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoadTestsPage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.pages.StormRunnerMainMenuPage;
import com.stormrunner.auto.infra.utils.AssertUtils;

public class CreatingAdvancedSchedulingTest extends AbstractTest {

	@Test
	public void _007_CreatingAdvancedSchedulingTest() throws Exception {


		//Navigating to StormRunner Base URL
		report.startLevel("Step 1 - Browse to 'https://home.software.microfocus.com/myaccount' Login page");
		browseToUrl(MainConfig.StormRunnerURL);
		StormRunnerLoginPage stormRunnerLoginPage = new StormRunnerLoginPage(driver);
		report.endLevel();

		//Entering USER NAME as part of login to StormRunner
		report.startLevel("Step 2 - Entering User name as part of the login");
		stormRunnerLoginPage.writeToUserNameField(System.getenv("SEL_USERNAME"));
		stormRunnerLoginPage.clickOnContinueButton();
		report.endLevel();

		//Entering PASSWORD as part of login to StormRunner
		report.startLevel("Step 3 - Entering Password as part of the login");
		stormRunnerLoginPage.writeToPasswordField(System.getenv("SEL_PASSWORD"));
		stormRunnerLoginPage.clickOnSignIn();
		report.endLevel();

		//Verifying we are logged in to the expected account : "Benny Java Automation"
		report.startLevel("Step 4 - Verifying that the account name is : 'Benny Java Automation'");
		AssertUtils.assertEquals(MyAccountPage.getAccountName(),MainConfig.StormRunnerAccountName, "Account Name should be: "+MainConfig.StormRunnerAccountName+"",true);
		report.endLevel();

		//Moving to new opened tab
		report.startLevel("Step 5 - Moving to new opened Tab after clicking 'Launch'");
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		StormRunnerHomePage stormRunnerHomePage = myAccountPage.clickLaunchButton();
		report.endLevel();

		// Click on the "Load Tests" tab
		report.startLevel("Step 6 - Clicking on 'Load Tests' tab");
		StormRunnerLoadTestsPage stormRunnerLoadTestsPage = stormRunnerHomePage.clickLoadTestsMenuLink();
		report.endLevel();

		// clicking on the "Create" button
		report.startLevel("Step 7 - Clicking on 'Create' button for creating a new test");
		StormRunnerCreateTestPage stormRunnerCreateTestPage = stormRunnerLoadTestsPage.clickOnCreateButton();
		report.endLevel();

		//Entering Load Test Name
		report.startLevel("Step 8 - Entering Load Test Name");
		stormRunnerCreateTestPage.writeToTestNameField(MainConfig.StormRunnerTestName);
		report.endLevel();

		//Entering Test Description
		report.startLevel("Step 9 - Entering Load Test Description");
		stormRunnerCreateTestPage.writeToDescriptionField(MainConfig.StormRunnerTestDescription);
		report.endLevel();

		// ------ Adding a script

		// Clicking on "Scripts" tab
		report.startLevel("Step 10 - Clicking 'Scripts' tab for adding a script to the test");
		stormRunnerCreateTestPage.clickOnScriptsTab();
		report.endLevel();

		// Clicking on 'Add from Assets' button to add a script
		report.startLevel("Step 11 - Clicking 'Add from Assets' button to open the list of scripts");
		stormRunnerCreateTestPage.clickOnAddFromAssetsButton();
		report.endLevel();

		//Selecting one script from 'Scripts' dialog
		report.startLevel("Step 12 - Selecting a script from the list of scripts");
		//stormRunnerCreateTestPage.clickOnScript(MainConfig.StormRunnerScriptName);
		stormRunnerCreateTestPage.clickOnScriptInScriptsDialog(MainConfig.StormRunnerScriptName);
		report.endLevel();

		//Click on 'Add' to add the script to the test
		report.startLevel("Step 13 - Clicking 'Add' to add the selected script to the test");
		stormRunnerCreateTestPage.clickAddScriptInScriptsDialog();
		Thread.sleep(1000);
		report.endLevel();

		//---------------------------  Creating Advanced Scheduling Scenario -------------

		//Click on 'Expand Script Properties'
		report.startLevel("Step 14 - Clicking 'Expand Script properties Icon' to open script properties");
		stormRunnerCreateTestPage.clickOnExpandScriptProperties();
		report.endLevel();

		//Click on 'Advanced' option
		report.startLevel("Step 15 - Clicking on 'Advanced scheduling' option");
		stormRunnerCreateTestPage.clickOnAdvancedSchedulingOption();
		report.endLevel();

		//Click on 'Edit' advanced scheduling button
		report.startLevel("Step 16 - Clicking on 'Edit' Advanced scheduling button");
		stormRunnerCreateTestPage.clickOnEditAdvancedSchedulingButton();
		report.endLevel();

// ---

		//Entering 'Hours' Interval for 'Ramp up'
		report.startLevel("Step 17 - Entering Hours interval for 'Ramp up'");
		stormRunnerCreateTestPage.enterHoursInterval("Ramp up",0);
		report.endLevel();

		//Entering 'Minutes' Interval for 'Ramp up'
		report.startLevel("Step 18 - Entering Minutes interval for 'Ramp up'");
		stormRunnerCreateTestPage.enterMinutesInterval("Ramp up",0);
		report.endLevel();

		//Entering 'Seconds' Interval for 'Ramp up'
		report.startLevel("Step 19 - Entering Seconds interval for 'Ramp up'");
		stormRunnerCreateTestPage.enterSecondsInterval("Ramp up",10);
		report.endLevel();

		//Entering 'Vusers' for 'Ramp up'
		report.startLevel("Step 20 - Entering Vusers for 'Ramp up'");
		stormRunnerCreateTestPage.enterVusers("Ramp up",2);
		report.endLevel();

		//Entering 'Total Vusers' for 'Ramp up'
		report.startLevel("Step 21 - Entering Total Vusers for 'Ramp up'");
		stormRunnerCreateTestPage.enterTotalVusers("Ramp up",10);
		report.endLevel();

// ---

		//Entering 'Hours' Interval for 'Duration'
		report.startLevel("Step 22 - Entering Hours interval for 'Duration'");
		stormRunnerCreateTestPage.enterHoursInterval("Duration",0);
		report.endLevel();

		//Entering 'Minutes' Interval for 'Duration'
		report.startLevel("Step 23 - Entering Minutes interval for 'Duration'");
		stormRunnerCreateTestPage.enterMinutesInterval("Duration",5);
		report.endLevel();

		//Entering 'Seconds' Interval for 'Duration'
		report.startLevel("Step 24 - Entering Seconds interval for 'Duration'");
		stormRunnerCreateTestPage.enterSecondsInterval("Duration",0);
		report.endLevel();


// ---


		//Entering 'Hours' Interval for 'Tear down'
		report.startLevel("Step 25 - Entering Hours interval for 'Tear down'");
		stormRunnerCreateTestPage.enterHoursInterval("Tear down",0);
		report.endLevel();

		//Entering 'Minutes' Interval for 'Tear down'
		report.startLevel("Step 26 - Entering Minutes interval for 'Tear down'");
		stormRunnerCreateTestPage.enterMinutesInterval("Tear down",0);
		report.endLevel();

		//Entering 'Seconds' Interval for 'Tear down'
		report.startLevel("Step 27 - Entering Seconds interval for 'Tear down'");
		stormRunnerCreateTestPage.enterSecondsInterval("Tear down",10);
		report.endLevel();

		//Entering 'Vusers' for 'Tear down'
		report.startLevel("Step 28 - Entering Vusers for 'Tear down'");
		stormRunnerCreateTestPage.enterVusers("Tear down",2);
		report.endLevel();

		//Clicking 'Apply' for saving the advanced scheduling settings
		report.startLevel("Step 29 - Clicking 'Apply' for saving the Advanced Scheduling settings");
		stormRunnerCreateTestPage.clickApplyInAdvancedSchedulingDialog();
		Thread.sleep(1500);
		report.endLevel();

		// ------------- End of Advanced Scheduling Scenario ---------------

		
		
		//-------------------- Setting distribution-------------------------

		//Click on 'Distribution' tab in left menu
		report.startLevel("Step 30 - Clicking 'Distribution' tab in left menu");
		stormRunnerCreateTestPage.clickOnDistributionTab();
		report.endLevel();

		//Click on 'Edit Locations' button
		report.startLevel("Step 31 - Clicking 'Edit Locations' button");
		stormRunnerCreateTestPage.clickOnEditLocationsButton();
		report.endLevel();

		//Selecting 'Mumbai' region
		report.startLevel("Step 32 - Selecting 'Mumbai' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("Mumbai");
		report.endLevel();

		//Selecting 'California' region
		report.startLevel("Step 33 - Selecting 'California' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("California");
		report.endLevel();

		//Selecting 'Ireland' region
		report.startLevel("Step 34 - Selecting 'Ireland' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("Ireland");
		report.endLevel();

		//Clicking 'OK' to add all selected locations to Distribution
		report.startLevel("Step 35 - Clicking 'OK' to add all selected regions to distribution");
		stormRunnerCreateTestPage.clickOkInCloudLocationsDialog();
		report.endLevel();

		//Entering 20% of distribution to 'Mumbai' region
		report.startLevel("Step 36 - Entering % of distribution to 'Mumbai' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("Mumbai",20);
		report.endLevel();

		//Entering 30% of distribution to 'California' region
		report.startLevel("Step 37 - Entering % of distribution to 'California' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("California",30);
		report.endLevel();

		//Entering 50% of distribution to 'Ireland' region
		report.startLevel("Step 38 - Entering % of distribution to 'Ireland' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("Ireland",50);
		report.endLevel();

		//Verify 'Run Test' button is DISABLED and has relevant tooltip
		report.startLevel("Step 39 - Verify 'Run Test' button is DISABLED and has relevant tooltip");
		AssertUtils.assertEquals(StormRunnerCreateTestPage.getRunTestTitle(), MainConfig.StormRunner_DisabledRunTestTitle, "'Run Test' Title should be: " + MainConfig.StormRunner_DisabledRunTestTitle, true);
		report.endLevel();

		//Clicking 'OK' to add all selected locations to Distribution
		report.startLevel("Step 40 - Clicking 'OK' to add all selected regions to distribution");
		stormRunnerCreateTestPage.deletingRegionFromTestDistribution("Virginia");
		report.endLevel();

		//Verify 'Run Test' button is ENABLED and has relevant tooltip
		report.startLevel("Step 41 - Verify 'Run Test' button is ENABLED and has relevant tooltip");
		AssertUtils.assertEquals(StormRunnerCreateTestPage.getRunTestTitle(), MainConfig.StormRunner_EnabledRunTestTitle, "'Run Test' Title should be: " + MainConfig.StormRunner_EnabledRunTestTitle, true);
		report.endLevel();


		//---------------------------  End of new distribution ---------------------------



		//Moving to "Load Tests" tab to view all list of tests
		report.startLevel("Step 42 - Moving back to the list of ALL load tests");
		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);
		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
		report.endLevel();

		//Verifying a new test line is added to the grid
		report.startLevel("Step 43 - Verifying that the new load test was added successfully");
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
		report.endLevel();

		//Clicking 'Delete' Button for deleting a test
		report.startLevel("Step 44 - Clicking the 'Delete' button for deleting the test");
		stormRunnerLoadTestsPage.clickOnDeleteButton();
		report.endLevel();

		// Clicking on 'Delete' in Confirmation message
		report.startLevel("Step 45 - Clicking the 'Delete' button for confirming the deletion");
		stormRunnerLoadTestsPage.clickOnDeleteButtonInConfirmationDialog();
		report.endLevel();

		// Verify that the test was deleted successfully
		report.startLevel("Step 46 - Verifying that the test was deleted successfully and doesn't appear in the grid");
		Thread.sleep(2000);
		stormRunnerLoadTestsPage.isTestExistInGrid(MainConfig.StormRunnerTestName);
		report.endLevel();


	}
}
