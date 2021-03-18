package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class PageGeneratorManager {
	
//	public static PageGeneratorManager getPageGenerator() {
//		return new  PageGeneratorManager();
//	}
	
	@Step("Open Home Page")
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInforPageObject getCustomerInfo(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
	
	public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	
	public static NewsPageObject getNewsPage(WebDriver driver) {
		return new NewsPageObject(driver);
	}

	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	
	public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
		return new SiteMapPageObject(driver);
	}
}
