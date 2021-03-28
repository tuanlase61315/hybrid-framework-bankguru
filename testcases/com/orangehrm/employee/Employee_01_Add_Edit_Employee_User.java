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
	String jobTitle, employmentStatus, jobCategory, joinedDate, subUnit, location, startDate, endDate;
	String name, reportingMethod;

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

		jobTitle = "QA Engineer";
		employmentStatus = "Full-Time Contract";
		jobCategory = "Technicians";
		joinedDate = "2010-03-08";
		subUnit = "  Quality Assurance";
		location = "New York Sales Office";
		startDate = "2011-03-08";
		endDate = "2050-10-12";

		name = "Orange Test";
		reportingMethod = "Direct";

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

	@Test
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
	public void Employee_03_Edit_Employee_By_Job() {
		log.info("Edit Employee [Job] - Step 01: Open 'Job' tab");
		employeeDetailPage.openSidebarTabByName("Job");

		employeeListPage.sleepInSecond(2);

		log.info("Edit Employee [Job] - Step 02: Click to 'Edit' button at Job Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Job", "Edit");

		log.info("Edit Employee [Job] - Step 03: Select to 'Job Title' dropdown with value '" + jobTitle + "'");
		employeeDetailPage.selectJobTitleDropdownAtJobForm(jobTitle);

		log.info("Edit Employee [Job] - Step 04: Select to 'Employment Status' dropdown with value '" + employmentStatus + "'");
		employeeDetailPage.selectEmploymentStatusDropdownAtJobForm(employmentStatus);

		log.info("Edit Employee [Job] - Step 05: Select to 'Job Category' dropdown with value '" + jobCategory + "'");
		employeeDetailPage.selectJobCategoryDropdownAtJobForm(jobCategory);

		log.info("Edit Employee [Job] - Step 06: Enter to 'Joined Date' dropdown with value '" + joinedDate + "'");
		employeeDetailPage.enterToJoinedDateTextboxAtJobForm(joinedDate);

		log.info("Edit Employee [Job] - Step 07: Select to 'Sub Unit' textbox with value '" + subUnit + "'");
		employeeDetailPage.selectSubUnitDropdownAtJobForm(subUnit);

		log.info("Edit Employee [Job] - Step 08: Select to 'Location' dropdown with value '" + location + "'");
		employeeDetailPage.selectLocationDropdownAtJobForm(location);

		log.info("Edit Employee [Job] - Step 09: Enter to 'Start Date' textbox with value '" + startDate + "'");
		employeeDetailPage.enterToStartDateTextboxAtJobForm(startDate);

		log.info("Edit Employee [Job] - Step 10: Enter to 'End Date' textbox with value '" + endDate + "'");
		employeeDetailPage.enterToEndDateTextboxAtJobForm(endDate);

		log.info("Edit Employee [Job] - Step 11: Click to 'Save' button at Job Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Job", "Save");

//		Verift data

		log.info("Edit Employee [Job] - Step 12: Verify 'Job Title' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getJobTitleValueAtJobForm(), jobTitle);

		log.info("Edit Employee [Job] - Step 13: Verify 'Employment Status' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getEmploymentStatusValueAtJobForm(), employmentStatus);

		log.info("Edit Employee [Job] - Step 14: Verify 'Job Category' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getJobCategoryValueAtJobForm(), jobCategory);

		log.info("Edit Employee [Job] - Step 15: Verify 'Joined Date' textbox edited successfully");
		verifyEquals(employeeDetailPage.getJoinedDateValueAtJobForm(), joinedDate);

		log.info("Edit Employee [Job] - Step 16: Verify 'Sub Unit' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getSubUnitValueAtJobForm(), subUnit);

		log.info("Edit Employee [Job] - Step 17: Verify 'Location' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getLocationValueAtJobForm(), location);

		log.info("Edit Employee [Job] - Step 18: Verify 'Start Date' textbox edited successfully");
		verifyEquals(employeeDetailPage.getStartDateValueAtJobForm(), startDate);

		log.info("Edit Employee [Job] - Step 19: Verify 'End Date' textbox edited successfully");
		verifyEquals(employeeDetailPage.getEndDateValueAtJobForm(), endDate);

	}

	@Test
	public void Employee_04_Edit_Employee_By_Salary() {
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
	public void Employee_05_Edit_Employee_By_Report_To() {
		log.info("Edit Employee [Report] - Step 01: Open 'Report-to' tab");
		employeeDetailPage.openSidebarTabByName("Report-to");

		employeeListPage.sleepInSecond(2);

		log.info("Edit Employee [Report] - Step 02: Click to 'Add' button at Assigned Supervisors Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Assigned Supervisors", "Add");

		log.info("Edit Employee [Report] - Step 03: Enter to 'Name' textbox with value '" + name + "'");
		employeeDetailPage.enterNameTextboxAtAddSupervisorForm(name);

		log.info("Edit Employee [Report] - Step 04: Select to 'Reporting Method' dropdown with value '" + reportingMethod + "'");
		employeeDetailPage.selectReportingMethodDropdownAtAddSupervisorForm(reportingMethod);

		log.info("Edit Employee [Report] - Step 05: Click to 'Save' button at Add Supervisor Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Add Supervisor", "Save");

		/* Verify data */

		log.info("Edit Employee [Report] - Step 06: Verify Assigned Supervisors are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "sup_list", "Name", "1", name));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "sup_list", "Reporting Method", "1", reportingMethod));

	}

	@Test
	public void Employee_06_Search_Employee() {
		log.info("Search Employee - Step 01: Open 'PIM' page menu");
		employeeDetailPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		employeeListPage.sleepInSecond(2);

		/* Search Employee with Name */
		log.info("Search Employee - Step 02: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 03: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 04: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

		/* Search Employee with ID */
		log.info("Search Employee - Step 05: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 06: Enter to 'ID' textbox with value '" + employeeID + "'");
		employeeListPage.enterToEmployeeIDTextbox(employeeID);

		log.info("Search Employee - Step 07: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 08: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

		/* Search Employee with Name and Employment Status */
		log.info("Search Employee - Step 09: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 10: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 11: Select to 'Employment Status' dropdown with value '" + employmentStatus + "'");
		employeeListPage.selectEmploymentStatusDropdown(employmentStatus);

		log.info("Search Employee - Step 12: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 13: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

		/* Search Employee with Name and Include 'Current Employees Only' */
		log.info("Search Employee - Step 14: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 15: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 16: Select to 'Include' dropdown with value 'Current Employees Only'");
		employeeListPage.selectIncludeDropdown("Current Employees Only");

		log.info("Search Employee - Step 16: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 17: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

		/* Search Employee with Name and Include 'Current and Past Employees' */
		log.info("Search Employee - Step 18: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 19: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 20: Select to 'Include' dropdown with value 'Current and Past Employees'");
		employeeListPage.selectIncludeDropdown("Current and Past Employees");

		log.info("Search Employee - Step 21: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 23: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

		/* Search Employee with Name and Include 'Past Employees Only' */
		log.info("Search Employee - Step 24: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 25: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 26: Select to 'Include' dropdown with value 'Past Employees Only'");
		employeeListPage.selectIncludeDropdown("Past Employees Only");

		log.info("Search Employee - Step 27: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 28: Verify 'No Records Found' text is displayed");
		verifyTrue(employeeDetailPage.isNoRecordFoundDisplayedAtTableName(driver, "resultTable"));

		/* Search Employee with Name and Supervisor Name */
		log.info("Search Employee - Step 29: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 30: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 31: Enter to 'Supervisor Name' textbox with value '" + name + "'");
		employeeListPage.enterToSupervisorNameTextbox(name);

		log.info("Search Employee - Step 32: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 33: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

		/* Search Employee with Name and Job Title */
		log.info("Search Employee - Step 34: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 35: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 36: Select to 'Job Title' dropdown with value '" + jobTitle + "'");
		employeeListPage.selectJobTitleDropdow(jobTitle);

		log.info("Search Employee - Step 37: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 38: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

		/* Search Employee with Name and Sub Unit */
		log.info("Search Employee - Step 39: Click to 'Reset' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 40: Enter to 'Employee Name' textbox with value '" + editFirstname + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextbox(editFirstname + " " + editLastName);

		log.info("Search Employee - Step 41: Select to 'Sub Unit' dropdown with value '" + subUnit + "'");
		employeeListPage.selectSubUniteDropdow(subUnit);

		log.info("Search Employee - Step 42: Click to 'Search' button at Employee Information Form");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");
		employeeListPage.sleepInSecond(2);
		
		log.info("Search Employee - Step 43: Verify Search Result are displayed successfully");
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstname));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeDetailPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", name));

	}

	@Test
	public void Employee_07_Delete_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void cleanBrowser() {
		closeBrowserAndDriver(driver);

	}

}
