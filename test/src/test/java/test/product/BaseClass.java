package test.product;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import test.product.tests.PopulateDatabaseTest;
import test.product.utils.BrowserFactory;

public class BaseClass {
	protected static WebDriver driver;
	private static String url = "http://localhost:3000/";
	private static String defaultBrowser = "firefox";
	
	@BeforeAll
    public static void setUp(){
		System.out.println("-------------- set up ---------");
		
		String browserName = Optional.ofNullable(System.getProperty("browser")).orElse(defaultBrowser);
		System.out.println("name " + browserName);

		// This will launch broswer and specific url
		driver = BrowserFactory.startBrowser(browserName, url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    	driver.manage().window().maximize();
        System.out.println("POKRENULO SE " + driver);
        PopulateDatabaseTest.populateDatabase();
    }
    

	@AfterAll
    public static void closeApp(){
		System.out.println("-------------- closing driver ---------");

		//driver.quit();
    }
}
