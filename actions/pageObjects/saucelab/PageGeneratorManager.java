package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
//	public static PageGeneratorManager getPageGenerator() {
//		return new  PageGeneratorManager();
//	}
	

	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
