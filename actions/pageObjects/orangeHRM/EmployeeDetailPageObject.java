package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends BasePage {
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String fistname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, fistname);
	}

	public void enterToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, lastname);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, EmployeeDetailPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_FORM);
		clickToElement(driver, EmployeeDetailPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_FORM);
	}

	public String getEmployeeIDAtAddEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
	}

	public boolean isFullnameDisplayedAtHeader(String fullname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM, fullname);
		return isElementDisplayed(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM, fullname);
	}

	public Object getFirstnameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	public Object getLastnameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	public Object getEmployeeIDValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

}
