package test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	private static WebDriver driver;

	public static WebDriver startBrowser(String browserName, String url) {

		if (browserName.equalsIgnoreCase("firefox")) {
			// Set the driver path
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\jaseyrae9\\Documents\\seleniumdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			// Set the driver path
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\jaseyrae9\\Documents\\seleniumdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Set the driver path
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\jaseyrae9\\Documents\\seleniumdrivers\\edge\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

}
