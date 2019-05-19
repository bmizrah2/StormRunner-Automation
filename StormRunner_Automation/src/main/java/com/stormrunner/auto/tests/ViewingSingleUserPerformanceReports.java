package com.stormrunner.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.AmazonSearchResultsPage;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsScriptsPage;
import com.stormrunner.auto.infra.pages.StormRunnerCreateTestPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoadTestsPage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.pages.StormRunnerMainMenuPage;
import com.stormrunner.auto.infra.pages.StormRunnerResultsPage;
import com.stormrunner.auto.infra.utils.AssertUtils;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class ViewingSingleUserPerformanceReports extends AbstractTest {

	@Test
	public void _009_ViewingSingleUserPerformanceReports() throws Exception {

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

		report.startLevel("Step 6 - Clicking on 'Results' tab");
		// Click on the "Load Tests" tab - works
		StormRunnerResultsPage stormRunnerResultsPage = stormRunnerHomePage.clickResultsMenuLink();
		report.endLevel();



		// clicking on the "Drop Down Menu" of Run Id 3
		report.startLevel("Step 7 - Clicking drop down nenu of Run Id 3");
		stormRunnerResultsPage.clickOnDropDownMenuOfRunId3();
		report.endLevel();


		// clicking on "Single User Performance" option in the menu
		report.startLevel("Step 8 - Choosing 'Single User Performance' option in the menu");
		stormRunnerResultsPage.clickOnSingleUserPerformanceOfRunId3();
		Thread.sleep(15000);
		report.endLevel();


		// Verify 'NV Insights Report' title
		//
		//   TBD - 9 

		
		//Verifying a new test line is added to the grid
		report.startLevel("Step 9 - Verifying that the title of the CSB is 'NV Insights Report'");
//		//AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
//		//AssertUtils.assertEquals(MyAccountPage.getAccountName(),"Benny Java Automation", "Account Name should be: 'Benny Java Automation'",true);
		AssertUtils.assertEquals(stormRunnerResultsPage.getClientSideBreakdownTitle(),MainConfig.StormRunnerClientSideBreakdownTitle, "Client Side Breakdown Title should be: " + MainConfig.StormRunnerClientSideBreakdownTitle,true);
		report.endLevel();
		
		
		
		
		

		// clicking on "Web Page Test Report" tab
		report.startLevel("Step 10 - Click on 'Web Page Test Report' tab");
		stormRunnerResultsPage.clickOnWebPageTestReportTab();
		report.endLevel();


		// Verify 'NV Insights Report' title
		//
		//   TBD - 11


//
//		//Entering Test Name
//		report.startLevel("Step 8 - Entering Test name");
//		stormRunnerCreateTestPage.writeToTestNameField(MainConfig.StormRunnerTestName);
//		report.endLevel();
//
//		//Entering Test Description
//		report.startLevel("Step 9 - Entering Description to the test");
//		//stormRunnerCreateTestPage.writeToDescriptionField("This is the Description of the Automated Test !");
//		stormRunnerCreateTestPage.writeToDescriptionField(MainConfig.StormRunnerTestDescription);
//		report.endLevel();
//
//		report.startLevel("Step 10 - Moving back to the list of ALL load tests");
//		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);
//		// moving to "Load Tests" tab to view the grid
//		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
//		report.endLevel();
//
//		//Verifying a new test line is added to the grid
//		report.startLevel("Step 11 - Verifying that the new load test was added successfully");
//		//AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
//		//AssertUtils.assertEquals(MyAccountPage.getAccountName(),"Benny Java Automation", "Account Name should be: 'Benny Java Automation'",true);
//		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),MainConfig.StormRunnerTestName, "Test Name should be: " + MainConfig.StormRunnerTestName,true);
//		report.endLevel();
//
//		//Clicking 'Delete' Button for deleting a test
//		report.startLevel("Step 12 - Clicking the 'Delete' button for deleting the test");
//		stormRunnerLoadTestsPage.clickOnDeleteButton();
//		report.endLevel();
//
//		// Clicking on 'Delete' in Confirmation message
//		report.startLevel("Step 13 - Clicking the 'Delete' button for confirming the deletion");
//		stormRunnerLoadTestsPage.clickOnDeleteButtonInConfirmationDialog();
//		report.endLevel();
//
//		// Verify that the test was deleted successfully
//		report.startLevel("Step 14 - Verifying that the test was deleted successfully and doesn't appear in the grid");
//		Thread.sleep(2000);
//		stormRunnerLoadTestsPage.IsTestExistInGrid(MainConfig.StormRunnerTestName);
//		report.endLevel();
//




	}
}
