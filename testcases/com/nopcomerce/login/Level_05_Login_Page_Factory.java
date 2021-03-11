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

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

public class Level_05_Login_Page_Factory extends BaseTest{
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = getRandomEmail();
		password = "123123";
		

	}
	
	@Test
	public void Login_01_Register_To_System() {
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("tuan");
		registerPage.enterToLastnameTextbox("le");
		registerPage.enterToEmailtTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		registerPage.clickToLogoutLink();
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
	}

	@Test
	public void Login_02_To_System() {
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.enterToEmailTextBox(emailAddress);
		loginPage.enterToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		

		Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
		
		
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
}
