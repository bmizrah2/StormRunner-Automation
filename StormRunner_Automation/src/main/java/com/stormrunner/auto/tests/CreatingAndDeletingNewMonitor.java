package com.stormrunner.auto.tests;

import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsMonitorsPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.utils.AssertUtils;

public class CreatingAndDeletingNewMonitor extends AbstractTest {

	@Test
	public void _004_CreatingAndDeletingMonitor() throws Exception {

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


		// Step 6 - Clicking on 'Assets -> Monitors' tab
		report.startLevel("Step 6 - Clicking on 'Assets -> Monitors' tab");
		StormRunnerAssetsMonitorsPage stormRunnerAssetsMonitorsPage = stormRunnerHomePage.clickAssetsMonitorsSubMenuLink();
		report.endLevel();


		// Step 7 - Clicking on 'Create' button for creating new monitor
		report.startLevel("Step 7 - Clicking on 'Create' button");
		stormRunnerAssetsMonitorsPage.clickOnCreateMonitorButton();
		report.endLevel();


		// Step 8 - Choosing 'SiteScope' monitor
		report.startLevel("Step 8 - Choosing 'SiteScope' monitor");
		stormRunnerAssetsMonitorsPage.clickOnSitescopeMonitorType();
		report.endLevel();


		// Step 9 - Entering SiteScope server name in dialog
		report.startLevel("Step 9 - Entering SiteScope server name in dialog");
		stormRunnerAssetsMonitorsPage.writeToSitescopeServerNameField(MainConfig.StormRunnerSitescopeServerName);
		report.endLevel();


		// Step 10 - Entering SiteScope server Description in dialog
		report.startLevel("Step 10 - Entering SiteScope server Description in dialog");
		stormRunnerAssetsMonitorsPage.writeToSitescopeDescriptionField(MainConfig.StormRunnerSitescopeDescription);
		report.endLevel();


		// Step 11 - Entering SiteScope server User Name in dialog
		report.startLevel("Step 11 - Entering SiteScope server User Name in dialog");
		stormRunnerAssetsMonitorsPage.writeToSitescopeUserNameField(MainConfig.StormRunnerSitescopeUserName);
		report.endLevel();


		// Step 12 - Clicking 'Save' for saving the new SiteScope server
		report.startLevel("Step 12 - Clicking 'Save' for saving the new SiteScope server");
		stormRunnerAssetsMonitorsPage.clickOnSaveInNewMonitorDialog();
		report.endLevel();


		// Step 13 - Verifying that the new monitor was added successfully
		report.startLevel("Step 13 - Verifying that the new monitor was added successfully");
		AssertUtils.assertEquals(stormRunnerAssetsMonitorsPage.getNewAddedMonitor(),MainConfig.StormRunnerSitescopeServerName, "Monitor should be: " + MainConfig.StormRunnerSitescopeServerName,true);
		report.endLevel();


		// Step 14 - Checking the checkbox of the new added monitor for deletion
		report.startLevel("Step 14 - Checking the checkbox of the new added monitor for deletion");
		stormRunnerAssetsMonitorsPage.clickOnMonitorForDeletion();
		report.endLevel();


		// Step 15 - Clicking 'Delete' for deleting the monitor
		report.startLevel("Step 15 - Clicking 'Delete' for deleting the monitor");
		stormRunnerAssetsMonitorsPage.clickOnDeleteMonitor();
		report.endLevel();


		// Step 16 - Clicking 'Yes' to confirm deletion of monitor
		report.startLevel("Step 16 - Clicking 'Yes' to confirm deletion of monitor");
		stormRunnerAssetsMonitorsPage.clickOnYesToConfirmDeletionOfMonitor();
		report.endLevel();


		// Step 17 - Verifying that the monitor was deleted successfully and doesn't appear in the grid
		report.startLevel("Step 17 - Verifying that the monitor was deleted successfully and doesn't appear in the grid");
		Thread.sleep(1000);
		stormRunnerAssetsMonitorsPage.isMonitorExistInGrid(MainConfig.StormRunnerSitescopeServerName);
		report.endLevel();
	}

}

