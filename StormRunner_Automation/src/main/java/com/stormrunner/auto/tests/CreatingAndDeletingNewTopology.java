package com.stormrunner.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.AmazonSearchResultsPage;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsMonitorsPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsScriptsPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsTopologiesPage;
import com.stormrunner.auto.infra.pages.StormRunnerCreateTestPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoadTestsPage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.pages.StormRunnerMainMenuPage;
import com.stormrunner.auto.infra.pages.StormRunnerResultsPage;
import com.stormrunner.auto.infra.utils.AssertUtils;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class CreatingAndDeletingNewTopology extends AbstractTest {

	//@SuppressWarnings("null")
	@Test
	public void CreatingAndDeletingNewTopology() throws Exception {

		//driver.get("http://amazon.com");

		// Login to my account of stormRunner Load
		// Option1
		//report.startLevel("Step 1 - Browse to 'home.software.microfocus.com' landing page");
		//driver.get("https://home.software.microfocus.com/myaccount");
		//report.endLevel();

		//Option2
		report.startLevel("Step 1 - Browse to 'home.software.microfocus.com' Login page");
		browseToUrl(MainConfig.StormRunnerURL);
		//AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		StormRunnerLoginPage stormRunnerLoginPage = new StormRunnerLoginPage(driver);
		report.endLevel();


		//Actions action = new Actions(driver);
		//WebElement helloSignInLink = driver.findElement(By.id("nav-link-accountList"));

		//action.moveToElement(helloSignInLink).build().perform();

		//driver.findElement(By.xpath("//div[@id='nav-al-signin']//span[text()='Sign in']")).click();
		//driver.findElement(By.xpath("//input[@id='federateLoginName']")).click();

		// Option 1 to login : Entering user name as part of login to StormRunner
		report.startLevel("Step 2 - Entering User name as part of the login");

		// option1
		//driver.findElement(By.id("federateLoginName")).sendKeys(System.getenv("SEL_USERNAME"));
		//driver.findElement(By.id("fed-submit")).click();

		// Option 2 to login
		//driver.get("https://home.software.microfocus.com/myaccount");
		//StormRunnerLoginPage stormRunnerLoginPage = new StormRunnerLoginPage(driver);

		stormRunnerLoginPage.writeToUserNameField(System.getenv("SEL_USERNAME"));
		stormRunnerLoginPage.clickOnContinueButton();
		report.endLevel();

		//AmazonSearchResultsPage amazonSearchResultsPage = amazonLandingPage.clickOnGoButton();
		//stormRunnerLoginPage.clickOnContinueButton();

		//	driver.findElement(By.id("ap_password")).sendKeys("123456");
		//	driver.findElement(By.id("signInSubmit")).click();

		// Entering Password as part of login to StormRunner 
		//driver.findElement(By.id("password")).sendKeys("GoodPassword1");

		report.startLevel("Step 3 - Entering Password as part of the login");
		// Option1
		//driver.findElement(By.id("password")).sendKeys(System.getenv("SEL_PASSWORD"));
		//driver.findElement(By.id("submit_button")).click();

		//Option2
		stormRunnerLoginPage.writeToPasswordField(System.getenv("SEL_PASSWORD"));
		stormRunnerLoginPage.clickOnSignIn();
		report.endLevel();



		report.startLevel("Step 4 - Verifying that the account name is : 'Benny Java Automation'");
		//option1
		//WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));
		//String warningMessageTitleText = warningMessageTitle.getText();
		//String actualAccountName = accountName.getText();
		//Assert.assertEquals(actualAccountName, "Benny Java Automation", "The account name is NOT as expected !!!");

		// Option2	
		// Step 5 - Verify that the account name is : "Benny Java Automation"
		AssertUtils.assertEquals(MyAccountPage.getAccountName(),"Benny Java Automation", "Account Name should be: 'Benny Java Automation'",true);

		report.endLevel();



		// locate "Luanch" button
		// $x("//div/a[contains(@href,'175726009')]")


		report.startLevel("Step 5 - Moving to new opened Tab after clicking 'Launch'");
		// saving first tab	
		//String currentWindow = driver.getWindowHandle();

		//	Pressing the "Launch" button
		//driver.findElement(By.xpath("//div/a[contains(@href,'175726009')]")).click();

		//driver.findElement(By.xpath("//a[text()='Launch']")).click();

		//works
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		StormRunnerHomePage stormRunnerHomePage = myAccountPage.clickLaunchButton();
		report.endLevel();

		// Click on the "Assets -> Topologies" tab
		report.startLevel("Step 6 - Clicking on 'Assets -> Topologies' tab");
		//StormRunnerAssetsMonitorsPage stormRunnerAssetsMonitorsPage = stormRunnerHomePage.clickAssetsTab();
		StormRunnerAssetsTopologiesPage stormRunnerAssetsTopologiesPage = stormRunnerHomePage.clickAssetsTopologiesSubMenuLink();
		report.endLevel();


		//		// clicking on "Monitors" link in upper menu
		//		report.startLevel("Step 7 - Clicking on 'Monitors' link");
		//		stormRunnerAssetsMonitorsPage.clickOnMonitorsLinkInUpperMenu();
		//		report.endLevel();


		// clicking on "Create" button for creating topology
		report.startLevel("Step 7 - Clicking on 'Create' button");
		stormRunnerAssetsTopologiesPage.clickOnCreateTopologyButton();
		report.endLevel();


		//		// Choosing "Sitescope" monitor
		//		report.startLevel("Step 9 - Choosing 'SiteScope' monitor");
		//		stormRunnerAssetsMonitorsPage.clickOnSitescopeMonitorType();
		//		report.endLevel();


		// Entering SiteScope server name
		report.startLevel("Step 8 - Entering Topology name in dialog");
		stormRunnerAssetsTopologiesPage.writeToTopologyNameField(MainConfig.StormRunnerTopologyName);
		report.endLevel();


		// Entering SiteScope server Description
		report.startLevel("Step 9 - Entering Topology Description in dialog");
		stormRunnerAssetsTopologiesPage.writeToTopologyDescriptionField(MainConfig.StormRunnerTopologyDescription);
		report.endLevel();


		// clicking on "Create" button for creating topology
		report.startLevel("Step 10 - Clicking on monitor to be part of the Topology");
		stormRunnerAssetsTopologiesPage.clickOnMonitorToBePartOfTopology(MainConfig.StormRunnerSelectedMonitorForTopology);
		report.endLevel();



		//		// Entering SiteScope server Description
		//		report.startLevel("Step 12 - Entering SiteScope server User Name in dialog");
		//		stormRunnerAssetsMonitorsPage.writeToSitescopeUserNameField(MainConfig.StormRunnerSitescopeUserName);
		//		report.endLevel();


		// Entering SiteScope server Description
		report.startLevel("Step 10 - Clicking 'Save' for saving the new Topology");
		stormRunnerAssetsTopologiesPage.clickOnSaveInNewTopologyDialog();
		report.endLevel();

		// check if monitor appears in grid
		report.startLevel("Step 11 - Verifying that the new Topology was added successfully");
		//AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
		//AssertUtils.assertEquals(MyAccountPage.getAccountName(),"Benny Java Automation", "Account Name should be: 'Benny Java Automation'",true);
		AssertUtils.assertEquals(stormRunnerAssetsTopologiesPage.getNewAddedTopology(),MainConfig.StormRunnerTopologyName, "Topology should be: " + MainConfig.StormRunnerTopologyName,true);
		report.endLevel();


		//********** No need to click since it auto clicked after closing dialog
		// Checking the checkbox of the new added Topology for deletion
//		report.startLevel("Step 12 - Checking the checkbox of the new added Topology for deletion");
//		stormRunnerAssetsTopologiesPage.clickOnTopologyForDeletion();
//		report.endLevel();


		// Clicking 'Delete' for deleting the Topology
		report.startLevel("Step 13 - Clicking 'Delete' for deleting the monitor");
		stormRunnerAssetsTopologiesPage.clickOnDeleteTopology();
		//Thread.sleep(2000);
		report.endLevel();


		// Clicking 'Yes' to confirm deletion of Topology
		report.startLevel("Step 14 - Clicking 'Yes' to confirm deletion of monitor");
		stormRunnerAssetsTopologiesPage.clickOnYesToConfirmDeletionOfTopology();
		report.endLevel();

		// Verify that the Topology was deleted successfully
		report.startLevel("Step 15 - Verifying that the Topology was deleted successfully and doesn't appear in the grid");
		Thread.sleep(1000);
		stormRunnerAssetsTopologiesPage.isTopologyExistInGrid(MainConfig.StormRunnerTopologyName);
		//stormRunnerAssetsMonitorsPage.isMonitorExistInGrid("2.3.4.5");
		report.endLevel();
	}

}
