package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerResultsPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));

	// ------------------   SINGLE USER PERFORMANCE ----------------------

	//Clicking Results tab by css selector  ($$("a.stm-tst-results"))
	private static final By2 resultsTab = new By2("'Results' tab", By.cssSelector("a.stm-tst-results"));

	// drop down menu of RunId=3 with Single user performance option enabled 
	private static final By2 runId3DropDownMenu = new By2("'Run Id 3 drop down menu'", By.cssSelector("div.stm-tst-results-options-button-3"));

	// 'Single user performance' option in drop down menu of RunId 3 
	private static final By2 singleUserPerformanceOptionOfRunId3 = new By2("'Single user performance' option of run Id 3", By.cssSelector("div.stm-tst-client-3"));

	// 'NV Insights Report' link under 'Client Side Breakdown' tab 
	//private static final By2 clientSideBreakdownTitle = new By2("'NV Insights Report' link under 'Client Side Breakdown' tab", By.id("label#insightsLink"));
	//private static final By2 clientSideBreakdownTitle = new By2("'NV Insights Report' link under 'Client Side Breakdown' tab", By.xpath("//div[contains(@id,'reportContainer')]//label[contains(@id,'insightsLink')]"));
	private static final By2 clientSideBreakdownTitle = new By2("'NV Insights Report' link under 'Client Side Breakdown' tab", By.xpath("//div[contains(@class,'transactionNameContainer')]//label[contains(@id,'insightsLink')]"));

	// Single user performance TAB
	//private static final By2 singleUserPerformanceTab = new By2("'Single user performance' Tab", By.cssSelector("div.stm-tst-status-bar-navigation-breakdown"));
	private static final By2 singleUserPerformanceTab = new By2("'Single user performance' Tab", By.xpath("//div[contains(text(),'Single user performance')]"));
	
	
	
	//Web Page Test report tab
	//private static final By2 webPageTestReportTab = new By2("'Web Page Test report' tab under 'Single User Performance Tab'", By.cssSelector("div.stm-tst-status-bar-report open"));
	private static final By2 webPageTestReportTab = new By2("'Web Page Test report' tab under 'Single User Performance Tab'", By.xpath("//div[contains(text(),' WebPageTest report ')]"));
	
	//Web Page Test Report title
	private static final By2 webPageTestReportTitle = new By2("'Web Page Test report' Title", By.xpath("//div[contains(@class,'container')]//div[contains(text(),'WebPageTest report')]"));
	                                                                                         
	
	// ------------------  DASHBOARD -------------------
	
	// 'Dashboard' option in drop down menu of RunId3
		private static final By2 dashboardOptionOfRunId3 = new By2("'Dashboard' option of run Id 3", By.cssSelector("div.stm-tst-dashboard-3"));
		
		// 'Add Widgets' icon down the dashboard
		private static final By2 addWidgetsIcon = new By2("'Add Widgets' icon to open/close gallery", By.cssSelector("div.stm-tst-gallery"));
		
		// 'Transactions' tab on the left menu
		private static final By2 TransactionsTab = new By2("'Transactions' Tab", By.xpath("//div[contains(text(),'Transactions')]"));
		
		// Clicking on transaction 'Go to 2nd page'
		private static final By2 transactionGoTo2ndPage = new By2("'Transaction: Go to 2nd page'", By.xpath("//div[contains(@class,'chart-in-gallery-model')]//div[contains(@title,'Go to 2nd page')]"));
		
		// Clicking on transaction 'Back Home'
		private static final By2 transactionBackHome = new By2("'Transaction: Back Home'", By.xpath("//div[contains(@class,'chart-in-gallery-model')]//div[contains(@title,'Back Home')]"));
		
		
		// Title of widget: transaction "Go To 2nd Page" 
		private static final By2 transactionGoTo2ndPageWidget = new By2("'Transaction: Go To 2nd Page Widget'", By.xpath("//div[contains(@title,'TRT [90th percentile]: Go to 2nd page in script 12_01_Web_PeaceFul_71_NOV_2016')]"));
		
		// Title of widget: transaction "Back Home"
		private static final By2 transactionBackHomeWidget = new By2("'Transaction: Back Home Widget'", By.xpath("//div[contains(@title,'TRT [90th percentile]: Back Home in script 12_01_Web_PeaceFul_71_NOV_2016')]"));
		
		// 'Running Vusers' widget in dashboard
		private static final By2 runningVusersWidgetTitle = new By2("'Running Vusers' widget title'", By.xpath("//div[contains(@class,'stm-tst-main-chart')]//div[contains(@title,'Running Vusers')]"));

		// 'Hits per second' widget in dashboard
		private static final By2 hitsPerSecondWidgetTitle = new By2("'Hits per second' widget title'", By.xpath("//div[contains(@class,'stm-tst-main-chart')]//div[contains(@title,'Hits per second')]"));
		
		// 'Throughput' widget in dashboard
		private static final By2 throughputWidgetTitle = new By2("'Throughput' widget title'", By.xpath("//div[contains(@class,'stm-tst-main-chart')]//div[contains(@title,'Throughput')]"));
		
		// 'Throughput' widget in dashboard
		private static final By2 errorsWidgetTitle = new By2("'Errors' widget title'", By.xpath("//div[contains(@class,'stm-tst-main-chart')]//div[contains(@title,'Errors')]"));
		
		
		// 'x' icon to close trans: "Go To 2nd Page"
		private static final By2 closingGoTo2ndPageTransWidget = new By2("'x' icon of 'Go To 2nd Page' transaction", By.xpath("//div[contains(@title,'TRT [90th percentile]: Go to 2nd page in script 12_01_Web_PeaceFul_71_NOV_2016')]//..//div[contains(@class,'stm-tst-primary-x-btn')]"));
		
	
		// 'x' icon to close trans: "Back Home"
		private static final By2 closingBackHomeTransWidget = new By2("'x' icon of 'Back Home' transaction", By.xpath("//div[contains(@title,'TRT [90th percentile]: Back Home in script 12_01_Web_PeaceFul_71_NOV_2016')]//..//div[contains(@class,'stm-tst-primary-x-btn')]"));
		
	
	
	//     By.xpath("//div[contains(@class,'ui-grid-coluiGrid-00FS')]
	//    By.xpath("//h1[contains(text(),'Added to Cart')]")


	public StormRunnerResultsPage(WebDriver driver) throws Exception {
		//super(driver, loadTestsTab,createButton);
		//super(driver,createButton);
		//super(driver,testNameHeader);
		//super(driver,toolBar);
		super(driver,resultsTab);
	}



	// Clicking drop down menu of Run Id 3
	public void clickOnDropDownMenuOfRunId3() throws InterruptedException {
		bot.click(runId3DropDownMenu);
	}


	// Choosing 'Single User Performance' option in drop down menu
	public void clickOnSingleUserPerformanceOfRunId3() throws InterruptedException {
		bot.click(singleUserPerformanceOptionOfRunId3);
	}


	// Clicking on WPT tab
	public void clickOnWebPageTestReportTab() throws InterruptedException {
		bot.click(webPageTestReportTab);
	}


	//Getting the title of the 'Client Side Breakdown' tab 
	public String getClientSideBreakdownTitle() {
		String actualClientSideBreakdownTitle = bot.getElementText(clientSideBreakdownTitle);
		return actualClientSideBreakdownTitle;
	}


	//Getting the title of 'Web Page Test Report' tab
	public String getWebPageTestReportTitle() {
		String actualWebPageTestReportTitle = bot.getElementText(webPageTestReportTitle);
		return actualWebPageTestReportTitle;
	}


	// Clicking on CSB tab
	public void clickOnSingleUserPerformanceTab() throws InterruptedException {
			bot.click(singleUserPerformanceTab);
	}


	// Waiting until WPT tab content appears
	public void waitForWebPageTestTitleToBeClickable() {
		bot.waitForElementToBeClickable(webPageTestReportTitle);
	}


	// Waiting until CSB content appears 
	public void waitForClientSideBreakdownTilteToBeClickable() {
		bot.waitForElementToBeClickable(clientSideBreakdownTitle);
	}


	//Inserting insdie inner HTML ('Client Side Breakdown' Tab)
	public static void moveToClientSideBreakdownHtml(WebDriver driver) {
		TabAndIframeUtils.switchToIframe(driver, By.id("hpe-iframe"));

	}


	//Moving back to Parent Frame
	public static void moveBackToParentFrame(WebDriver driver) {
		bot.moveBackToParentFrame(driver);
		//driver.switchTo().parentFrame();
	}


	//Clicking on Dashboard option of RunId3
	public void clickOnDashboardOfRunId3() throws InterruptedException {
		bot.click(dashboardOptionOfRunId3);
	}


	// Click on "Add Widgets" icon to open widgets Gallery
	public void clickOnAddWidgetsIcon() throws InterruptedException {
		bot.click(addWidgetsIcon);
	}


	// Click on "Transaction" tab in left menu of Dashboard
	public void clickOnTransactionsTab() throws InterruptedException {
		bot.click(TransactionsTab);;
	}


	// Click on "Go To 2nd Page" transaction widget
	public void clickOnGoTo2ndPageTransaction() throws InterruptedException {
		bot.click(transactionGoTo2ndPage);;
	}


	
	// Click on "Back Home" transaction widget
	public void clickOnBackHomeTransaction() throws InterruptedException {
		bot.click(transactionBackHome);
	}


	//Wait for trans "Go To 2nd Page" to be clickable
	public void waitForTransGoTo2ndPageToBeClickable() {
		bot.waitForElementToBeClickable(transactionGoTo2ndPage);
	}

	
	//Wait for trans "Go To 2nd Page" to be clickable
	public void waitForTransBackHomeToBeClickable() {
		bot.waitForElementToBeClickable(transactionBackHome);
	}



	public void waitForDefaultWidgetsToBeClickable() {
		bot.waitForElementToBeClickable(runningVusersWidgetTitle);
		bot.waitForElementToBeClickable(hitsPerSecondWidgetTitle);
		bot.waitForElementToBeClickable(throughputWidgetTitle);
		bot.waitForElementToBeClickable(errorsWidgetTitle);
	}



	public void clickOnRemoveTransactionWidget(String transactionName) throws InterruptedException {
		//By2 selectedMonitorName = new By2("Monitor: "+monitorName+"", By.xpath("//div[contains(@class,'modal')]//div[contains(text(),'"+monitorName+"')]"));
		By2 WidgetTitleToRemove = new By2("'x' icon to remove transaction widget: '"+transactionName+"' from dashboard", By.xpath("//div[contains(@title,'TRT [90th percentile]: "+transactionName+" in script 12_01_Web_PeaceFul_71_NOV_2016')]//..//div[contains(@class,'stm-tst-primary-x-btn')]"));
		bot.click(WidgetTitleToRemove);
	}


	// Get the title of transaction widget : "Go to 2nd page" in dashboard
	public String getGoTo2ndPageTransWidgetTitle() {
		String actualGoTo2ndPageTransWidgetTitle = bot.getElementText(transactionGoTo2ndPageWidget);
		return actualGoTo2ndPageTransWidgetTitle;
	}



	// Get the title of transaction widget : "Back Home" in dashboard
	public String getBackHomeTransWidgetTitle() {
		String actualBackHomeTransWidgetTitle=bot.getElementText(transactionBackHomeWidget);
		return actualBackHomeTransWidgetTitle;
	}
	

	
	// Is 1st transaction exist in dashboard
	public Boolean isGoTo2ndPageTransExistInDashboard(){
		return bot.isElementDisplayed1(transactionGoTo2ndPageWidget);
	}
	
	
	// Is 2nd transaction exist in dashboard
	public Boolean isBackHomeTransExistInDashboard(){
		return bot.isElementDisplayed1(transactionBackHomeWidget);
	}
	
	





}