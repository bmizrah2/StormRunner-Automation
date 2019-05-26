package com.stormrunner.auto.tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.entities.Topology;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsTopologiesPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.utils.AssertUtils;
import com.stormrunner.auto.infra.web.WebDriverFactory;

public class CreatingMultipleTopologiesWithDataProvider extends AbstractTest {

	@Test(dataProvider = "topologiesProvider")
	public void _008_CreatingMultipleTopologiesWithDataProvider(Topology topology) throws Exception {


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


		// Step 6 - Clicking on 'Assets -> Topologies' tab
		report.startLevel("Step 6 - Clicking on 'Assets -> Topologies' tab");
		StormRunnerAssetsTopologiesPage stormRunnerAssetsTopologiesPage = stormRunnerHomePage.clickAssetsTopologiesSubMenuLink();
		report.endLevel();


		// Step 7 - Clicking on 'Create' button for creating new topology
		report.startLevel("Step 7 - Clicking on 'Create' button");
		stormRunnerAssetsTopologiesPage.clickOnCreateTopologyButton();
		report.endLevel();


		// Step 8 - Entering Topology name in dialog (Taken from 'Topologies.csv' file)
		report.startLevel("Step 8 - Entering Topology name in dialog");
		stormRunnerAssetsTopologiesPage.writeToTopologyNameField(topology.topologyName);
		report.endLevel();


		// Step 9 - Entering Topology Description in dialog (Taken from 'Topologies.csv' file)
		report.startLevel("Step 9 - Entering Topology Description in dialog");
		//stormRunnerAssetsTopologiesPage.writeToTopologyDescriptionField(MainConfig.StormRunnerTopologyDescription);
		stormRunnerAssetsTopologiesPage.writeToTopologyDescriptionField(topology.topologyDescription);
		report.endLevel();


		// Step 10 - Clicking on monitor to be part of the Topology
		report.startLevel("Step 10 - Clicking on monitor to be part of the Topology");
		stormRunnerAssetsTopologiesPage.clickOnMonitorToBePartOfTopology(MainConfig.StormRunnerSelectedMonitorForTopology);
		report.endLevel();


		// Step 11 - Clicking 'Save' for saving the new Topology
		report.startLevel("Step 11 - Clicking 'Save' for saving the new Topology");
		stormRunnerAssetsTopologiesPage.clickOnSaveInNewTopologyDialog();
		report.endLevel();


		// Counting how many topologies were added from Topologies file
		MainConfig.topologiesCounter++;


		// After adding all topologies --> Deleting them all together
		if (MainConfig.topologiesCounter == MainConfig.numberOfTopologiesInTopologiesFile){

			//Step 12 - Clicking The Checkbox for selecting ALL Topologies
			report.startLevel("Step 12 - Clicking The Checkbox for selecting ALL Topologies");
			stormRunnerAssetsTopologiesPage.clickOnCheckboxSelectingAllTopologies();
			//Thread.sleep(2000);
			report.endLevel();


			// Step 13 - Clicking 'Delete' for deleting the selected topologies
			report.startLevel("Step 13 - Clicking 'Delete' for deleting the selected topologies");
			stormRunnerAssetsTopologiesPage.clickOnDeleteSelectedTopologies();
			//Thread.sleep(2000);
			report.endLevel();


			// Step 14 - Clicking 'Yes' to confirm deletion of all selected topologies
			report.startLevel("Step 14 - Clicking 'Yes' to confirm deletion of all selected topologies");
			stormRunnerAssetsTopologiesPage.clickOnYesToConfirmDeletionOfTopology();
			Thread.sleep(2000);
			report.endLevel();


			//Step 15 - Verifying that all topologies were deleted & 'No Data' message appears on screen
			report.startLevel("Step 15 - Verifying that 'No Data' message appears on screen");
			AssertUtils.assertEquals(stormRunnerAssetsTopologiesPage.getNoDataMessage(),MainConfig.noDataMessageInTopologiesPage, "Message should be: " + MainConfig.noDataMessageInTopologiesPage,true);
			report.endLevel();



		}

	}



	// Data provider to get several topologies from file : "Topologies.csv"

	@DataProvider(name = "topologiesProvider")
	public Object[][] topologiesProvider() throws Exception {

		FileInputStream fstream = new FileInputStream("src/main/resources/config/Topologies.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		int numOfLines = 0;
		String line;

		ArrayList<Topology> topologies = new ArrayList<Topology>();

		while ((line = br.readLine()) != null) {

			if (numOfLines > 0) {
				String[] splitStr = line.split(",");
				Topology topology = new Topology(splitStr[0],splitStr[1]);
				topologies.add(topology);
			}

			numOfLines++;
		}

		br.close();

		Object[][] params = new Object[numOfLines-1][1];

		for (int i=0; i<numOfLines-1; i++) {
			params[i][0] = topologies.get(i);
		}
		return params;
	}


	// Init each iteration from main configuration file
	@BeforeMethod
	public void beforeTest() throws IOException {
		MainConfig.initFromFile("src/main/resources/config/MainConfig.properties");
		if (driver == null) {
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType);
		}
	}


	// Close browser after adding each topology
	@AfterMethod
	public void afterTest() throws Exception {

		takeScreenshot("Browser state at test end");

		if (driver != null && MainConfig.StormRunnerTopologyFlag==true) {
			//driver.close();
			driver.quit();
			driver = null;

		}
	}




}
