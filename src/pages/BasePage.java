package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage{
	WebDriver driver;
	
	@FindBy(id = "nav-hamburger-menu")
	WebElement hmenu;
	
	@FindBy(css = "[data-menu-id=\"9\"]")
	WebElement tvSection;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickHMenu() {
		hmenu.click();
	}
	
	public void clickTVSection() {
		tvSection.click();
	}
	
	public void clickTelevisions() {
		List<WebElement> menus = driver.findElements(By.cssSelector("[data-menu-id=\\\"9\\\"]"));
		List<WebElement> lis = menus.get(1).findElements(By.tagName("li"));
		lis.get(2).click();
	}
}
