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

public class AddingWidgetsToDashboard extends AbstractTest {

	@Test
	public void _010_AddingWidgetsToDashboard() throws Exception {

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
		report.startLevel("Step 7 - Clicking drop down menu of Run Id 3");
		stormRunnerResultsPage.clickOnDropDownMenuOfRunId3();
		report.endLevel();


		// clicking on "Dashboard" option in the menu
		report.startLevel("Step 8 - Choosing 'Dashboard' option in the menu");
		stormRunnerResultsPage.clickOnDashboardOfRunId3();
		report.endLevel();



		// clicking on "Add Widgets" icon
		report.startLevel("Step 9 - Click on 'Add Widgets' icon to open widgets gallery");
		//Wait for default widgets to appear in Dashboard
		stormRunnerResultsPage.waitForDefaultWidgetsToBeClickable();
		stormRunnerResultsPage.clickOnAddWidgetsIcon();
		report.endLevel();


		// clicking on "Transactions" tab in left menu of widget gallery
		report.startLevel("Step 10 - Click on 'Transactions' tab");

		stormRunnerResultsPage.clickOnTransactionsTab();
		report.endLevel();


		// clicking on "Go To 2nd Page" transaction
		report.startLevel("Step 11 - Click on 'Go To 2nd Page' transaction");
		//stormRunnerResultsPage.waitForTransGoTo2ndPageToBeClickable();

		stormRunnerResultsPage.clickOnGoTo2ndPageTransaction();
		report.endLevel();

		// clicking on "Back Home" transaction
		report.startLevel("Step 12 - Click on 'Back Home' transaction");
		//stormRunnerResultsPage.waitForTransBackHomeToBeClickable();
		stormRunnerResultsPage.clickOnBackHomeTransaction();
		report.endLevel();


		// clicking on "Add Widgets" icon
		report.startLevel("Step 13 - Click on 'Add Widgets' icon to close widgets gallery");
		stormRunnerResultsPage.clickOnAddWidgetsIcon();
		report.endLevel();


		//Verifying that the 2 transactions widgets appear in the dashboard
		report.startLevel("Step 14 - Verifying that the 2 transactions widgets appear in the Dashboard");
		AssertUtils.assertEquals(stormRunnerResultsPage.getGoTo2ndPageTransWidgetTitle(),MainConfig.StormRunnerGoTo2ndPageTransWidgetTitle, "'Go to 2nd page' Transaction widget title should be: " + MainConfig.StormRunnerGoTo2ndPageTransWidgetTitle,true);
		AssertUtils.assertEquals(stormRunnerResultsPage.getBackHomeTransWidgetTitle(),MainConfig.StormRunnerBackHomeTransWidgetTitle, "'Back Home' Transaction widget title should be: " + MainConfig.StormRunnerBackHomeTransWidgetTitle,true);
		report.endLevel();


		// clicking on 'x' to remove 'Go To 2nd Page' & 'Back Home' transaction widgets
		report.startLevel("Step 15 - Removing both 'Go To 2nd Page' & 'Back Home' transactions from dashboard");
		stormRunnerResultsPage.clickOnRemoveTransactionWidget("Go to 2nd page");
		stormRunnerResultsPage.clickOnRemoveTransactionWidget("Back Home");
		report.endLevel();



	}
}
