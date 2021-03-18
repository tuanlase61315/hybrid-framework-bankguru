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

import com.sun.org.glassfish.gmbal.Description;

import commons.BasePage;
import commons.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopcommerce.AboutUsPageObject;
import pageObjects.nopcommerce.CustomerInforPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.NewsPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.ShoppingCartPageObject;
import pageObjects.nopcommerce.SiteMapPageObject;

@Feature("User")
public class Level_14_Login_Allure_Report extends BaseTest {
	WebDriver driver;
	String emailAddress, password, firstname, lastname;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
//		pageGeneratorPage = PageGeneratorManager.getPageGenerator();

		emailAddress = getRandomEmail();
		password = "123123";
		firstname = "tuan";
		lastname = "le";

	}
	
	@Description("User 01 - Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_01_Register_To_System() {
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Register - Step 02: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
		
		log.info("Register - Step 03: Click to Register link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 04: Click to Gender Male Radio Button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - Step 05: Input to Firstname textbox with value: " + firstname);
		registerPage.enterToFirstnameTextbox(firstname);
		
		log.info("Register - Step 06: Input to Lastname textbox with value: " + lastname);
		registerPage.enterToLastnameTextbox(lastname);
		
		log.info("Register - Step 07: Input to Email textbox with value: " + emailAddress);
		registerPage.enterToEmailtTextbox(emailAddress);
		
		log.info("Register - Step 08: Input to Password and Confirm Password textbox with value: " + password);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 09: CLick to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 10: Verify Register Success");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Register - Step 11: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Register - Step 12: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
	}

	@Description("User 02 - Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_02_To_System() {
		log.info("Login - Step 01: Open Login Page");
		loginPage = homePage.clickLoginLink();
		
		log.info("Login - Step 02: Input to Email textbox with value: " + emailAddress);
		loginPage.enterToEmailTextBox(emailAddress);
		
		log.info("Login - Step 03: Input to Password textbox with value: " + password);
		loginPage.enterToPasswordTextBox(password);
		
		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());

	}

	@Test 
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(customerInfoPage.getFirstnameTextboxValue(), "tuan1");
		Assert.assertEquals(customerInfoPage.getLastnameTextboxValue(), "le");
	}

	public String getRandomEmail() {
		Random rand = new Random();

		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
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
