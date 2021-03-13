package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AboutUsPageUI;

public class AboutUsPageObject extends BasePage {
	private WebDriver driver;
//	PageGeneratorManager pageGenerator;
	 	
	public AboutUsPageObject(WebDriver driver) {
		this.driver = driver;
//		pageGenerator = PageGeneratorManager.getPageGenerator();
		//khi new 1 Class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		//Cùng tên vs Class
		//ko có kiểu trả về
		// 1 Class có thể có nhiều hàm khởi tạo -> Tính Đa Hình
		//Tính Đa Hình: cùng tên hàm nhưng khác tham số truyền vào
		
	}

	public HomePageObject openHomePage() {
		waitForElementClickable(driver, AboutUsPageUI.HOME_PAGE_LOGO);
		clickToElement(driver, AboutUsPageUI.HOME_PAGE_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}
	

}