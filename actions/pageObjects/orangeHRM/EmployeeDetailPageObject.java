package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends BasePage {
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextboxAtAddEmployeeForm(String fistname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, fistname);
	}

	public void enterToLastNameTextboxAtAddEmployeeForm(String lastname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, lastname);
	}

	public String getEmployeeIDAtAddEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
	}

	public boolean isFullnameDisplayedAtHeader(String fullname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM, fullname);
		return isElementDisplayed(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM, fullname);
	}

	public String getFirstnameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	public String getLastnameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	public String getEmployeeIDValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	public void enterToFirstnameTextboxAtPersonalDetailForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, firstName);
		
	}

	public void enterToLastnameTextboxAtPersonalDetailForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, lastName);
		
	}

	public void enterToSSNNumberTextboxAtPersonalDetailForm(String ssnNumber) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM, ssnNumber);
		
	}

	public void clickToGenderRadioAtPersonalDetailForm(String genderValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
		clickToElement(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
	}

	public void selectMaritalStatusDropdownAtPersonalDetailForm(String maritalValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOW_AT_PERSONAL_DETAIL_FORM);
		selectDropdowByText(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOW_AT_PERSONAL_DETAIL_FORM, maritalValue);
		
	}

	public void selectNationalityDropdownAtPersonalDetailForm(String nationalityValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOW_AT_PERSONAL_DETAIL_FORM);
		selectDropdowByText(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOW_AT_PERSONAL_DETAIL_FORM, nationalityValue);
		
	}

	public void enterToDateOfBirthTextboxAtPersonalDetailForm(String dateOfBirthValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_AT_PERSONAL_DETAIL_FORM, dateOfBirthValue);
	}

	public String getSuccessMessageAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESSFULLY_MESSAGE_AT_PERSONAL_DETAIL_FORM);
		return getElementText(driver, EmployeeDetailPageUI.SUCCESSFULLY_MESSAGE_AT_PERSONAL_DETAIL_FORM);
	}

	public String getSSNNumberValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	public boolean isGenderRadioButtonSelectedAtPersonalDetailForm(String genderValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
		return isElementSelected(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
	}

	public String getMaritalStatusValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOW_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOW_AT_PERSONAL_DETAIL_FORM);
	}

	public String getNationalityValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOW_AT_PERSONAL_DETAIL_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOW_AT_PERSONAL_DETAIL_FORM);
		
		
	}

	public String getDateOfBirthValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_AT_PERSONAL_DETAIL_FORM);
		return getAttributeValue(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_AT_PERSONAL_DETAIL_FORM);
	}

	public void openSidebarTabByName(String tabName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.SIDEBAR_TAB_BY_NAME, tabName);
		clickToElement(driver, EmployeeDetailPageUI.SIDEBAR_TAB_BY_NAME, tabName);
	}

	public void selectPayGradeDropdownAtSalaryForm(String payGradeValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_AT_SALARY_FORM);
		selectDropdowByText(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_AT_SALARY_FORM, payGradeValue);
		
	}

	public void enterToSalaryComponentTextboxAtSalaryForm(String componentText) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SALAYRY_COMPONENT_TEXTBOX_AT_SALARY_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SALAYRY_COMPONENT_TEXTBOX_AT_SALARY_FORM, componentText);
		
	}

	public void selectPayFrequencyDropdownAtSalaryForm(String payFrequencyValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.PAY_FREQUECY_DROPDOWN_AT_SALARY_FORM);
		selectDropdowByText(driver, EmployeeDetailPageUI.PAY_FREQUECY_DROPDOWN_AT_SALARY_FORM, payFrequencyValue);
		
	}

	public void selectCurrencyDropdownAtSalaryForm(String currencyValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.CURENCY_DROPDOWN_AT_SALARY_FORM);
		selectDropdowByText(driver, EmployeeDetailPageUI.CURENCY_DROPDOWN_AT_SALARY_FORM, currencyValue);
	
	}

	public void enterToAmountTextboxAtSalaryForm(String amountValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_AT_SALARY_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_AT_SALARY_FORM, amountValue);
	
		
	}

	public void enterToCommentsTextboxAtSalaryForm(String commentText) {
		waitForElementVisible(driver, EmployeeDetailPageUI.COMMENT_TEXTBOX_AT_SALARY_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.COMMENT_TEXTBOX_AT_SALARY_FORM, commentText);

		
	}

}
