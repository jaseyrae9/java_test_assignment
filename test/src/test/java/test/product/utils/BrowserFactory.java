package test.product.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	private static WebDriver driver;

	public static WebDriver startBrowser(String browserName, String url) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jaseyrae9\\Documents\\geckodriver.exe");

		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);		
		return driver;
	}

}
