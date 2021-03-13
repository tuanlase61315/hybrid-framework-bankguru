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

public class Level_07_Login_Page_Switch_Page extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
//		pageGeneratorPage = PageGeneratorManager.getPageGenerator();

		emailAddress = getRandomEmail();
		password = "123123";

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Login_01_Register_To_System() {
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("tuan");
		registerPage.enterToLastnameTextbox("le");
		registerPage.enterToEmailtTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		homePage = registerPage.clickToLogoutLink();

		Assert.assertTrue(homePage.isHomePageSliderDisplay());
	}

	@Test
	public void Login_02_To_System() {
		loginPage = homePage.clickLoginLink();

		loginPage.enterToEmailTextBox(emailAddress);
		loginPage.enterToPasswordTextBox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isHomePageSliderDisplay());

	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(customerInfoPage.getFirstnameTextboxValue(), "tuan");
		Assert.assertEquals(customerInfoPage.getLastnameTextboxValue(), "le");
	}
	
	@Test
	public void User_04_Switch_Page_Object() {
		//Customer info -> site map
		siteMapPage = customerInfoPage.openSiteMapPage(driver);
		
		
		//Site map -> News
		newsPage = siteMapPage.openNewsPage(driver);
		
		//News -> Shopping cart
		shoppingCartPage = newsPage.openShoppingCartPage(driver);
		
		
		//Shopping cart -> About us
		aboutUsPage = shoppingCartPage.openAboutUsPage(driver);
		
		//About us -> homepage
		homePage = aboutUsPage.openHomePage(driver);
		
	}
	
	@Test
	public void User_05_Switch_Page_Object() {
		//Customer info -> site map
		siteMapPage = customerInfoPage.openSiteMapPage(driver);
		
		
		//Site map -> News
		newsPage = siteMapPage.openNewsPage(driver);
		
		//News -> Shopping cart
		shoppingCartPage = newsPage.openShoppingCartPage(driver);
		
		
		//Shopping cart -> About us
		aboutUsPage = shoppingCartPage.openAboutUsPage(driver);
		
		//About us -> homepage
		homePage = aboutUsPage.openHomePage(driver);
		
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
	NewsPageObject	newsPage;
	AboutUsPageObject aboutUsPage;
	ShoppingCartPageObject shoppingCartPage;
	SiteMapPageObject siteMapPage;
//	PageGeneratorManager pageGeneratorPage;
}
