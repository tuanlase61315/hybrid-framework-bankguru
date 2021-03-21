package com.nopcomerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;
import com.nopcommerce.common.Common_02_Cookie;

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

public class Level_15_Login_Share_State_Part_III_Cookie extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		
		
		//login
		log.info("Precondition - Step 01: Open Login Page");
		homePage = PageGeneratorManager.getHomePage(driver);
//		loginPage = homePage.clickLoginLink();
		
		log.info("Precondition - Step 02: Login by cookie");
		for (Cookie cookie : Common_02_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		
		
		homePage.refreshCurrentPage(driver);

		log.info("Login - Step 05: Verify Home Page Slider");
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
	}

	@Test
	public void TC_01_Search_Product_With_Name() {
		
	}
	
	@Test
	public void TC_02_Search_Product_With_Category() {
		
	}
	
	@Test
	public void TC_03_Search_Product_With_Price() {
		
	}
	
	@Test
	public void TC_04_Search_Product_With_Manufacturer() {
		
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

//	PageGeneratorManager pageGeneratorPage;
}
