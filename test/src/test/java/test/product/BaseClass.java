package test.product;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import test.product.tests.PopulateDatabaseTest;
import test.product.utils.BrowserFactory;

public class BaseClass {
	protected static WebDriver driver;
	private static String url = "http://localhost:3000/";
	private static String defaultBrowser = "firefox";
	
	@BeforeTest
    public static void setUp(){
		Reporter.log("-------------- set up ---------", true);
		
		String browserName = Optional.ofNullable(System.getProperty("browser")).orElse(defaultBrowser);
		Reporter.log("name " + browserName, true);

		// This will launch broswer and specific url
		driver = BrowserFactory.startBrowser(browserName, url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    	driver.manage().window().maximize();
        System.out.println("POKRENULO SE " + driver);
        PopulateDatabaseTest.populateDatabase();
    }
    

	@AfterTest
    public static void closeApp(){
		Reporter.log("-------------- closing driver ---------", true);

		//driver.quit();
    }
}
