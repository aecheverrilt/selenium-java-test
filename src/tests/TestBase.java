package tests;

import org.junit.jupiter.api.BeforeAll;

public class TestBase {
	
	@BeforeAll
	public static void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/aecheverri/Downloads/chromedriver");
	}
}
