package com.nopcomerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.AboutUsPageObject;
import pageObjects.nopcommerce.CustomerInforPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.NewsPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.ShoppingCartPageObject;
import pageObjects.nopcommerce.SiteMapPageObject;
import utilities.FakerConfig;

public class Level_17_Login_Pattern_Object extends BaseTest {
	WebDriver driver;
	FakerConfig faker;
	String emailAddress, password, firstname, lastname;
	String date, month, year;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
//		pageGeneratorPage = PageGeneratorManager.getPageGenerator();

		faker = FakerConfig.getData();
		
//		emailAddress = getRandomEmail();
//		password = "123123";
//		firstname = "FAKE
//		lastname = "le";
//		date = "29";
//		month = "March";
//		year = "1993";
		
		emailAddress = faker.getEmail();
		password = faker.getPassword();
		firstname = faker.getFirstName();
		lastname = faker.getLastName();
		date = "29";
		month = "March";
		year = "1993";

	}

	@Test
	public void Login_01_Validate_At_Register_Form() {
		log.info("Validate - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Validate - Step 02: Click to Register link at Home Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Validate - Step 03: CLick to Register button");
		registerPage.clickToRegisterButton();
				
		log.info("Validate - Step 04: Verify error message displayed at Firstname textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByName(driver, "FirstName"), "First name is required.");
		
		log.info("Validate - Step 05: Verify error message displayed at LastName textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByName(driver, "LastName"), "Last name is required.");
		
		log.info("Validate - Step 06: Verify error message displayed at Firstname textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByName(driver, "Email"), "Email is required.");
		
		log.info("Validate - Step 07: Verify error message displayed at Firstname textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByName(driver, "Password"), "Password is required.");
		
		log.info("Validate - Step 08: Verify error message displayed at Firstname textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByName(driver, "Password"), "Password is required.");
		
	}
	@Test
	public void Login_02_Register_To_System() {
//		log.info("Register - Step 01: Open Home Page");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		
//		log.info("Register - Step 02: Verify Home Page Slider");
//		Assert.assertTrue(homePage.isHomePageSliderDisplay());
		
		log.info("Register - Step 03: Click to Register link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 04: Click to Gender Male Radio Button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("Register - Step 05: Input to Firstname textbox with value: " + firstname);
		registerPage.inputToTextboxByID(driver, "FirstName", firstname);
		
		log.info("Register - Step 06: Input to Lastname textbox with value: " + lastname);
		registerPage.inputToTextboxByID(driver, "LastName", lastname);
		
		log.info("Register - Step 07: Select date dropdown");
		registerPage.selectDropdowByName(driver, "DateOfBirthDay", date);
		
		log.info("Register - Step 09: Select date dropdown");
		registerPage.selectDropdowByName(driver, "DateOfBirthMonth", month);
		
		log.info("Register - Step 10: Select date dropdown");
		registerPage.selectDropdowByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 11: Input to Email textbox with value: " + emailAddress);
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Register - Step 12: Input to Password and Confirm Password textbox with value: " + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Register - Step 13: CLick to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 14: Verify Register Success");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Register - Step 15: Click to Logout button");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Register - Step 16: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
	}

	@Test
	public void Login_03_To_System() {
		log.info("Login - Step 01: Open Login Page");
		loginPage = homePage.clickLoginLink();
		
		log.info("Login - Step 02: Input to Email textbox with value: " + emailAddress);
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login - Step 03: Input to Password textbox with value: " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());

	}

	public String getRandomEmail() {
		Random rand = new Random();

		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}

	@AfterClass(alwaysRun = true)
	public void cleanBrowser() {
		closeBrowserAndDriver(driver);
		
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject customerInfoPage;
	NewsPageObject newsPage;
	AboutUsPageObject aboutUsPage;
	ShoppingCartPageObject shoppingCartPage;
	SiteMapPageObject siteMapPage;
//	PageGeneratorManager pageGeneratorPage;
}
