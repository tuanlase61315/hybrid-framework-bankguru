package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// khi new 1 Class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		// Cùng tên vs Class
		// ko có kiểu trả về
		// 1 Class có thể có nhiều hàm khởi tạo -> Tính Đa Hình
		// Tính Đa Hình: cùng tên hàm nhưng khác tham số truyền vào

	}

//	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
//	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
//	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
//	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
//	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
//	public static final String CONFIRM_TEXTBOX = "//input[@id='ConfirmPassword']";
//	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
//	public static final String SUCCESS_MESSAGE = "//div[@class='result' and text()='Your registration completed']";
//	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";

	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "gender-male")	
	private WebElement genderMaleRadio;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;

	@FindBy(id="Email")
	private WebElement emailTextbox;

	@FindBy(id="Password")
	private WebElement passwordTextbox;

	@FindBy(id="ConfirmPassword")
	private WebElement confirmTexbox;
	
	@FindBy(id="register-button")
	private WebElement registerButton;

	@FindBy(xpath  = "//div[@class='result' and text()='Your registration completed']")
	private WebElement successMessage;

	@FindBy(css = ".ico-logout")
	private WebElement logoutLink;

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);

	}

	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void enterToEmailtTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmTexbox);
		sendkeyToElement(driver, confirmTexbox, confirmPassword);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

}