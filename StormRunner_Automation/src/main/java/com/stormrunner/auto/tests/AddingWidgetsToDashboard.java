package com.stormrunner.auto.tests;

import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.pages.StormRunnerResultsPage;
import com.stormrunner.auto.infra.utils.AssertUtils;

public class AddingWidgetsToDashboard extends AbstractTest {

	@Test
	public void _010_AddingWidgetsToDashboard() throws Exception {

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


		// Step 6 - Clicking on 'Results' tab
		report.startLevel("Step 6 - Clicking on 'Results' tab");
		StormRunnerResultsPage stormRunnerResultsPage = stormRunnerHomePage.clickResultsMenuLink();
		report.endLevel();


		// Step 7 - Clicking drop down menu of Run Id 3
		report.startLevel("Step 7 - Clicking drop down menu of Run Id 3");
		stormRunnerResultsPage.clickOnDropDownMenuOfRunId3();
		report.endLevel();


		// Step 8 - Choosing 'Dashboard' option in the menu
		report.startLevel("Step 8 - Choosing 'Dashboard' option in the menu");
		stormRunnerResultsPage.clickOnDashboardOfRunId3();
		report.endLevel();


		// Step 9 - Click on 'Add Widgets' icon to open widgets gallery
		report.startLevel("Step 9 - Click on 'Add Widgets' icon to open widgets gallery");
		//Wait for default widgets to appear in Dashboard
		stormRunnerResultsPage.waitForDefaultWidgetsToBeClickable();
		stormRunnerResultsPage.clickOnAddWidgetsIcon();
		report.endLevel();


		// Step 10 - Click on 'Transactions' tab in left menu of widget gallery
		report.startLevel("Step 10 - Click on 'Transactions' tab");
		stormRunnerResultsPage.clickOnTransactionsTab();
		report.endLevel();


		// Step 11 - Click on 'Go To 2nd Page' transaction
		report.startLevel("Step 11 - Click on 'Go To 2nd Page' transaction");
		//stormRunnerResultsPage.waitForTransGoTo2ndPageToBeClickable();
		stormRunnerResultsPage.clickOnGoTo2ndPageTransaction();
		report.endLevel();

		// Step 12 - Click on 'Back Home' transaction
		report.startLevel("Step 12 - Click on 'Back Home' transaction");
		//stormRunnerResultsPage.waitForTransBackHomeToBeClickable();
		stormRunnerResultsPage.clickOnBackHomeTransaction();
		report.endLevel();


		// Step 13 - Click on 'Add Widgets' icon to close widgets gallery
		report.startLevel("Step 13 - Click on 'Add Widgets' icon to close widgets gallery");
		stormRunnerResultsPage.clickOnAddWidgetsIcon();
		report.endLevel();


		//Step 14 - Verifying that the 2 transactions widgets appear in the Dashboard
		report.startLevel("Step 14 - Verifying that the 2 transactions widgets appear in the Dashboard");
		AssertUtils.assertEquals(stormRunnerResultsPage.getGoTo2ndPageTransWidgetTitle(),MainConfig.StormRunnerGoTo2ndPageTransWidgetTitle, "'Go to 2nd page' Transaction widget title should be: " + MainConfig.StormRunnerGoTo2ndPageTransWidgetTitle,true);
		AssertUtils.assertEquals(stormRunnerResultsPage.getBackHomeTransWidgetTitle(),MainConfig.StormRunnerBackHomeTransWidgetTitle, "'Back Home' Transaction widget title should be: " + MainConfig.StormRunnerBackHomeTransWidgetTitle,true);
		report.endLevel();


		// Step 15 - Removing both 'Go To 2nd Page' & 'Back Home' transactions from dashboard
		report.startLevel("Step 15 - Removing both 'Go To 2nd Page' & 'Back Home' transactions from dashboard");
		stormRunnerResultsPage.clickOnRemoveTransactionWidget("Go to 2nd page");
		stormRunnerResultsPage.clickOnRemoveTransactionWidget("Back Home");
		report.endLevel();

		// Step 16 - Verify both transactions were deleted from Dashboard
		report.startLevel("Step 16 - Verify both transactions were deleted from Dashboard");
		Thread.sleep(1000);
		stormRunnerResultsPage.isGoTo2ndPageTransExistInDashboard();
		stormRunnerResultsPage.isBackHomeTransExistInDashboard();
		report.endLevel();


	}
}
