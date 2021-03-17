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

public class Level_12_Login_Element_Undislayed extends BaseTest{
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
	public void Login_01_Assert() {
		System.out.println("Step 01 - Failed");
		Assert.assertTrue(false);
		
		System.out.println("Step 02 - Pass");
		Assert.assertTrue(true);
		
		System.out.println("Step 03 - Failed");
		Assert.assertFalse(true);
		
		System.out.println("Step 04 - Pass");
		Assert.assertFalse(false);


	}
	
	@Test
	public void Login_02_Verify(){
		System.out.println("Step 01 - Failed");
		verifyTrue(false);
		
		System.out.println("Step 02 - Pass");
		verifyTrue(true);
		
		System.out.println("Step 03 - Failed");
		verifyFalse(true);
		
		System.out.println("Step 04 - Pass");
		verifyFalse(false);
		
	}
	


	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
}
