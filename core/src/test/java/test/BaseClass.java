package test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import test.utils.BrowserFactory;
import test.utils.ScreenshotUtility;

public class BaseClass implements AfterTestExecutionCallback {
	protected static WebDriver driver;
	private static String url = "http://localhost:3000/";
	private static String defaultBrowser = "firefox";

	@BeforeAll
	public static void setUp() {
		System.out.println("-------------- set up ---------");

		String browserName = Optional.ofNullable(System.getProperty("browser")).orElse(defaultBrowser);
		System.out.println("name " + browserName);

		// This will launch broswer and specific url
		driver = BrowserFactory.startBrowser(browserName, url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		System.out.println("POKRENULO SE " + driver);
		// PopulateDatabaseTest.populateDatabase();
	}

	@AfterAll
	public static void closeApp() {
		System.out.println("-------------- closing driver ---------");
		driver.quit();
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		Boolean testResult = context.getExecutionException().isPresent();
		String testDescription = context.getDisplayName();
		System.out.println("test result " + testResult); // false - SUCCESS, true - FAILED
		System.out.println("display name; " + context.getDisplayName());
		System.out.println("driver: " + driver);

		if (testResult) {
			// test failed
			ScreenshotUtility.captureScreenshot(driver, testDescription);
			System.out.println("pao test " + testDescription);
		} else {
			System.out.println("prosao test " + testDescription);
		}
	}
}
