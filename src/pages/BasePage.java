package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	protected JavascriptExecutor executor;
	

	@FindBy(id = "nav-hamburger-menu")
	WebElement hmenu;

	@FindBy(css = "[data-menu-id=\"9\"]")
	WebElement tvSection;

	@FindBy(css = "[data-menu-id=\"1\"]")
	WebElement mainMenu;

	protected void scrollToElement(WebElement webElement) {
		executor.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
		executor = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}

	public void clickHMenu() {
		hmenu.click();
	}

	public void clickTVSection() {
		scrollToElement(tvSection);
		tvSection.click();
	}

	public void clickTelevisions() {
		List<WebElement> menus = driver.findElements(By.cssSelector("[data-parent-menu-id=\"1\"]"));
		List<WebElement> lis = menus.get(7).findElements(By.tagName("li"));
		lis.get(2).click();
	}
}
