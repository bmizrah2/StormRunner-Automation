package il.co.jb.amazon.auto.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.jb.amazon.auto.infra.pages.AddedToCartPage;
import il.co.jb.amazon.auto.infra.pages.AmazonLandingPage;
import il.co.jb.amazon.auto.infra.pages.AmazonProductPage;
import il.co.jb.amazon.auto.infra.pages.AmazonSearchResultsPage;

public class ShoppingCartTests extends AbstractTest {

	@Test
	public void shoppingCartTest() throws Exception {
		
		// Step 1 - Browse to amazon.com landing page
		report.startLevel("Step 1 - Browse to amazon.com landing page");
		browseToUrl("http://amazon.com");
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		report.endLevel();
		
		// Step 2 - Write a random search term in the top search bar and click the search button
		report.startLevel("Step 2 - Write a random search term in the top search bar");
		String randomSearchTerm = generateRandomSearchTerm();
		amazonLandingPage.writeToSearchbox(randomSearchTerm);
		AmazonSearchResultsPage amazonSearchResultsPage = amazonLandingPage.clickOnGoButton();
		report.endLevel();
		
		// Step 3 - Click the title of the first item in the list of search results
		report.startLevel("Step 3 - Click the title of the first item");
		AmazonProductPage amazonProductPage = amazonSearchResultsPage.clickOnSearchResultTitleByIndex(1);
		report.endLevel();
		
		// Step 4 - Click "Add to Cart" button
		report.startLevel("Step 4 - Click \"Add to Cart\" button");
		AddedToCartPage addedToCartPage = amazonProductPage.clickAddToCartButton();
		report.endLevel();
		
		// Step 5 - Verify the "Cart" icon on the top right of the page shows the correct number of products added to the cart.
		report.startLevel("Step 5 - Verify the \"Cart\" icon");
		Assert.assertEquals(addedToCartPage.getCartCounterValue(), 1, "Wrong number of items in cart");
		report.endLevel();
	}
	
	private String generateRandomSearchTerm() {
		return "iPhone";
	}
}
