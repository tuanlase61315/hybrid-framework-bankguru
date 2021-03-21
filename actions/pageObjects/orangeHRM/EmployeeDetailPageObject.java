package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmployeeDetailPageObject extends BasePage{
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
