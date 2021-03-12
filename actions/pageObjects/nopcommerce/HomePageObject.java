package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	PageGeneratorManager pageGenerator;
	 	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		pageGenerator = PageGeneratorManager.getPageGenerator();
		//khi new 1 Class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		//Cùng tên vs Class
		//ko có kiểu trả về
		// 1 Class có thể có nhiều hàm khởi tạo -> Tính Đa Hình
		//Tính Đa Hình: cùng tên hàm nhưng khác tham số truyền vào
		
	}
	
	public boolean isHomePageSliderDisplay() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SILDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SILDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return pageGenerator.getRegisterPage(driver);
	}

	public LoginPageObject clickLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return pageGenerator.getLoginPage(driver);
		
	}

	public CustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK );
		return pageGenerator.getCustomerInfo(driver);
		
	}

}
