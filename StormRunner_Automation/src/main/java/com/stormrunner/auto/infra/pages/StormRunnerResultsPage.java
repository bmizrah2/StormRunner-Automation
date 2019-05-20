package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class StormRunnerResultsPage extends AbstractPage {

	//private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	//private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));


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
		driver.switchTo().parentFrame();
	}








}