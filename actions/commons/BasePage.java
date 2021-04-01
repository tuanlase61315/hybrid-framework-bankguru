package commons;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.velocity.runtime.directive.Foreach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopcommerce.AboutUsPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.NewsPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.ShoppingCartPageObject;
import pageObjects.nopcommerce.SiteMapPageObject;
import pageUIs.jQuery.HomePageUI;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.orangeHRM.OrangeHRMAbstractPageUI;

public class BasePage {

	private Alert alert;
	private Select select;
	private Actions action;
	private long longTimeout = 10;
	private long shortTimeout = 5;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private Log log;

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public String getDynamicLocator(String locator, String... values) {
		return String.format(locator, (Object[]) values);
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {

		if (driver.toString().toLowerCase().contains("internet explorer")) {
			clickToElementByJS(driver, locator, values);
			sleppInSecond(3);
		} else {
			getElement(driver, getDynamicLocator(locator, values)).click();
		}

	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {
		WebElement element = getElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).getText().trim();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isSelected();
	}

	public boolean isElementEnable(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isEnabled();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}

	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();

		for (String windowID : allWindowsID) {

			if (!windowID.equals(parentID)) {
				// Switch vao 1 window/tab theo id
				driver.switchTo().window(windowID);
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {

		Set<String> allWindowIDs = driver.getWindowHandles();

		System.out.println("so luong windows/tab dang co" + allWindowIDs.size());

		for (String windowID : allWindowIDs) {
			driver.switchTo().window(windowID);

			String actualWIndowTitle = driver.getTitle();
			if (actualWIndowTitle.equals(expectedWindowTitle)) {
				break;
			}
		}

	}

	public void closeAllWindowExceptParent(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();

		for (String windowID : allWindowsID) {
			if (!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				driver.close();
			}

			if (driver.getWindowHandles().size() == 1) {
				driver.switchTo().window(parentID);
				break;
			}
		}
	}

	public void sleppInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sleppInMiliSecond(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			clickToElementByJS(driver, locator);
			sleepInSecond(3);
		} else {
			getElement(driver, locator).click();
		}

	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public int getElementSize(WebDriver driver, String locator, String... values) {
		return getElements(driver, getDynamicLocator(locator, values)).size();
	}

	public void selectDropdowByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public void selectDropdowByText(WebDriver driver, String locator, String itemText, String... values) {
		select = new Select(getElement(driver, getDynamicLocator(locator, values)));
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedText) {

		getElement(driver, parentLocator).click();
		sleppInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItem) {
			if (item.getText().trim().equals(expectedText)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleppInSecond(1);

				item.click();
				sleppInSecond(1);
				break;
			}
		}

	}

	public String getAttributeValue(WebDriver driver, String locator) {
		return getElement(driver, locator).getAttribute("value");
	}

	public String getAttributeByName(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText().trim();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		if (!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	public void unCheckToCheckboxOrRadio(WebDriver driver, String locator) {
		if (getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		boolean status = false;
		try {
			status = getElement(driver, locator).isDisplayed();
			return status;
		} catch (Exception e) {
			return status;
		}

	}

	public boolean isElementUndisPlayed(WebDriver driver, String locator) {
		System.out.println("Start time = " + new Date().toString());
		overideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getElements(driver, locator);
		overideImplicitTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element is DOM but not visible/displayed");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public boolean isElementUndisPlayed(WebDriver driver, String locator, String... values) {
		System.out.println("Start time = " + new Date().toString());
		overideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getElements(driver, getDynamicLocator(locator, values));
		overideImplicitTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element is DOM but not visible/displayed");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public void overideImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public WebDriver switchToIframeByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}

	public WebDriver switchToDefaultContent(WebDriver driver, String locator) {
		return driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();

	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String locator, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... values) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, getDynamicLocator(locator, values)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {

		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public String generateEmail() {
		Random rand = new Random();
		return "test" + rand.nextInt(99999) + "@gmail.com";
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locator) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));

		} catch (Exception e) {
			log.debug("Wait for element visible with error: " + e.getMessage());
		}
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locator, String... values) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(locator, values))));

		} catch (Exception e) {
			log.debug("Wait for element visible with error: " + e.getMessage());
		}
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitForElementInvisble(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = System.getProperty("user.dir") + getDirectorySlash("uploadFiles");

		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, HomePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
//		sendkeyToElement(driver, HomePageUI.UPLOAD_FILE_TYPE, fullFileName);

	}

	public String getDirectorySlash(String folderName) {
//		String separator = System.getProperty("file.separator");
//		separator = FileSystems.getDefault().getSeparator();
//		separator = File.separator;
		String separator = File.separator;

		return separator + folderName + separator;
	}

	// Page commons

	public HomePageObject openHomePage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.HOME_PAGE_LOGO);
		clickToElement(driver, BasePageUI.HOME_PAGE_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}

	public SiteMapPageObject openSiteMapPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SITE_MAP_LINK);
		clickToElement(driver, BasePageUI.SITE_MAP_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);

	}

	public ShoppingCartPageObject openShoppingCartPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SHOPPING_CART_LINK);
		clickToElement(driver, BasePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public AboutUsPageObject openAboutUsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ABOUT_US_LINK);
		clickToElement(driver, BasePageUI.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);
	}

	public NewsPageObject openNewsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.NEWS_LINK);
		clickToElement(driver, BasePageUI.NEWS_LINK);
		return PageGeneratorManager.getNewsPage(driver);
	}

	/* Dynamic Locator - Cach 1 - Page it */

	public BasePage openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);
		clickToElement(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);

