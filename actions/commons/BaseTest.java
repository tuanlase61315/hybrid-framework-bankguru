package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	
	private String projectLocation = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	
	private enum BROWSER{
		CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}
	
	private enum OS{
		WINDOWS, MAC_OS, LINUX;
	}
	
	private enum PLATFORM{
		ANDROID, IOS, WINDOW_PHONE;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if(browser==BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browser==BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser==BROWSER.EDGE_CHROMIUM) {
			System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if(browser==BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser==BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser==BROWSER.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}
	

	private String getSlash(String folderName) {
		String separator = File.separator;

		return separator + folderName + separator;
	}
	
}
