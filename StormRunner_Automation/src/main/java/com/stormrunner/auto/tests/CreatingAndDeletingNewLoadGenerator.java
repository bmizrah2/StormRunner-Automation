package com.stormrunner.auto.tests;

import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsLoadGeneratorsPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.utils.AssertUtils;

public class CreatingAndDeletingNewLoadGenerator extends AbstractTest {

	@Test
	public void _005_CreatingAndDeletingNewLoadGenerator() throws Exception {


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

		
		// Step 6 - Clicking on 'Assets --> Load Generators'
		report.startLevel("Step 6 - Clicking on 'Assets --> Load Generators'");
		StormRunnerAssetsLoadGeneratorsPage stormRunnerAssetsLoadGeneratorsPage = stormRunnerHomePage.clickAssetsLoadGeneratorsSubMenuLink();
		report.endLevel();


		// Step 7 - Clicking on 'Create' button for creating new Load Generator
		report.startLevel("Step 7 - Clicking on 'Create' button for creating new Load Generator");
		stormRunnerAssetsLoadGeneratorsPage.clickOnCreateLoadGeneratorButton();
		report.endLevel();


		// Step 8 - Entering Load Generator server name in dialog
		report.startLevel("Step 8 - Entering Load Generator server name in dialog");
		stormRunnerAssetsLoadGeneratorsPage.writeToLoadGeneratorNameField(MainConfig.StormRunnerLoadGeneratorName);
		report.endLevel();


		// Step 9 - Entering Load Generator server Description in dialog
		report.startLevel("Step 9 - Entering Load Generator server Description in dialog");
		stormRunnerAssetsLoadGeneratorsPage.writeToLoadGeneratorDescriptionField(MainConfig.StormRunnerLoadGeneratorDescription);
		report.endLevel();


		// Step 10 - Clicking 'Save' for saving the new Load Generator server
		report.startLevel("Step 10 - Clicking 'Save' for saving the new Load Generator server");
		stormRunnerAssetsLoadGeneratorsPage.clickOnSaveInNewLoadGeneratorDialog();
		report.endLevel();


		// Step 11 - Verifying that the Load Generator was added successfully
		report.startLevel("Step 11 - Verifying that the new monitor was added successfully");
		AssertUtils.assertEquals(stormRunnerAssetsLoadGeneratorsPage.getNewAddedLoadGenerator(),MainConfig.StormRunnerLoadGeneratorName, "Load Generator should be: " + MainConfig.StormRunnerLoadGeneratorName,true);
		report.endLevel();
		

		// Step 12 - Checking the checkbox of the new added Load Generator for deletion
		report.startLevel("Step 12 - Checking the checkbox of the new added Load Generator for deletion");
		stormRunnerAssetsLoadGeneratorsPage.clickOnLoadGeneratorForDeletion();
		report.endLevel();

		
		// Step 13 - Clicking 'Delete' for deleting the Load Generator
		report.startLevel("Step 13 - Clicking 'Delete' for deleting the Load Generator");
		stormRunnerAssetsLoadGeneratorsPage.clickOnDeleteLoadGenerator();
		report.endLevel();


		// Step 14 - Clicking 'Yes' for approving deletion of the Load Generator
		report.startLevel("Step 14 - Clicking 'Yes' for approving deletion of the Load Generator");
		stormRunnerAssetsLoadGeneratorsPage.clickOnYesToConfirmDeletionOfLoadGenerator();
		report.endLevel();

		
		// Step 15 - Verifying that the Load Generator was deleted successfully and doesn't appear in the grid
		report.startLevel("Step 15 - Verifying that the Load Generator was deleted successfully and doesn't appear in the grid");
		stormRunnerAssetsLoadGeneratorsPage.waitForLoadGeneratorsPageToAppear();
		Thread.sleep(1000);
		stormRunnerAssetsLoadGeneratorsPage.isLoadGeneratorExistInGrid(MainConfig.StormRunnerLoadGeneratorName);
		report.endLevel();
		
				

	}

}

