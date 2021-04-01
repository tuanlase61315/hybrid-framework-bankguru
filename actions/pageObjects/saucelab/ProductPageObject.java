package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauceLab.ProductPageUI;

public class ProductPageObject extends BasePage{
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductNameSortedByAscending() {
		waitForAllElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);		
		return isDataStringSortedAscending(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductNameSortedByDescending() {
		waitForAllElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);		
		return isDataStringDSortedDescending(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public void selectItemInProductSortDropdown(String itemValue) {
		
		waitForElementClickable(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN);
		selectDropdowByText(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN, itemValue);
		
	}
	
}
