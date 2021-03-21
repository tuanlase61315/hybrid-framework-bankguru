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

import com.nopcommerce.common.Common_01_Register;

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

public class Level_15_Login_Share_State_Part_II extends BaseTest {
	WebDriver driver;
	String emailAddress, password, firstname, lastname;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		
		
		//login
		log.info("Precondition - Step 01: Open Login Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickLoginLink();
		
		log.info("Precondition - Step 02: Input to Email textbox with value: " + Common_01_Register.emailAddress);
		loginPage.enterToEmailTextBox(Common_01_Register.emailAddress);
		
		log.info("Precondition - Step 03: Input to Password textbox with value: " + Common_01_Register.password);
		loginPage.enterToPasswordTextBox(Common_01_Register.password);
		
		log.info("Precondition - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
	}

	@Test
	public void TC_01_Sort_Name_Ascending() {
		
	}
	
	@Test
	public void TC_02_Sort_Name_Descending() {
		
	}
	
	@Test
	public void TC_03_Sort_Price_Ascending() {
		
	}
	
	@Test
	public void TC_04_Sort_Price_Descending() {
		
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

}
