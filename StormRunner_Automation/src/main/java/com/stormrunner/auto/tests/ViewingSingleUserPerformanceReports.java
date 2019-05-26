package com.stormrunner.auto.tests;

import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.pages.StormRunnerResultsPage;
import com.stormrunner.auto.infra.utils.AssertUtils;

public class ViewingSingleUserPerformanceReports extends AbstractTest {

	@Test
	public void _009_ViewingSingleUserPerformanceReports() throws Exception {

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


		// Step 8 - Choosing 'Single User Performance' option in the menu
		report.startLevel("Step 8 - Choosing 'Single User Performance' option in the menu");
		stormRunnerResultsPage.clickOnSingleUserPerformanceOfRunId3();
		report.endLevel();


		// Step 9 - Entering the inner Iframe to verify 'Client Side Breakdown' title
		report.startLevel("Step 9 - Entering the inner Iframe to verify 'Client Side Breakdown' title");
		StormRunnerResultsPage.moveToClientSideBreakdownHtml(driver);
		report.endLevel();


		// Step 10 - Verifying that the title of the CSB is 'NV Insights Report'
		report.startLevel("Step 10 - Verifying that the title of the CSB is 'NV Insights Report'");
		stormRunnerResultsPage.waitForClientSideBreakdownTilteToBeClickable();
		AssertUtils.assertEquals(stormRunnerResultsPage.getClientSideBreakdownTitle(),MainConfig.StormRunnerClientSideBreakdownTitle, "Client Side Breakdown Title should be: " + MainConfig.StormRunnerClientSideBreakdownTitle,true);
		report.endLevel();


		// Step 11 - Going back to parent Frame
		report.startLevel("Step 11 - Going back to parent Frame");
		StormRunnerResultsPage.moveBackToParentFrame(driver);
		report.endLevel();


		// Step 12 - Click on 'Web Page Test Report' tab
		report.startLevel("Step 12 - Click on 'Web Page Test Report' tab");
		stormRunnerResultsPage.clickOnWebPageTestReportTab();
		report.endLevel();


		// Step 13 - Verifying that the title of the WebPageTest Report is 'WebPageTest report'
		report.startLevel("Step 13 - Verifying that the title of the WebPageTest Report is 'WebPageTest report'");
		stormRunnerResultsPage.waitForWebPageTestTitleToBeClickable();
		AssertUtils.assertEquals(stormRunnerResultsPage.getWebPageTestReportTitle(),MainConfig.StormRunnerWebPageTestReportTitle, "WebPageTest Report Title should be: " + MainConfig.StormRunnerWebPageTestReportTitle,true);
		report.endLevel();



	}
}