//		public static final String HOME_PAGE_LOGO = "//div[@class='header-logo']";
//		public static final String SITE_MAP_LINK = "//a[text()='Sitemap']";
//		public static final String SHOPPING_CART_LINK = "//a[text()='Shopping cart']";
//		public static final String NEWS_LINK = "//ul[@class='list']//a[text()='News']";
//		public static final String ABOUT_US_LINK = "//a[text()='About us']";

		if (pageName.equals("Sitemap")) {
			return PageGeneratorManager.getSiteMapPage(driver);
		} else if (pageName.equals("Shopping cart")) {
			return PageGeneratorManager.getShoppingCartPage(driver);
		} else if (pageName.equals("About us")) {
			return PageGeneratorManager.getAboutUsPage(driver);
		} else if (pageName.equals("News")) {
			return PageGeneratorManager.getNewsPage(driver);
		} else {
			throw new RuntimeException("Please input the conrrect page name");
		}

	}

	/* Dynamic Locator - Cach 2 - Page nhieu */
	public void openFooterPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);
		clickToElement(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);
	}

	public void clickToRadioButtonByID(WebDriver driver, String radioButtonID) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
		if (!isElementSelected(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID)) {
			clickToElement(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
		}

	}

	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	public void clickToButtonByValue(WebDriver driver, String buttonValue) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
	}

	public void selectDropdowByName(WebDriver driver, String dropdowName, String itemText) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdowName);
		selectDropdowByText(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemText, dropdowName);
	}

	public String getErrorMessageAtMandatoryFieldByName(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldName);
		return getElementText(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldName);
	}

	/* Orange HRM */

	public void openMenuPageByName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_LINK, pageName);
		clickToElement(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_LINK, pageName);
	}

	public void clickToButtonByNameAtFromHeader(WebDriver driver, String headerName, String buttonName) {
		waitForElementClickable(driver, OrangeHRMAbstractPageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, headerName, buttonName);
		clickToElement(driver, OrangeHRMAbstractPageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, headerName, buttonName);
	}

	/* Check data table */
	public boolean isInformationDisplayedAtColumnNameAndRowNumber(WebDriver driver, String tableID, String columnName, String rowIndex, String expectedValue) {
		int columnNameIndex = getElementSize(driver, OrangeHRMAbstractPageUI.DYNAMIC_TABLE_COLUMN_NAME_SIBLING, tableID, columnName) + 1;
		String actualValue = getElementText(driver, OrangeHRMAbstractPageUI.TEXTBOX_AT_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnNameIndex));
		return actualValue.equals(expectedValue);
	}

	public boolean isNoRecordFoundDisplayedAtTableName(WebDriver driver, String tableID) {
		waitForElementVisible(driver, OrangeHRMAbstractPageUI.NO_RECORD_FOUND_TEXT_AT_TABLE_NAME, tableID);
		return isElementDisplayed(driver, OrangeHRMAbstractPageUI.NO_RECORD_FOUND_TEXT_AT_TABLE_NAME, tableID);
	}

	/* Sort String Ascending */

	public boolean isDataStringSortedAscending(WebDriver driver, String locator) {
		// khai bao 1 array list
		ArrayList<String> arrayList = new ArrayList<>();

		// tim tat ca cac element matching vs dk (Name/Price/...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// lay text cua tung element add vao array list
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("------Du lieu tren UI: -------------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// copy qua 1 array list moi de SORT trong code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// thuc hien sort asc
		Collections.sort(sortedList);

		System.out.println("-------Du lieu da Sort ASC trong code ---------");
		for (String name : sortedList) {
			System.out.println(name);
		}

		// verify 2 array bang nhau - new du lieu sort tren UI ko chinh xac thi ket qua tra ve sai
		return sortedList.equals(arrayList);
	}

	/* Sort String Descending */
	public boolean isDataStringDSortedDescending(WebDriver driver, String locator) {
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("----Du lieu tren UI-----");
		for (String name : arrayList) {
			System.out.println(name);
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);

		System.out.println("---Du lieu da Sort ASC trong code-----");
		for (String name : sortedList) {
			System.out.println(name);
		}

		Collections.reverse(sortedList);

		System.out.println("---Du lieu da Sort DSC trong code ---");
		for (String name : sortedList) {
			System.out.println(name);
		}

		return sortedList.equals(arrayList);
	}
	
	/* Sort Float Ascending */
	public boolean isDataFloatSortedAscending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		
		System.out.println("---Du lieu tren UI---");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		
		ArrayList<Float> sortedList = new ArrayList<Float>();
		
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		
		
		Collections.sort(sortedList);
		
		System.out.println("---Du lieu da Sort ASC trong code:---");
		for(Float name:sortedList) {
			System.out.println(name);
		}
		
		return sortedList.equals(arrayList);
	}
	
	
	/* Sort Float Descending */
	public boolean isDataFloatSortedDescending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		
		System.out.println("---Du lieu tren UI---");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		
		ArrayList<Float> sortedList = new ArrayList<Float>();
		
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		
		
		Collections.sort(sortedList);
		
		System.out.println("---Du lieu da Sort ASC trong code:---");
		for(Float name:sortedList) {
			System.out.println(name);
		}
		
		
		Collections.reverse(sortedList);

		System.out.println("---Du lieu da Sort DSC trong code ---");
		for (Float name : sortedList) {
			System.out.println(name);
		}
		
		
		return sortedList.equals(arrayList);
	}
	
	/*Sort Date Ascending*/
	public boolean isDataDateSortedAscending(WebDriver driver, String locator) {
		ArrayList<Date> arrayList = new ArrayList<Date>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}
		
		System.out.println("---Du lieu tren UI:");
		for(Date name:arrayList) {
			System.out.println(name);
		}
		
		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		System.out.println("---Du lieu da sort asc trong code:");
		for(Date name:sortedList) {
			System.out.println(name);
		}
		
		return sortedList.equals(arrayList);
	}
	
	
	/* Sort Date Descending */
	public boolean isDataDateSortedDescending(WebDriver driver, String locator) {
		ArrayList<Date> arrayList = new ArrayList<Date>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}
		
		System.out.println("---Du lieu tren UI:");
		for(Date name:arrayList) {
			System.out.println(name);
		}
		
		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		System.out.println("---Du lieu da sort asc trong code:");
		for(Date name:sortedList) {
			System.out.println(name);
		}
		
		Collections.reverse(sortedList);

		System.out.println("---Du lieu da Sort DSC trong code ---");
		for (Date name : sortedList) {
			System.out.println(name);
		}
		
		return sortedList.equals(arrayList);
	}
	
	
	/* format date data */
	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;
	}
	
}
