package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject extends BasePage {
	private WebDriver driver;
 	
	
	
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//khi new 1 Class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		//Cùng tên vs Class
		//ko có kiểu trả về
		// 1 Class có thể có nhiều hàm khởi tạo -> Tính Đa Hình
		//Tính Đa Hình: cùng tên hàm nhưng khác tham số truyền vào
		
	}
	
	@FindBy(css = ".ico-register")
	private WebElement registerLink;
	
	@FindBy(css = ".ico-login")
	private WebElement loginLink;
	
	@FindBy(xpath = "//div[@id='nivo-slider']")
	private WebElement myAccountLink;
	
	public boolean isMyAcountLinkDisplayed() {
		 waitForElementVisible(driver, myAccountLink);
		 return isElementDisplayed(driver, myAccountLink);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
		
	}

	public void clickLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}

}
