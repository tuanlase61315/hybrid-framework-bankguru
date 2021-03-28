package pageObjects.orangeHRM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.EmployeeDetailPageUI;
import pageUIs.orangeHRM.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePage {
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeDetailPageObject clickToAddButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
		return PageGeneratorManager.getEmployeeDetailPage(driver);
	}

	public void enterToEmployeeNameTextbox(String fullName) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYMENT_NAME_TEXTBOX);
		clickToElement(driver, EmployeeListPageUI.EMPLOYMENT_NAME_TEXTBOX);
		sleepInSecond(1);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYMENT_NAME_TEXTBOX, fullName);
		sleepInSecond(2);
		pressKeyToElement(driver, EmployeeListPageUI.EMPLOYMENT_NAME_TEXTBOX, Keys.TAB);
		sleepInSecond(1);
	}

	public void enterToEmployeeIDTextbox(String employeeID) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYMENT_ID_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYMENT_ID_TEXTBOX, employeeID);
	}

	public void enterToSupervisorNameTextbox(String name) {
		waitForElementVisible(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX, name);
	}

	public void selectEmploymentStatusDropdown(String employmentStatus) {
		waitForElementClickable(driver, EmployeeListPageUI.EMPLOYEE_STATUS_DROPDOWN);
		selectDropdowByText(driver, EmployeeListPageUI.EMPLOYEE_STATUS_DROPDOWN, employmentStatus);

	}

	public void selectIncludeDropdown(String includeValue) {
		waitForElementClickable(driver, EmployeeListPageUI.INCLUDE_DROPDOWN);
		selectDropdowByText(driver, EmployeeListPageUI.INCLUDE_DROPDOWN, includeValue);

	}

	public void selectJobTitleDropdow(String jobTitle) {
		waitForElementClickable(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN);
		selectDropdowByText(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN, jobTitle);

	}

	public void selectSubUniteDropdow(String subUnit) {
		waitForElementClickable(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN);
		selectDropdowByText(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN, subUnit);

	}

}
