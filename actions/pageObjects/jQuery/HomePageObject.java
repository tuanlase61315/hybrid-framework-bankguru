package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
		
	}

	public boolean isPageNumberActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return 	isElementDisplayed(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderTextboxByLable(String lableName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE_NAME, lableName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE_NAME, value, lableName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE_NAME, Keys.ENTER, lableName);
	}

	public boolean areRowRecordDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, female, country, male, total );
		
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, female, country, male, total);
	}

	public void clickToIconByCountryName(String countryname, String actionName) {
		waitForElementVisible(driver, HomePageUI.ACTION_ICON_BY_NAME, countryname, actionName);
		clickToElement(driver, HomePageUI.ACTION_ICON_BY_NAME, countryname, actionName);
		
	}

	public void inputToTextboxByColumnNameAtRowNumber(String columnName, String rowIndex, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName);
		
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName) + 1;
		System.out.println(columnIndex);
		
		sendkeyToElement(driver, HomePageUI.TEXTBOX_AT_COLUMN_AND_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));
		
	}

	public boolean areFilenameLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, fileName))	{
				status = true;
			}else {
				return status;
			}
		}
		return status;
	}

//	public void clickToStartButton() {
//		int uploadButtonSize = getElementSize(driver, HomePageUI.START_UPLOAD_BUTTON);
//		for (int i = 0; i < uploadButtonSize; i++) {
//			waitForElementClickable(driver, HomePageUI.START_UPLOAD_BUTTON);
//			clickToElement(driver, HomePageUI.START_UPLOAD_BUTTON);
//		}	
//	}
	
	public void clickToStartButton() {
		List<WebElement> uploadButtons = getElements(driver, HomePageUI.START_UPLOAD_BUTTON);
		for (WebElement uploadButton : uploadButtons) {
			uploadButton.click();
			sleepInSecond(2);
		}
	}

	public boolean areFileUploadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if(isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME, fileName)) {
				status = true;
			}else {
				return false;
			}
		}
		return status;
	}
	
	
}
