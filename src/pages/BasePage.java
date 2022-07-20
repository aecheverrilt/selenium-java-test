package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		new WebDriverWait(driver,5).until(waitForElementAnimationToFinish(tvSection));
		scrollToElement(tvSection);
		tvSection.click();
	}

	public void clickTelevisions() {
		new WebDriverWait(driver,5).until(waitForElementAnimationToFinish(tvSection));
		List<WebElement> menus = driver.findElements(By.cssSelector("[data-parent-menu-id=\"1\"]"));
		List<WebElement> lis = menus.get(7).findElements(By.tagName("li"));
		lis.get(2).click();
	}
	
	protected ExpectedCondition<Boolean> waitForElementAnimationToFinish(WebElement elem) {
		return new ExpectedCondition<Boolean>() {
			private double x  = 0;
			private double y = 0;
			private double width = 0;
			private double height = 0;

			private double convertToDouble(Object longValue) {
				if (longValue instanceof Long) {
					return ((Long) longValue).doubleValue();
				}

				return (double) longValue;
			}

			@Override
			public Boolean apply(WebDriver driver) {
				Map<String, Object> rect = (Map<String, Object>) executor.executeScript("var rect = arguments[0].getBoundingClientRect(); return { x: rect.x, y: rect.y, width: rect.width, height: rect.height };", elem);

				double newX = convertToDouble(rect.get("x"));
				double newY = convertToDouble(rect.get("y"));
				double newWidth = convertToDouble(rect.get("width"));
				double newHeight = convertToDouble(rect.get("height"));

				if (newX != x || newY != y || newWidth != width || newHeight != height) {
					x = newX;
					y = newY;
					width = newWidth;
					height = newHeight;
					return false;
				}

				return true;
			}
		};
	}
	
	
}
