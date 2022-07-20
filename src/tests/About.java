package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import pages.HomePage;
import pages.ProductDetailPage;
import pages.ResultsPage;

class About extends TestBase {

	private HomePage homePage;
	private ResultsPage resultsPage;
	private ProductDetailPage productDetailPage;

	@Test
	public void aboutTest() throws InterruptedException {
		homePage = new HomePage(driver);
		resultsPage = new ResultsPage(driver);
		productDetailPage = new ProductDetailPage(driver);

		homePage.clickHMenu();
		homePage.clickTVSection();
		homePage.clickTelevisions();
		resultsPage.scrollToBrandsSection();
		resultsPage.selectBrand("Samsung");
		resultsPage.sortByHighToLow();
		resultsPage.selectResultByIndex(1);
		Assert.assertTrue(productDetailPage.aboutSectionIsDisplayed());
		productDetailPage.printAboutSection();
	}

}
