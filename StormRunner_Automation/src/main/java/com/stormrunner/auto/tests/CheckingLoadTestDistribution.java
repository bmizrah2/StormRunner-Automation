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


		//Step 1 - Browse to 'home.software.microfocus.com' Login page
		report.startLevel("Step 1 - Browse to 'home.software.microfocus.com' Login page");
		browseToUrl(MainConfig.StormRunnerURL);
		StormRunnerLoginPage stormRunnerLoginPage = new StormRunnerLoginPage(driver);
		report.endLevel();


		// Step 2 - Entering user name as part of login to StormRunner (System Env. : SEL_USERNAME)
		report.startLevel("Step 2 - Entering User name as part of the login");
		stormRunnerLoginPage.writeToUserNameField(System.getenv("SEL_USERNAME"));
		stormRunnerLoginPage.clickOnContinueButton();
		report.endLevel();


		// Step 3 - Entering Password as part of the login (System Env. : SEL_PASSWORD)
		report.startLevel("Step 3 - Entering Password as part of the login");
		stormRunnerLoginPage.writeToPasswordField(System.getenv("SEL_PASSWORD"));
		stormRunnerLoginPage.clickOnSignIn();
		report.endLevel();


		// Step 4 - Verify that the account name is : "Benny Java Automation"
		report.startLevel("Step 4 - Verifying that the account name is : 'Benny Java Automation'");
		AssertUtils.assertEquals(MyAccountPage.getAccountName(),MainConfig.StormRunnerAccountName, "Account Name should be: '"+MainConfig.StormRunnerAccountName+"'",true);
		report.endLevel();


		// Step 5 - Moving to new opened Tab after clicking 'Launch'
		report.startLevel("Step 5 - Moving to new opened Tab after clicking 'Launch'");
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		StormRunnerHomePage stormRunnerHomePage = myAccountPage.clickLaunchButton();
		stormRunnerHomePage.waitToHomePageToBeVisible();
		report.endLevel();


		// Step 6 - Clicking on 'Load Tests' tab
		report.startLevel("Step 6 - Clicking on 'Load Tests' tab");
		StormRunnerLoadTestsPage stormRunnerLoadTestsPage = stormRunnerHomePage.clickLoadTestsMenuLink();
		report.endLevel();


		// Step 7 - Clicking on 'Create' button for creating a new test
		report.startLevel("Step 7 - Clicking on 'Create' button for creating a new test");
		StormRunnerCreateTestPage stormRunnerCreateTestPage = stormRunnerLoadTestsPage.clickOnCreateButton();
		report.endLevel();


		// Step 8 - Entering Load Test Name
		report.startLevel("Step 8 - Entering Load Test Name");
		stormRunnerCreateTestPage.writeToTestNameField(MainConfig.StormRunnerTestName);
		report.endLevel();


		// Step 9 - Entering Load Test Description
		report.startLevel("Step 9 - Entering Load Test Description");
		stormRunnerCreateTestPage.writeToDescriptionField(MainConfig.StormRunnerTestDescription);
		report.endLevel();

		//-------------------- Adding a script to the test -------------------------

		// Step 10 - Clicking 'Scripts' tab for adding a script to the test
		report.startLevel("Step 10 - Clicking 'Scripts' tab for adding a script to the test");
		stormRunnerCreateTestPage.clickOnScriptsTab();
		report.endLevel();

		
		// Step 11 - Clicking 'Add from Assets' button to open the list of scripts
		report.startLevel("Step 11 - Clicking 'Add from Assets' button to open the list of scripts");
		stormRunnerCreateTestPage.clickOnAddFromAssetsButton();
		report.endLevel();

		
		// Step 12 - Selecting a script from the list of scripts
		report.startLevel("Step 12 - Selecting a script from the list of scripts");
		//stormRunnerCreateTestPage.clickOnScript(MainConfig.StormRunnerScriptName);
		stormRunnerCreateTestPage.clickOnScriptInScriptsDialog(MainConfig.StormRunnerScriptName);
		report.endLevel();

		
		// Step 13 - Clicking 'Add' to add the selected script to the test
		report.startLevel("Step 13 - Clicking 'Add' to add the selected script to the test");
		stormRunnerCreateTestPage.clickAddScriptInScriptsDialog();
		Thread.sleep(1000);
		report.endLevel();

		// ------------  Setting Distribution -------------------
		
		// Step 14 - Clicking 'Distribution' tab in left menu
		report.startLevel("Step 14 - Clicking 'Distribution' tab in left menu");
		stormRunnerCreateTestPage.clickOnDistributionTab();
		report.endLevel();

		
		// Step 15 - Clicking 'Edit Locations' button
		report.startLevel("Step 15 - Clicking 'Edit Locations' button");
		stormRunnerCreateTestPage.clickOnEditLocationsButton();
		report.endLevel();

		
		// Step 16 - Selecting 'Mumbai' region
		report.startLevel("Step 16 - Selecting 'Mumbai' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("Mumbai");
		report.endLevel();

		
		// Step 17 - Selecting 'California' region
		report.startLevel("Step 17 - Selecting 'California' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("California");
		report.endLevel();

		
		// Step 18 - Selecting 'Ireland' region
		report.startLevel("Step 18 - Selecting 'Ireland' region");
		stormRunnerCreateTestPage.selectingRegionFromCloudLocations("Ireland");
		report.endLevel();

		
		// Step 19 - Clicking 'OK' to add all selected regions to distribution
		report.startLevel("Step 19 - Clicking 'OK' to add all selected regions to distribution");
		stormRunnerCreateTestPage.clickOkInCloudLocationsDialog();
		report.endLevel();

		
		// Step 20 - Entering 20% of distribution to 'Mumbai' region
		report.startLevel("Step 20 - Entering 20% of distribution to 'Mumbai' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("Mumbai",20);
		report.endLevel();

		
		// Step 21 - Entering 30% of distribution to 'California' region
		report.startLevel("Step 21 - Entering 30% of distribution to 'California' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("California",30);
		report.endLevel();

		
		// Step 22 - Entering 50% of distribution to 'Ireland' region
		report.startLevel("Step 22 - Entering 50% of distribution to 'Ireland' region");
		stormRunnerCreateTestPage.enterPercentageToRegion("Ireland",50);
		report.endLevel();

		
		// Step 23 - Verify 'Run Test' button is DISABLED and has relevant tooltip
		report.startLevel("Step 23 - Verify 'Run Test' button is DISABLED and has relevant tooltip");
		AssertUtils.assertEquals(StormRunnerCreateTestPage.getRunTestTitle(), MainConfig.StormRunner_DisabledRunTestTitle, "'Run Test' Title should be: " + MainConfig.StormRunner_DisabledRunTestTitle, true);
		report.endLevel();

		
		// Step 24 - Deleting region 'Virginia' with distribution of 100% by clicking 'x' icon-> To stay with total of 100% (Mumbai+California+Ireland)
		report.startLevel("Step 24 - Deleting region 'Virginia' with distribution of 100% by clicking 'x' icon");
		stormRunnerCreateTestPage.deletingRegionFromTestDistribution("Virginia");
		report.endLevel();

		
		// Step 25 - Verify 'Run Test' button is ENABLED and has relevant tooltip
		report.startLevel("Step 25 - Verify 'Run Test' button is ENABLED and has relevant tooltip");
		AssertUtils.assertEquals(StormRunnerCreateTestPage.getRunTestTitle(), MainConfig.StormRunner_EnabledRunTestTitle, "'Run Test' Title should be: " + MainConfig.StormRunner_EnabledRunTestTitle, true);
		report.endLevel();

		// ------------------------- End of Distribution settings -------------------

		// Step 26 - Moving back to the list of ALL load tests
		report.startLevel("Step 26 - Moving back to the list of ALL load tests");
		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);
		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
		report.endLevel();

		
		// Step 27 - Verifying that the new load test was added successfully
		report.startLevel("Step 27 - Verifying that the new load test was added successfully");
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
		report.endLevel();

		
		// Step 28 - Clicking the 'Delete' button for deleting the test
		report.startLevel("Step 28 - Clicking the 'Delete' button for deleting the test");
		stormRunnerLoadTestsPage.clickOnDeleteButton();
		report.endLevel();

		
		// Step 29 - Clicking the 'Delete' button for confirming the deletion
		report.startLevel("Step 29 - Clicking the 'Delete' button for confirming the deletion");
		stormRunnerLoadTestsPage.clickOnDeleteButtonInConfirmationDialog();
		report.endLevel();

		
		// Step 30 - Verifying that the test was deleted successfully and doesn't appear in the grid
		report.startLevel("Step 30 - Verifying that the test was deleted successfully and doesn't appear in the grid");
		Thread.sleep(2500);
		stormRunnerLoadTestsPage.isTestExistInGrid(MainConfig.StormRunnerTestName);
		report.endLevel();


	}
}
