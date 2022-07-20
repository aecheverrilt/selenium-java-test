package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

	@FindBy(id = "feature-bullets")
	WebElement aboutSection;
	
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	public boolean aboutSectionIsDisplayed() {
		return aboutSection.isDisplayed();
	}

	public void printAboutSection() {
		List<WebElement> bullets = aboutSection.findElements(By.tagName("li"));
		for (int i = 0; i < bullets.size(); i++) {
			String bulletText = bullets.get(i).findElement(By.tagName("span")).getText();
			System.out.println(bulletText);
		}
	}
}
