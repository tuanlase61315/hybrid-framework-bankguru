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

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Pagin() {
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageNumberActiveByNumber("15"));

		homePage.openPageByNumber("12");
		Assert.assertTrue(homePage.isPageNumberActiveByNumber("12"));

		homePage.openPageByNumber("7");
		Assert.assertTrue(homePage.isPageNumberActiveByNumber("7"));
	}

	public void Table_02_Search() {
		// Search by Female
		homePage.inputToHeaderTextboxByLable("Females", "750");
		Assert.assertTrue(homePage.areRowRecordDisplayed("750", "Aruba", "756", "1504"));
		homePage.refreshCurrentPage(driver);

		// Search by Country
		homePage.inputToHeaderTextboxByLable("Country", "Aruba");
		Assert.assertTrue(homePage.areRowRecordDisplayed("750", "Aruba", "756", "1504"));
		homePage.refreshCurrentPage(driver);

		// Search by males
		homePage.inputToHeaderTextboxByLable("Males", "756");
		Assert.assertTrue(homePage.areRowRecordDisplayed("750", "Aruba", "756", "1504"));
		homePage.refreshCurrentPage(driver);

		// Search by Total
		homePage.inputToHeaderTextboxByLable("Total", "1504");
		Assert.assertTrue(homePage.areRowRecordDisplayed("750", "Aruba", "756", "1504"));
		homePage.refreshCurrentPage(driver);
	}

	public void Table_03_Edit_Delete() {
		// delete
		homePage.clickToIconByCountryName("Afghanistan", "remove");
		homePage.sleepInSecond(2);

		// delete
		homePage.clickToIconByCountryName("AFRICA", "remove");
		homePage.sleepInSecond(2);

		// delete
		homePage.clickToIconByCountryName("Albania", "remove");
		homePage.sleepInSecond(2);

		homePage.refreshCurrentPage(driver);

		// edit
		homePage.clickToIconByCountryName("Angola", "edit");
		homePage.refreshCurrentPage(driver);

		// edit
		homePage.clickToIconByCountryName("Argentina", "edit");
		homePage.refreshCurrentPage(driver);

		// edit
		homePage.clickToIconByCountryName("Aruba", "edit");

	}

	
	@Test
	public void Table_04_Edit_Delete() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Company", "3", "test 1 ");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Company", "2", "test 2");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Order Placed", "1", "1");
		homePage.sleepInSecond(2);
		
		
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private HomePageObject homePage;

}
