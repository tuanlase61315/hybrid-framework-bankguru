package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static EmployeeDetailPageObject getEmployeeDetailPage(WebDriver driver) {
		return new EmployeeDetailPageObject(driver);
	}
	
	public static UserDetailPageObject getUserDetailPage(WebDriver driver) {
		return new UserDetailPageObject(driver);
	}

}
