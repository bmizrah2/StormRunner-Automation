package com.stormrunner.auto.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stormrunner.auto.infra.pages.AmazonLandingPage;
import com.stormrunner.auto.infra.pages.AmazonSearchResultsPage;

public class SearchTests extends AbstractTest {

	@Test
	public void _001_amazonSearchTest() throws Exception {
		
		String searchTerm = "Samsung";
		String expectedWordInFisrtResult = "Galaxy";
		
		driver.get("http://amazon.com");
		
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		amazonLandingPage.writeToSearchbox(searchTerm);
		
		AmazonSearchResultsPage amazonSearchResultsPage = amazonLandingPage.clickOnGoButton();
		
		String firstNonSponsoredResultTitle = amazonSearchResultsPage.getFirstNonSponsoredResultTitle();
		
		Assert.assertTrue(firstNonSponsoredResultTitle.contains(expectedWordInFisrtResult), "The first result doesn't contain '" + expectedWordInFisrtResult + "'");
	}
}
