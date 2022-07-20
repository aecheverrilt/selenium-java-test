package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.ProductDetailPage;
import pages.ResultsPage;

class About extends TestBase{

	private WebDriver driver;
	private HomePage homePage;
	private ResultsPage resultsPage;
	private ProductDetailPage productDetailPage;
	
	
	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		homePage = new HomePage(driver);
		resultsPage = new ResultsPage(driver);
		productDetailPage = new ProductDetailPage(driver);
	}
   
	@Test
	public void about() {
		homePage.clickHMenu();
		homePage.clickTVSection();
		//homePage.clickTelevisions();
	}

	@AfterEach
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
