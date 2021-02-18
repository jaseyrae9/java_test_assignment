package test.product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import test.product.utils.BrowserFactory;

public class BaseClass {
	protected static WebDriver driver;
	private static String url = "http://localhost:3000/";

    @BeforeClass
    public static void setUp(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\jaseyrae9\\Documents\\geckodriver.exe");

		Reporter.log("-------------- set up ---------", true);
//        driver = new FirefoxDriver();
		// This will launch broswer and specific url
		driver = BrowserFactory.startBrowser("firefox", url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
		// driver.get(url);
        System.out.println("POKRENULO SE OVO" + driver);
    }
    

    @AfterClass
    public static void closeApp(){
		Reporter.log("-------------- closing driver ---------", true);

		//driver.quit();
    }
}
