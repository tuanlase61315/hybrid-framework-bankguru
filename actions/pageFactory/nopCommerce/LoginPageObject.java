package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//khi new 1 Class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		//Cùng tên vs Class
		//ko có kiểu trả về
		// 1 Class có thể có nhiều hàm khởi tạo -> Tính Đa Hình
		//Tính Đa Hình: cùng tên hàm nhưng khác tham số truyền vào
		
	}
	
	//public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	//public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	//public static final String LOGIN_BUTTON = "//button[text()='Log in']";
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(css = ".login-button")
	private WebElement loginButton;
	

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}
	
	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}
	

	
}
