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

public class CheckingLoadTestDistribution extends AbstractTest {

	@Test
	public void _006_CheckingLoadTestDistribution() throws Exception {


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

		//-------------------- new distribution-------------------------

		// Clicking on "Scripts" tab
		report.startLevel("Step 10 - Clicking 'Scripts' tab for adding a script to the test");
		stormRunnerCreateTestPage.clickOnScriptsTab();
		report.endLevel();

		// Clicking on 'Add from Assets' button to add a script
		report.startLevel("Step 11 - Clicking 'Add' button to add a script from list of scripts");
		stormRunnerCreateTestPage.clickOnAddFromAssetsButton();
		report.endLevel();

		//Selecting one script from 'Scripts' dialog
		report.startLevel("Step 12 - Selecting first script from the list of scripts");
		//stormRunnerCreateTestPage.clickOnScript(MainConfig.StormRunnerScriptName);
		stormRunnerCreateTestPage.clickOnScript();
		report.endLevel();
/*
		//Click on 'Add' to add the script to the test
		report.startLevel("Step 13 - Clicking 'Add' to add the script to the test");
		stormRunnerCreateTestPage.clickAddScriptInScriptsDialog();
		report.endLevel();

		//Click on 'Distribution' tab in left menu
		report.startLevel("Step 14 - Clicking 'Distribution' tab in left menu");
		stormRunnerCreateTestPage.clickOnDistributionTab();
		report.endLevel();

		//Click on 'Edit Locations' button
		report.startLevel("Step 15 - Clicking 'Edit Locations' button");
		stormRunnerCreateTestPage.clickOnEditLocationsButton();
		report.endLevel();

		//Selecting 'Mumbai' region
		report.startLevel("Step 16 - Selecting 'Mumbai' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("Mumbai");
		report.endLevel();

		//Selecting 'California' region
		report.startLevel("Step 17 - Selecting 'California' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("California");
		report.endLevel();

		//Selecting 'Ireland' region
		report.startLevel("Step 18 - Selecting 'Ireland' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("Ireland");
		report.endLevel();

		//Clicking 'OK' to add all selected locations to Distribution
		report.startLevel("Step 19 - Clicking 'OK' to add all selected regions to distribution");
		stormRunnerCreateTestPage.clickOkInCloudLocationsDialog();
		report.endLevel();

		//Entering % of distribution to 'Mumbai' region
		report.startLevel("Step 20 - Entering % of distribution to 'Mumbai' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("Mumbai",20);
		report.endLevel();

		//Entering % of distribution to 'California' region
		report.startLevel("Step 21 - Entering % of distribution to 'California' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("California",30);
		report.endLevel();

		//Entering % of distribution to 'Ireland' region
		report.startLevel("Step 22 - Entering % of distribution to 'Ireland' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("Ireland",50);
		report.endLevel();

		//Verify 'Run Test' button is DISABLED and has relevant tooltip
		report.startLevel("Step 23 - Verify 'Run Test' button is DISABLED and has relevant tooltip");
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getRunTestTitle(), MainConfig.StormRunner_DisabledRunTestTitle, "'Run Test' Title should be: " + MainConfig.StormRunner_DisabledRunTestTitle, true);
		report.endLevel();

		//Clicking 'OK' to add all selected locations to Distribution
		report.startLevel("Step 24 - Clicking 'OK' to add all selected regions to distribution");
		stormRunnerCreateTestPage.deletingRegionFromTestDistribution("Virginia");
		report.endLevel();

		//Verify 'Run Test' button is ENABLED and has relevant tooltip
		report.startLevel("Step 25 - Verify 'Run Test' button is ENABLED and has relevant tooltip");
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getRunTestTitle(), MainConfig.StormRunner_EnabledRunTestTitle, "'Run Test' Title should be: " + MainConfig.StormRunner_EnabledRunTestTitle, true);
		report.endLevel();





		//---------------------------  End of new

		//Moving to "Load Tests" tab to view all list of tests
		report.startLevel("Step 26 - Moving back to the list of ALL load tests");
		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);
		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
		report.endLevel();

		//Verifying a new test line is added to the grid
		report.startLevel("Step 27 - Verifying that the new load test was added successfully");
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
		report.endLevel();

		//Clicking 'Delete' Button for deleting a test
		report.startLevel("Step 28 - Clicking the 'Delete' button for deleting the test");
		stormRunnerLoadTestsPage.clickOnDeleteButton();
		report.endLevel();

		// Clicking on 'Delete' in Confirmation message
		report.startLevel("Step 29 - Clicking the 'Delete' button for confirming the deletion");
		stormRunnerLoadTestsPage.clickOnDeleteButtonInConfirmationDialog();
		report.endLevel();

		// Verify that the test was deleted successfully
		report.startLevel("Step 30 - Verifying that the test was deleted successfully and doesn't appear in the grid");
		Thread.sleep(2000);
		stormRunnerLoadTestsPage.IsTestExistInGrid(MainConfig.StormRunnerTestName);
		report.endLevel();
*/

	}
}
