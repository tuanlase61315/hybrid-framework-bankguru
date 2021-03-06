package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerPageUI;


public class CustomerInforPageObject extends BasePage {
	private WebDriver driver;
	 	
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
		//khi new 1 Class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		//Cùng tên vs Class
		//ko có kiểu trả về
		// 1 Class có thể có nhiều hàm khởi tạo -> Tính Đa Hình
		//Tính Đa Hình: cùng tên hàm nhưng khác tham số truyền vào
		
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, CustomerPageUI.EMAIL_TEXTBOX);
	}

	public String getLastnameTextboxValue() {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerPageUI.LASTNAME_TEXTBOX);
	
	}

	public String getFirstnameTextboxValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
	
	}



	
	

}
