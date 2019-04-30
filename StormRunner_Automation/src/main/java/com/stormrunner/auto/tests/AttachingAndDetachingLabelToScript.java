package com.stormrunner.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stormrunner.auto.infra.config.MainConfig;
import com.stormrunner.auto.infra.pages.AmazonSearchResultsPage;
import com.stormrunner.auto.infra.pages.MyAccountPage;
import com.stormrunner.auto.infra.pages.StormRunnerAssetsPage;
import com.stormrunner.auto.infra.pages.StormRunnerCreateTestPage;
import com.stormrunner.auto.infra.pages.StormRunnerHomePage;
import com.stormrunner.auto.infra.pages.StormRunnerLoadTestsPage;
import com.stormrunner.auto.infra.pages.StormRunnerLoginPage;
import com.stormrunner.auto.infra.pages.StormRunnerMainMenuPage;
import com.stormrunner.auto.infra.pages.StormRunnerResultsPage;
import com.stormrunner.auto.infra.utils.AssertUtils;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class AttachingAndDetachingLabelToScript extends AbstractTest {

	//@SuppressWarnings("null")
	@Test
	public void _003_AttachingAndDetachingLabelToScript() throws Exception {

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

		report.startLevel("Step 6 - Clicking on 'Assets' tab");
		// Click on the "Assets" tab - works
		StormRunnerAssetsPage stormRunnerAssetsPage = stormRunnerHomePage.clickAssetsMenuLink();
		report.endLevel();

		// clicking on the "Expand Labels Pane" icon
		report.startLevel("Step 7 - Clicking on 'Expand Labels Pane' button for opening the Labels Pane");
		//stormRunnerAssetsPage.clickOnExpandLabelsPaneIcon();
		stormRunnerAssetsPage.moveToExpandButtonAndClickIt();
		report.endLevel();

		// clicking on the "Create label" button
		report.startLevel("Step 8 - Clicking on 'Create label' button for creating new label");
		stormRunnerAssetsPage.clickOnCreateLabelButton();
		report.endLevel(); 

		// Entering a new label name in the "New Label" dialog
		report.startLevel("Step 9 - Entering Label Name");
		//stormRunnerAssetsPage.writeToLabelNameField("This is an automated LABEL NAME");
		stormRunnerAssetsPage.writeToLabelNameField(MainConfig.StormRunnerLabelName);
		report.endLevel(); 

		// Clicking 'Save' to save the new created label
		report.startLevel("Step 10 - Saving the new created Label");
		stormRunnerAssetsPage.clickOnSaveInNewLabelDialog();
		report.endLevel();


		//clicking on the "Collapse Labels Pane" icon
		report.startLevel("Step 11 - Clicking on 'Collapse Labels Pane' button for closing the Labels Pane");
		//stormRunnerAssetsPage.clickOnCollapseLabelsPaneIcon();
		stormRunnerAssetsPage.moveToCollapseButtonAndClickIt();
		report.endLevel();



		//Clicking on "Assign Labels" drop down list
		report.startLevel("Step 12 - Clicking 'Assign Labels' drop down list");
		stormRunnerAssetsPage.clickOnAssignLabelsDropDownButton();
		report.endLevel();


		//Clicking the checkbox of the new added label
		report.startLevel("Step 13 - Clicking the checkbox of the new added label");
		stormRunnerAssetsPage.clickOnLabelCheckbox();
		report.endLevel();

		// Clicking save for assigning the label to the script
		report.startLevel("Step 14 - Clicking 'Save' for attaching the label to the script");
		stormRunnerAssetsPage.clickSaveAssigningLabelToScript();
		report.endLevel();

		//Verify the label is attached to the first selected script 
		AssertUtils.assertEquals(StormRunnerAssetsPage.getLabelName(),MainConfig.StormRunnerLabelName, "Label Name should be:"+MainConfig.StormRunnerLabelName,true);

		//Expand the labels pane again for deleting the label 
		// clicking on the "Expand Labels Pane" icon
		report.startLevel("Step 15 - Clicking on 'Expand Labels Pane' button for opening the Labels Pane");
		//stormRunnerAssetsPage.clickOnExpandLabelsPaneIcon();
		stormRunnerAssetsPage.moveToExpandButtonAndClickIt();
		report.endLevel();


		// clicking the drop down menu of the label
		report.startLevel("Step 16 - Clicking on ... of the label to open its options");
		stormRunnerAssetsPage.clickDropDownMenuOfLabelOptions();
		report.endLevel();



		// Choosing the 'Remove' option from the label's options
		report.startLevel("Step 17 - Choose the 'Remove' option to remove the label");
		stormRunnerAssetsPage.clickOnRemoveLabelOptionInDropDownMenu();
		report.endLevel();


		// Clicking  'Remove' button in the "Remove Label" dialog
		report.startLevel("Step 18 - Clicking  'Remove' button in the 'Remove Label' dialog");
		stormRunnerAssetsPage.clickOnRemoveButtonInRemoveLabelDialog();
		report.endLevel();


		// clicking on the "Collapse Labels Pane" icon
		report.startLevel("Step 19 - Clicking on 'Collapse Labels Pane' button for closing the Labels Pane");
		stormRunnerAssetsPage.moveToCollapseButtonAndClickIt();
		report.endLevel();
		

		// Add a verification that label was detached from the 1st selected script 





		//Xpath for clicking on '...' of LoadRunner 
		//$x("//span[contains(text(),'StormRunner_Label')]/../..//div[contains(@class,'icon-more-vertical')]")



		/*

		// clicking on the "Create" button
		report.startLevel("Step 7 - Clicking on 'Create' button for creating a new test");
		StormRunnerCreateTestPage stormRunnerCreateTestPage = stormRunnerLoadTestsPage.clickOnCreateButton();
		report.endLevel();


		//Entering Test Name
		report.startLevel("Step 8 - Entering Test name");
		stormRunnerCreateTestPage.writeToTestNameField("This is an Automated Test !!!");
		report.endLevel();

		//Entering Test Description
		report.startLevel("Step 9 - Entering Description to the test");
		stormRunnerCreateTestPage.writeToDescriptionField("This is the Description of the Automated Test !");
		report.endLevel();

		report.startLevel("Step 10 - Moving back to the list of ALL load tests");
		StormRunnerMainMenuPage stormRunnerMainMenuPage = new StormRunnerMainMenuPage(driver);
		// moving to "Load Tests" tab to view the grid
		stormRunnerLoadTestsPage = stormRunnerMainMenuPage.clickLoadTestsMenuLink();
		report.endLevel();

		//Verifying a new test line is added to the grid
		report.startLevel("Step 11 - Verifying that the new load test was added successfully");
		AssertUtils.assertEquals(StormRunnerLoadTestsPage.getNewAddedTest(),"This is an Automated Test !!!", "Test Name should be: 'This is an Automated Test !!!'",true);
		report.endLevel();

		//Clicking 'Delete' Button for deleting a test
		report.startLevel("Step 12 - Clicking the 'Delete' button for deleting the test");
		stormRunnerLoadTestsPage.clickOnDeleteButton();
		report.endLevel();

		// Clicking on 'Delete' in Confirmation message
		report.startLevel("Step 13 - Clicking the 'Delete' button for confirming the deletion");
		stormRunnerLoadTestsPage.clickOnDeleteButtonInConfirmationDialog();
		report.endLevel();

		// Need to check that the number of lines was decreased by 1
		// --------------- CODE ----------------






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

		 report.endLevel();

		// Pressing "Create a Test" button
		//	driver.findElement(By.xpath("//a[@class='stm-tst-load-tests' and text()='Load Tests']")).click();
		//	driver.findElement(By.id("createTest")).click();	

		 */


	}
}
