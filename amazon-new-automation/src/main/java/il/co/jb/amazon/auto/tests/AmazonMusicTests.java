package il.co.jb.amazon.auto.tests;

import org.testng.annotations.Test;

import il.co.jb.amazon.auto.infra.pages.AmazonLandingPage;

public class AmazonMusicTests extends AbstractTest {

	@Test
	public void amazonMusicTest() throws Exception {

		browseToUrl("http://amazon.com");
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		amazonLandingPage.clickAmazonMusicLink();
	}
}
