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

public class CreatingAndDeletingNewLoadTest extends AbstractTest {

	@Test
	public void _002_CreatingAndDeletingLoadTest() throws Exception {

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


		//Step 8 - Entering Test name (from MainConfig file)
		report.startLevel("Step 8 - Entering Test name");
		stormRunnerCreateTestPage.writeToTestNameField(MainConfig.StormRunnerTestName);
		report.endLevel();

		//Step 9 - Entering Description to the test (from MainConfig file)
		report.startLevel("Step 9 - Entering Description to the test");
		stormRunnerCreateTestPage.writeToDescriptionField(MainConfig.StormRunnerTestDescription);
		report.endLevel();

		//Step 10 - Moving back to the list of ALL load tests
		report.startLevel("Step 10 - Moving back to the list of ALL load tests");
		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);
		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
		report.endLevel();

		//Step 11 - Verifying that the new load test was added successfully
		report.startLevel("Step 11 - Verifying that the new load test was added successfully");
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
		report.endLevel();

		//Step 12 - Clicking the 'Delete' button for deleting the test
		report.startLevel("Step 12 - Clicking the 'Delete' button for deleting the test");
		stormRunnerLoadTestsPage.clickOnDeleteButton();
		report.endLevel();

		// Step 13 - Clicking the 'Delete' button for confirming the deletion
		report.startLevel("Step 13 - Clicking the 'Delete' button for confirming the deletion");
		stormRunnerLoadTestsPage.clickOnDeleteButtonInConfirmationDialog();
		report.endLevel();

		// Step 14 - Verifying that the test was deleted successfully and doesn't appear in the grid
		report.startLevel("Step 14 - Verifying that the test was deleted successfully and doesn't appear in the grid");
		Thread.sleep(2000);
		stormRunnerLoadTestsPage.isTestExistInGrid(MainConfig.StormRunnerTestName);
		report.endLevel();


	}
}
