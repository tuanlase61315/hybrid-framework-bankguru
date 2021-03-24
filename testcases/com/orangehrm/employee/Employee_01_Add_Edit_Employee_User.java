package com.orangehrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EmployeeDetailPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGeneratorManager;
import pageObjects.orangeHRM.UserDetailPageObject;

public class Employee_01_Add_Edit_Employee_User extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeDetailPageObject employeeDetailPage;
	UserDetailPageObject userDetailPage;
	EmployeeListPageObject employeeListPage;

	String firstname, lastname, employeeID;
	String editFirstname, editLastName, ssnNumber, gender, marital, nationality, dateOfbirth;
	String payGrade, salaryComponent, payFrequency, currency, amount, comment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneratorManager.getLoginPage(driver);

		firstname = "tuan" + getRandomNumber();
		lastname = "le" + getRandomNumber();
		
		editFirstname = "tuan" + getRandomNumber();
		editLastName = "le" + getRandomNumber();
		ssnNumber = "123";
		gender = "Male";
		marital = "Single";
		nationality = "Vietnamese";
		dateOfbirth = "1993-03-29";

		payGrade = "Grade 1";
		salaryComponent = "Annual Basic Payment";
		payFrequency = "Monthly";
		currency = "United States Dollar";
		amount = "50000";
		comment = "abc123";

		log.info("Pre-Condition - Step 01: Enter to Username textbox");
		loginPage.enterToUsernameTextbox("Admin");

		log.info("Pre-Condition - Step 02: Enter to Password textbox");
		loginPage.enterToPasswordTextbox("admin123");

		log.info("Pre-Condition - Step 03: Click to Login button");
		dashboardPage = loginPage.clickToLoginButton();

	}

	@Test
	public void Employee_01_Add_Employee() {
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
		employeeListPage.sleepInSecond(2);

		log.info("Add Emloyee - Step 01: Click to Add button");
		employeeDetailPage = employeeListPage.clickToAddButton();

		log.info("Add Emloyee - Step 02: Enter to Firstname textbox");
		employeeDetailPage.enterToFirstNameTextboxAtAddEmployeeForm(firstname);

		log.info("Add Emloyee - Step 03: Enter to Lastname textbox");
		employeeDetailPage.enterToLastNameTextboxAtAddEmployeeForm(lastname);

		log.info("Add Emloyee - Step 04: Get Employee ID info");
		employeeID = employeeDetailPage.getEmployeeIDAtAddEmployeeForm();

		log.info("Add Emloyee - Step 05: Click to Save button");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Add Employee", "Save");

		log.info("Add Emloyee - Step 06: Verify Fullname displayed is correct");
		verifyTrue(employeeDetailPage.isFullnameDisplayedAtHeader(firstname + " " + lastname));

		log.info("Add Emloyee - Step 07: Verify Firstname displayed is correct");
		verifyEquals(employeeDetailPage.getFirstnameValueAtPersonalDetailForm(), firstname);

		log.info("Add Emloyee - Step 08: Verify Lastname displayed is correct");
		verifyEquals(employeeDetailPage.getLastnameValueAtPersonalDetailForm(), lastname);

		log.info("Add Emloyee - Step 09: Verify Emloyee ID displayed is correct");
		verifyEquals(employeeDetailPage.getEmployeeIDValueAtPersonalDetailForm(), employeeID);

	}

	public void Employee_02_Edit_Employee_By_Personal() {
		log.info("Edit Employee [Personal] - Step 01: Click to Edit button at Personal Details form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Personal Details", "Edit");

		log.info("Edit Employee [Personal] - Step 02: Enter new info to 'First Name' textbox");
		employeeDetailPage.enterToFirstnameTextboxAtPersonalDetailForm(editFirstname);

		log.info("Edit Employee [Personal] - Step 03: Enter new info to 'Last Name' textbox");
		employeeDetailPage.enterToLastnameTextboxAtPersonalDetailForm(editLastName);

		log.info("Edit Employee [Personal] - Step 04: Enter new info to 'SSN Number' textbox");
		employeeDetailPage.enterToSSNNumberTextboxAtPersonalDetailForm(ssnNumber);

		log.info("Edit Employee [Personal] - Step 05: Click to 'Gender' radio with '" + gender + "'");
		employeeDetailPage.clickToGenderRadioAtPersonalDetailForm(gender);

		log.info("Edit Employee [Personal] - Step 06: Select to 'Marital Status' dropdown with '" + marital + "'");
		employeeDetailPage.selectMaritalStatusDropdownAtPersonalDetailForm(marital);

		log.info("Edit Employee [Personal] - Step 07: Select to 'Nationality' dropdown with '" + nationality + "'");
		employeeDetailPage.selectNationalityDropdownAtPersonalDetailForm(nationality);

		log.info("Edit Employee [Personal] - Step 08: Enter new info to 'Date of Birth' textbox with value '" + dateOfbirth + "'");
		employeeDetailPage.enterToDateOfBirthTextboxAtPersonalDetailForm(dateOfbirth);

		log.info("Edit Employee [Personal] - Step 09: Click to 'Save' button at 'Personal Details' form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Personal Details", "Save");

//		Verify data

		log.info("Edit Employee [Personal] - Step 10: Verify success message displayed with value 'Successfully Saved'");
		verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetailForm(), "Successfully Saved");
		log.info("Edit Employee [Personal] - Step 11: Verify 'First Name' textbox edited successfully");
		verifyEquals(employeeDetailPage.getFirstnameValueAtPersonalDetailForm(), editFirstname);

		log.info("Edit Employee [Personal] - Step 12: Verify 'Last Name' textbox edited successfully");
		verifyEquals(employeeDetailPage.getLastnameValueAtPersonalDetailForm(), editLastName);

		log.info("Edit Employee [Personal] - Step 13: Verify 'SSN Number' textbox edited successfully");
		verifyEquals(employeeDetailPage.getSSNNumberValueAtPersonalDetailForm(), ssnNumber);

		log.info("Edit Employee [Personal] - Step 14: Verify 'Gender' radio edited successfully");
		verifyTrue(employeeDetailPage.isGenderRadioButtonSelectedAtPersonalDetailForm(gender));

		log.info("Edit Employee [Personal] - Step 15: Verify 'Marital Status' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getMaritalStatusValueAtPersonalDetailForm(), marital);

		log.info("Edit Employee [Personal] - Step 16: Verify 'Nationality' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getNationalityValueAtPersonalDetailForm(), nationality);

		log.info("Edit Employee [Personal] - Step 17: Verify 'Date of Birth' textbox edited successfully");
		verifyEquals(employeeDetailPage.getDateOfBirthValueAtPersonalDetailForm(), dateOfbirth);

	}

	@Test
	public void Employee_03_Edit_Employee_By_Contact() {

	}

	@Test
	public void Employee_04_Edit_Employee_By_Job() {

	}

	@Test
	public void Employee_05_Edit_Employee_By_Salary() {
		log.info("Edit Employee [Salary] - Step 01: Open 'Salary' tab");
		employeeDetailPage.openSidebarTabByName("Salary");

		employeeListPage.sleepInSecond(2);
		log.info("Edit Employee [Salary] - Step 02: Click to 'Add' button at Assigned Salary Components Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Assigned Salary Components", "Add");

		log.info("Edit Employee [Salary] - Step 03: Select to 'Pay Grade' dropdown with value '" + payGrade + "'");
		employeeDetailPage.selectPayGradeDropdownAtSalaryForm(payGrade);

		log.info("Edit Employee [Salary] - Step 04: Enter to 'Salary Component' textbox with value '" + salaryComponent + "'");
		employeeDetailPage.enterToSalaryComponentTextboxAtSalaryForm(salaryComponent);
		

		log.info("Edit Employee [Salary] - Step 05: Select to 'Pay Frequency' dropdown with value '" + payFrequency + "'");
		employeeDetailPage.selectPayFrequencyDropdownAtSalaryForm(payFrequency);
		
		log.info("Edit Employee [Salary] - Step 06: Select to 'Currency' dropdown with value '" + currency + "'");
		employeeDetailPage.selectCurrencyDropdownAtSalaryForm(currency);
		
		log.info("Edit Employee [Salary] - Step 07: Select to 'Amount' dropdown with value '" + amount + "'");
		employeeDetailPage.enterToAmountTextboxAtSalaryForm(amount);
		
		log.info("Edit Employee [Salary] - Step 08: Enter to 'Comments' textbox with value '" + comment + "'");
		employeeDetailPage.enterToCommentsTextboxAtSalaryForm(comment);

		log.info("Edit Employee [Salary] - Step 09: Click to 'Save' button at Add Salary Component Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Add Salary Component", "Save");

		/* Verify at Table */
		log.info("Edit Employee [Salary] - Step 10: Verify Salary Component are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Salary Component", "1", salaryComponent));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Pay Frequency", "1", payFrequency));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Currency", "1", currency));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Amount", "1", amount));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Comments", "1", comment));

	}
	
	@Test
	public void Employee_06_Search_Employee() {
		
		
		
	}

	@Test
	public void Employee_07_Add_User_To_Employee() {

	}

	@Test
	public void Employee_08_Search_User() {

	}

	@Test
	public void Employee_09_Delete_User() {

	}

	@Test
	public void Employee_10_Delete_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void cleanBrowser() {
		closeBrowserAndDriver(driver);

	}

}
