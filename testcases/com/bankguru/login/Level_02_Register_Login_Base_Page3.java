package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_Base_Page3 extends BasePage {
	WebDriver driver;
	String username, password, loginPageUrl, email;
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

	}
	
	@Test
	public void Login_01_Register_To_System() {
		loginPageUrl = getPageUrl(driver);
		clickToElement(driver, "//a[text()='here']");
		sendkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		sleepInSecond(3);
		
		clickToElement(driver, "//input[@name='btnLogin']");
		sleepInSecond(3);
		username = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");

	}

	@Test
	public void Login_02_To_System() {
		openPageUrl(driver, loginPageUrl);
		
		sendkeyToElement(driver, "//input[@name='uid']", username);
		sendkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
				
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
	}
	
	/**
	 * @return
	 */
	public String getRandomEmail() {
		Random rand = new Random();
		
		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
