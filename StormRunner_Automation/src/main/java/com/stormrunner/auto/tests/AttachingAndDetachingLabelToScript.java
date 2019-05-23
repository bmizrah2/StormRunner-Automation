package com.stormrunner.auto.tests;

import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsScriptsPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.utils.AssertUtils;

public class AttachingAndDetachingLabelToScript extends AbstractTest {

	@Test
	public void _003_AttachingAndDetachingLabelToScript() throws Exception {

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
		
		// Step 6 - Clicking on 'Assets' tab
		report.startLevel("Step 6 - Clicking on 'Assets' tab");
		StormRunnerAssetsScriptsPage stormRunnerAssetsScriptsPage = stormRunnerHomePage.clickAssetsMenuLink();
		report.endLevel();

		// Step 7 - Clicking on 'Expand Labels Pane' button for opening the Labels Pane
		report.startLevel("Step 7 - Clicking on 'Expand Labels Pane' button for opening the Labels Pane");
		//StormRunnerAssetsScriptsPage.clickOnExpandLabelsPaneIcon();
		stormRunnerAssetsScriptsPage.moveToExpandButtonAndClickIt();
		report.endLevel();

		// Step 8 - Clicking on 'Create label' button for creating new label
		report.startLevel("Step 8 - Clicking on 'Create label' button for creating new label");
		stormRunnerAssetsScriptsPage.clickOnCreateLabelButton();
		report.endLevel(); 

		// Step 9 - Entering a new label name in the "New Label" dialog (from MainConfig file)
		report.startLevel("Step 9 - Entering Label Name");
		stormRunnerAssetsScriptsPage.writeToLabelNameField(MainConfig.StormRunnerLabelName);
		report.endLevel(); 

		// Step 10 - Clicking 'Save' to save the new created label
		report.startLevel("Step 10 - Saving the new created Label");
		stormRunnerAssetsScriptsPage.clickOnSaveInNewLabelDialog();
		report.endLevel();


		// Step 11 - Clicking on 'Collapse Labels Pane' button for closing the Labels Pane
		report.startLevel("Step 11 - Clicking on 'Collapse Labels Pane' button for closing the Labels Pane");
		//StormRunnerAssetsScriptsPage.clickOnCollapseLabelsPaneIcon();
		stormRunnerAssetsScriptsPage.moveToCollapseButtonAndClickIt();
		report.endLevel();


		// Step 12 - Clicking 'Assign Labels' drop down list
		report.startLevel("Step 12 - Clicking 'Assign Labels' drop down list");
		stormRunnerAssetsScriptsPage.clickOnAssignLabelsDropDownButton();
		report.endLevel();


		//Step 13 - Clicking the checkbox of the new added label
		report.startLevel("Step 13 - Clicking the checkbox of the new added label");
		stormRunnerAssetsScriptsPage.clickOnLabelCheckbox();
		report.endLevel();

		
		// Step 14 - Clicking 'Save' for attaching the label to the script
		report.startLevel("Step 14 - Clicking 'Save' for attaching the label to the script");
		stormRunnerAssetsScriptsPage.clickSaveAssigningLabelToScript();
		report.endLevel();

		// Step 15 - Verify the label is attached to the first selected script
		report.startLevel("Step 15 - Verify the label is attached to the first selected script");
		AssertUtils.assertEquals(stormRunnerAssetsScriptsPage.getLabelName(),MainConfig.StormRunnerLabelName, "Label Name should be:"+MainConfig.StormRunnerLabelName,true);
		report.endLevel();
		
		// Step 16 - Clicking on 'Expand Labels Pane' button for opening the Labels Pane
		report.startLevel("Step 16 - Clicking on 'Expand Labels Pane' button for opening the Labels Pane");
		//StormRunnerAssetsScriptsPage.clickOnExpandLabelsPaneIcon();
		stormRunnerAssetsScriptsPage.moveToExpandButtonAndClickIt();
		report.endLevel();


		// Step 17 - Clicking on ... of the label to open its options
		report.startLevel("Step 17 - Clicking on ... of the label to open its options");
		stormRunnerAssetsScriptsPage.clickDropDownMenuOfLabelOptions();
		report.endLevel();



		// Step 18 - Choose the 'Remove' option to remove the label
		report.startLevel("Step 18 - Choose the 'Remove' option to remove the label");
		stormRunnerAssetsScriptsPage.clickOnRemoveLabelOptionInDropDownMenu();
		report.endLevel();


		// Step 19 - Clicking  'Remove' button in the 'Remove Label' dialog
		report.startLevel("Step 19 - Clicking  'Remove' button in the 'Remove Label' dialog");
		stormRunnerAssetsScriptsPage.clickOnRemoveButtonInRemoveLabelDialog();
		report.endLevel();


		// Step 20 - Clicking on 'Collapse Labels Pane' button for closing the Labels Pane
		report.startLevel("Step 20 - Clicking on 'Collapse Labels Pane' button for closing the Labels Pane");
		stormRunnerAssetsScriptsPage.moveToCollapseButtonAndClickIt();
		report.endLevel();
		
		
		// Step 21 - Verifying that the label was detached from the script successfully and doesn't appear in the grid
		report.startLevel("Step 21 - Verifying that the label was detached from the script successfully and doesn't appear in the grid");
		Thread.sleep(2000);
		stormRunnerAssetsScriptsPage.isLabelExistInGrid(MainConfig.StormRunnerLabelName);
		report.endLevel();



	}
}
