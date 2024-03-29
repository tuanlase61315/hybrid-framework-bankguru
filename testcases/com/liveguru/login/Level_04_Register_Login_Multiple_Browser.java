package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	//@Parameters("browser")
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		//driver = getBrowserDriver(browserName);

		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = getRandomEmail();
		password = "123123";

	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		//driver.get("https://live.demoguru99.com/");

		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountFooterLink();

		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);

		loginPage.enterToEmailTextbox("123@123213.12321");
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "Password less than 6 chars")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);

		loginPage.enterToEmailTextbox("tuan@gmail.com");
		loginPage.enterToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test(description = "Email not exist in system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);

		loginPage.enterToEmailTextbox(getRandomEmail());
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");

		
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);

		loginPage.enterToEmailTextbox("tuan@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshCurrentPage(driver);

		loginPage.enterToEmailTextbox("tuan@gmail.com");
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisPlayed());
	}

	public String getRandomEmail() {
		Random rand = new Random();

		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
}
