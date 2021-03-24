package com.nopcommerce.common;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class Common_01_Register extends BaseTest {
	WebDriver driver;
	String firstname, lastname;
	public static String emailAddress, password;
	

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
//		pageGeneratorPage = PageGeneratorManager.getPageGenerator();

		emailAddress = getRandomEmail();
		password = "123123";
		firstname = "tuan";
		lastname = "le";

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
		
		log.info("PreCondition - Step 11: Click to Logout button");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("PreCondition - Step 12: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
				
		driver.quit();
	}


	public String getRandomEmail() {
		Random rand = new Random();

		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}


	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
//	PageGeneratorManager pageGeneratorPage;
}
