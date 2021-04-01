package com.saucelab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.saucelab.ProductPageObject;

public class Level_20_Sort_ASC_DESC extends BaseTest {
	WebDriver driver;
	String username, password;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		username = "standard_user";
		password = "secret_sauce";
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterUserNameTextbox(username);
		loginPage.enterPasswordTextbox(password);
		productPage = loginPage.clickToButtonLogin();
		

		

	}

	@Test
	public void Login_01_Sort_Product_Name() {
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);
		verifyTrue(productPage.areProductNameSortedByAscending());
		
		
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3);
		verifyTrue(productPage.areProductNameSortedByDescending());
		
//		productPage.selectItemInProductSortDropdown("Name (A to Z)");
//		productPage.sleepInSecond(3);
//		verifyTrue(productPage.areProductNameSortedByDescending());
	}

	@Test
	public void Login_02_Sort_Product_Price() {

	}

	@Test
	public void Login_03_To_System() {

	}

	@AfterClass(alwaysRun = true)
	public void cleanBrowser() {
		closeBrowserAndDriver(driver);

	}

	ProductPageObject productPage;
	LoginPageObject loginPage;

}
