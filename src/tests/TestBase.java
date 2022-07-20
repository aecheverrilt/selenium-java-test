package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public final static String BASE_URL = "http://www.amazon.in";

	protected WebDriver driver;

	@BeforeAll
	public static void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/aecheverri/Downloads/chromedriver");
	}

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		Dimension dem = new Dimension(1920, 1080);
		driver.manage().window().setSize(dem);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BASE_URL);
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
