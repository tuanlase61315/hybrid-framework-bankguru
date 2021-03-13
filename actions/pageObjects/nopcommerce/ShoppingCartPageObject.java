package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
	private WebDriver driver;
//	PageGeneratorManager pageGenerator;
	 	
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
//		pageGenerator = PageGeneratorManager.getPageGenerator();
		//khi new 1 Class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		//Cùng tên vs Class
		//ko có kiểu trả về
		// 1 Class có thể có nhiều hàm khởi tạo -> Tính Đa Hình
		//Tính Đa Hình: cùng tên hàm nhưng khác tham số truyền vào
		
	}

	public AboutUsPageObject openAboutUsPage() {
		waitForElementClickable(driver, ShoppingCartPageUI.ABOUT_US_LINK);
		clickToElement(driver, ShoppingCartPageUI.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);
	}
	

}
