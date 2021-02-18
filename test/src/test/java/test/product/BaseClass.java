package test.product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import test.product.utils.BrowserFactory;

public class BaseClass {
	protected static WebDriver driver;
	private static String url = "http://localhost:3000/";

	@BeforeTest
    public static void setUp(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\jaseyrae9\\Documents\\geckodriver.exe");

		Reporter.log("-------------- set up ---------", true);
		// This will launch broswer and specific url
		driver = BrowserFactory.startBrowser("firefox", url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    	driver.manage().window().maximize();
        System.out.println("POKRENULO SE " + driver);
    }
    

	@AfterTest
    public static void closeApp(){
		Reporter.log("-------------- closing driver ---------", true);

		//driver.quit();
    }
}
