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

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		firstname = "tuan" + getRandomNumber();
		lastname = "le" + getRandomNumber();
		
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
		employeeDetailPage = employeeListPage.clickToAddButton();
		
		employeeDetailPage.enterToFirstNameTextbox(firstname);
		
		employeeDetailPage.enterToLastNameTextbox(lastname);
		
		employeeID = employeeDetailPage.getEmployeeIDAtAddEmployeeForm();
		
		employeeDetailPage.clickToSaveButton();
		
		verifyTrue(employeeDetailPage.isFullnameDisplayedAtHeader(firstname + " " + lastname));
		
		verifyEquals(employeeDetailPage.getFirstnameValueAtPersonalDetailForm(), firstname);
		
		verifyEquals(employeeDetailPage.getLastnameValueAtPersonalDetailForm(), lastname);

		verifyEquals(employeeDetailPage.getEmployeeIDValueAtPersonalDetailForm(), employeeID);

		
	}
	
	@Test
	public void Employee_02_Edit_Employee_By_Personal() {
		
	}
	
	@Test
	public void Employee_02_Edit_Employee_By_Contact() {
		
	}
	
	@Test
	public void Employee_02_Edit_Employee_By_Job() {
		
	}
	
	@Test
	public void Employee_02_Edit_Employee_By_Salary() {
		
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
