package com.worldpress.posts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.worldpress.DashboardPageObject;
import pageObjects.worldpress.LoginPageObject;
import pageObjects.worldpress.PageGeneratorManager;

public class Level_11_Login_Assert_Verify extends BaseTest{
	WebDriver driver;
	String username = "automationeditor";
	String password = "automationfc";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	
	@Test
	public void Login_01_Valid_Email_Password() {
		loginPage.inputToUsernameTextbox(username);
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
		Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());
//		dashboardPage.clickToPostMenu();
//		dashboardPage.sleepInSecond(5);
//		dashboardPage.sleepInSecond(5);
//		dashboardPage.clickToScreenOptionButton();
//		dashboardPage.sleepInSecond(5);
	}
	
	@Test
	public void Login_02_Element_Displayed_In_DOM(){
		dashboardPage.sleepInSecond(5);
		dashboardPage.clickToScreenOptionButton();
		dashboardPage.sleepInSecond(5);
		//True
		Assert.assertTrue(dashboardPage.IsActivityCheckboxDisplayed());
		
		
		//False
		dashboardPage.clickToScreenOptionButton();
		dashboardPage.sleepInSecond(5);
		Assert.assertTrue(dashboardPage.IsActivityCheckboxUnDisplayed());
	}
	
	@Test
	public void Login_03_Element_Undisplayed_Without_DOM() {
		boolean postSearch = dashboardPage.IsPostSearchTextboxUnDisplayed();
		System.out.println(postSearch);
		Assert.assertTrue(postSearch);
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
}
