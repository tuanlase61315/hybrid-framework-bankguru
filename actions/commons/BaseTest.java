package commons;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	private String projectLocation = GlobalConstants.PROJECT_LOCATION;
	private String osName = System.getProperty("os.name");

//	Define log variable
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectLocation + getSlash("browserDrivers") + "geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			File file = new File(projectLocation + getSlash("browserExtensions") + "google_translate.xpi");
			profile.addExtension(file);

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectLocation + getSlash("browserDrivers") + "chromedriver.exe");
			File file = new File(projectLocation + getSlash("browserExtensions") + "google_translate.crx");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(file);

			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE_CHROMIUM) {
			System.setProperty("webdriver.edge.driver", projectLocation + getSlash("browserDrivers") + "msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			File file = new File(projectLocation + getSlash("browserExtensions") + "google_translate.xpi");
			profile.addExtension(file);

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();

			/* Add Extend */
			File file = new File(projectLocation + getSlash("browserExtensions") + "google_translate.crx");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(file);
			
			/* Auto Save / Download */
			HashMap<String, Object> chromePerfs = new HashMap<String, Object>();
			chromePerfs.put("profile.default_content_settings.popups", 0);
			chromePerfs.put("download.default_directory", projectLocation + getSlash("dowloadFiles"));
			options.setExperimentalOption("perfs", chromePerfs);
			
			/* Incognito */
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
		} else if (browser == BROWSER.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser == BROWSER.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1366x768");
			driver = new FirefoxDriver(options);

		} else if (browser == BROWSER.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);

		} else if (browser == BROWSER.SAFARI) {
			driver = new SafariDriver();
		} else if (browser == BROWSER.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}

	private String getSlash(String folderName) {
//		String separator = System.getProperty("file.separator");
//		separator = FileSystems.getDefault().getSeparator();
//		separator = File.separator;
		String separator = File.separator;

		return separator + folderName + separator;
	}

	/* verify */
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// Get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}

			// Quit driver executable file in Task Manager
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("edge")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill msedgedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}