package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_Upload_File extends BaseTest {
	WebDriver driver;
	//String[] fileNames = {"No1.jpg"};
	String[] fileNames = {"No1.jpg", "No2.jpg", "No3.jpg"};

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames)); 
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.areFileUploadedSuccess(fileNames));
	
	}


	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private HomePageObject homePage;

}
