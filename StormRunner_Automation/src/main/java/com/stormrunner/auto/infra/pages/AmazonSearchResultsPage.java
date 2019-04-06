package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.web.By2;

public class AmazonSearchResultsPage extends AbstractPage {

	private static final By2 firstNonSponsoredResultTitle = new By2("First product title", By.xpath("//div[@data-index='2']//h5"));
	
	public AmazonSearchResultsPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public String getFirstNonSponsoredResultTitle() {
		return bot.getElementText(firstNonSponsoredResultTitle);
	}
	
	public AmazonProductPage clickOnSearchResultTitleByIndex(int resultIndex) throws Exception {
		
		By2 resultTitle = new By2("Title of search result #" + resultIndex, By.xpath("//div[@data-index='" + resultIndex + "']//h5"));
		bot.click(resultTitle);
		return new AmazonProductPage(driver);
	}
	
	public String getSearchResultTitleByIndex(int resultIndex) throws Exception {
		
		By2 resultTitle = new By2("Title of search result #" + resultIndex, By.xpath("//div[@data-index='" + resultIndex + "']//h5"));
		return bot.getElementText(resultTitle);
	}
}