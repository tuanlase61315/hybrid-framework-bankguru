package pageObjects.worldpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.worldpress.DashboardPageUI;

public class DashboardPageObject extends BasePage {

	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderTextDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.HEADER_DASHBOARD_TEXT);
		return isElementDisplayed(driver, DashboardPageUI.HEADER_DASHBOARD_TEXT);
	}

	public boolean IsActivityCheckboxDisplayed() {
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}
	
	public boolean IsActivityCheckboxUnDisplayed() {
		return isElementUndisPlayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}

	public void clickToScreenOptionButton() {
		waitForElementClickable(driver, DashboardPageUI.SCREEN_OPTIONS_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTIONS_BUTTON);

	}

	public void clickToPostMenu() {
		waitForElementClickable(driver, DashboardPageUI.POST_MENU);
		clickToElement(driver, DashboardPageUI.POST_MENU);

	}
	
	public boolean IsPostSearchTextboxUnDisplayed() {
		return isElementUndisPlayed(driver, DashboardPageUI.POST_SEARCH_TEXTBOX);
	}

}
