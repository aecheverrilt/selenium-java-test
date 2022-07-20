package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage extends BasePage {
	
	@FindBy(id = "s-result-sort-select")
	WebElement sortDropDown;
	
	@FindBy(id = "s-result-sort-select_2")
	WebElement sortOption2;

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	private int findListItemIndexWithText(List<WebElement> listItems, String text) throws IllegalArgumentException {
		for (int i = 0; i < listItems.size(); i++) {
			WebElement currentListItem = listItems.get(i);
			WebElement currentListItemSpan = currentListItem.findElement(By.tagName("Span"));
			if (currentListItemSpan.getText().equals(text)) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}

	public void scrollToBrandsSection() {
		WebElement refinements = driver.findElement(By.id("s-refinements"));
		List<WebElement> sections = refinements.findElements(By.xpath("./child::*"));
		scrollToElement(sections.get(19));
	}

	public void selectBrand(String brandName) {
		WebElement refinements = driver.findElement(By.id("s-refinements"));
		List<WebElement> sections = refinements.findElements(By.xpath("./child::*"));
		List<WebElement> brands = sections.get(19).findElements(By.tagName("li"));
		int index = findListItemIndexWithText(brands, brandName);
		brands.get(index).findElement(By.tagName("i")).click();
	}
	
	public void sortByHighToLow() {
		executor.executeScript("arguments[0].click();", sortDropDown);
		sortOption2.click();
	}

	public void selectResultByIndex(int index) {
		WebElement result = driver.findElement(By.cssSelector("[data-index=\"" + index + "\"]"));
		result.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	

}
