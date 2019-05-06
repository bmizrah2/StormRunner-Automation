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
import com.stormrunner.auto.infra.pages.StormRunnerCreateTestPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoadTestsPage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.pages.StormRunnerMainMenuPage;
import com.stormrunner.auto.infra.pages.StormRunnerResultsPage;
import com.stormrunner.auto.infra.utils.AssertUtils;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class CreatingAndDeletingNewMonitor extends AbstractTest {

	//@SuppressWarnings("null")
	@Test
	public void _004_CreatingAndDeletingMonitor() throws Exception {

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

		// Click on the "Assets" tab
		report.startLevel("Step 6 - Clicking on 'Assets' tab");
		StormRunnerAssetsMonitorsPage stormRunnerAssetsMonitorsPage = stormRunnerHomePage.clickAssetsTab();
		report.endLevel();


		// clicking on "Monitors" link in upper menu
		report.startLevel("Step 7 - Clicking on 'Monitors' link");
		stormRunnerAssetsMonitorsPage.clickOnMonitorsLinkInUpperMenu();
		report.endLevel();


		// clicking on "Create" button for creating new monitor
		report.startLevel("Step 8 - Clicking on 'Create' button");
		stormRunnerAssetsMonitorsPage.clickOnCreateMonitorButton();
		report.endLevel();


		// Choosing "Sitescope" monitor
		report.startLevel("Step 9 - Choosing 'SiteScope' monitor");
		stormRunnerAssetsMonitorsPage.clickOnSitescopeMonitorType();
		report.endLevel();


		// Entering SiteScope server name
		report.startLevel("Step 10 - Entering SiteScope server name in dialog");
		stormRunnerAssetsMonitorsPage.writeToSitescopeServerNameField(MainConfig.StormRunnerSitescopeServerName);
		report.endLevel();


		// Entering SiteScope server Description
		report.startLevel("Step 11 - Entering SiteScope server Description in dialog");
		stormRunnerAssetsMonitorsPage.writeToSitescopeDescriptionField(MainConfig.StormRunnerSitescopeDescription);
		report.endLevel();


		// Entering SiteScope server Description
		report.startLevel("Step 12 - Entering SiteScope server User Name in dialog");
		stormRunnerAssetsMonitorsPage.writeToSitescopeUserNameField(MainConfig.StormRunnerSitescopeUserName);
		report.endLevel();


		// Entering SiteScope server Description
		report.startLevel("Step 13 - Clicking 'Save' for saving the new SiteScope server");
		stormRunnerAssetsMonitorsPage.clickOnSaveInNewMonitorDialog();
		report.endLevel();

		// check if monitor appears in grid


		// Checking the checkbox of the new added monitor for deletion
		report.startLevel("Step 14 - Checking the checkbox of the new added monitor for deletion");
		stormRunnerAssetsMonitorsPage.clickOnMonitorForDeletion();
		report.endLevel();


		// Clicking 'Delete' for deleting the monitor
		report.startLevel("Step 15 - Clicking 'Delete' for deleting the monitor");
		stormRunnerAssetsMonitorsPage.clickOnDeleteMonitor();
		//Thread.sleep(2000);
		report.endLevel();


		// Clicking 'Yes' to confirm deletion of monitor
		report.startLevel("Step 16 - Clicking 'Yes' to confirm deletion of monitor");
		stormRunnerAssetsMonitorsPage.clickOnYesToConfirmDeletionOfMonitor();
		report.endLevel();




		// Check if monitor was removed

	}

}
/*
		//Entering Test Name
		report.startLevel("Step 8 - Entering Test name");
		stormRunnerCreateTestPage.writeToTestNameField(MainConfig.StormRunnerTestName);
		report.endLevel();

		//Entering Test Description
		report.startLevel("Step 9 - Entering Description to the test");
		//stormRunnerCreateTestPage.writeToDescriptionField("This is the Description of the Automated Test !");
		stormRunnerCreateTestPage.writeToDescriptionField(MainConfig.StormRunnerTestDescription);
		report.endLevel();

		report.startLevel("Step 10 - Moving back to the list of ALL load tests");
		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);
		// moving to "Load Tests" tab to view the grid
		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
		report.endLevel();

		//Verifying a new test line is added to the grid
		report.startLevel("Step 11 - Verifying that the new load test was added successfully");
		//AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
		//AssertUtils.assertEquals(MyAccountPage.getAccountName(),"Benny Java Automation", "Account Name should be: 'Benny Java Automation'",true);
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
		report.endLevel();

		//Clicking 'Delete' Button for deleting a test
		report.startLevel("Step 12 - Clicking the 'Delete' button for deleting the test");
		stormRunnerLoadTestsPage.clickOnDeleteButton();
		report.endLevel();

		// Clicking on 'Delete' in Confirmation message
		report.startLevel("Step 13 - Clicking the 'Delete' button for confirming the deletion");
		stormRunnerLoadTestsPage.clickOnDeleteButtonInConfirmationDialog();
		report.endLevel();

		// Verify that the test was deleted successfully
		report.startLevel("Step 14 - Verifying that the test was deleted successfully and doesn't appear in the grid");
		Thread.sleep(2000);
		stormRunnerLoadTestsPage.IsTestExistInGrid(MainConfig.StormRunnerTestName);
		report.endLevel();




		/*
		// click Assets tab
		StormRunnerAssetsPage stormRunnerAssetsPage = stormRunnerHomePage.clickAssetsMenuLink();

		// Click Results tab
		StormRunnerResultsPage stormRunnerResultsPage = stormRunnerHomePage.clickResultsMenuLink();

		// try functions of StormRunnerMainMenuPage
		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);

		stormRunnerHomePage = stormRunnerMainMenuPage.clickHomeTab();
		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
		stormRunnerAssetsPage = stormRunnerMainMenuPage.clickAssetsMenuLink();
		stormRunnerResultsPage = stormRunnerMainMenuPage.clickResultsTab();
 */


//	stormRunnerMainMenuPage.clickHomeTab();


//Try to add pressing load tests tab
//MyAccountPage myAccountPage = new MyAccountPage(driver);
//StormRunnerLoadTestsPage stormRunnerLoadTestsPage = 

//StormRunnerHomePage stormRunnerHomePage = myAccountPage.clickLaunchButton();

//StormRunnerLoadTestsPage stormRunnerLoadTestsPage = new StormRunnerLoadTestsPage(driver);

//StormRunnerHomePage stormRunnerHomePage = 

//stormRunnerHomePage.clickOnHomeTab();

//TabAndIframeUtils.switchToTabByUrl(driver, MainConfig.StormRunnerHomeURL);
//TabAndIframeUtils.switchToTabByTitle(driver, "Home");
//TabAndIframeUtils.switchToTabByTitle(driver, "Load Tests");

//stormRunnerLoadTestsPage   ????
//TabAndIframeUtils.switchToTabByUrl(driver, MainConfig.StormRunnerLoadTestsURL);


//https://stormrunner-load.saas.microfocus.com/home/?TENANTID=175726009&projectId=1

// A new tab is opened --> So switching to the new tab

//	for (String handle : driver.getWindowHandles()) {
//	    if (!handle.equals(currentWindow)) {
///	        driver.switchTo().window(handle);
///	    }
///	}	

//report.endLevel();

// Pressing "Create a Test" button
//	driver.findElement(By.xpath("//a[@class='stm-tst-load-tests' and text()='Load Tests']")).click();
//	driver.findElement(By.id("createTest")).click();	


//		*/

//}
//}
