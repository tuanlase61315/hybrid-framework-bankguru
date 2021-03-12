package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static PageGeneratorManager getPageGenerator() {
		return new  PageGeneratorManager();
	}
	
	public HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public CustomerInforPageObject getCustomerInfo(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
	
}
