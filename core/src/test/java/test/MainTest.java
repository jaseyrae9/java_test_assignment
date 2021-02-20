package test;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import test.utils.BrowserFactory;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class MainTest implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
	protected static WebDriver driver;
	private static String url = "http://localhost:3000/";
	private static String defaultBrowser = "firefox";
	
    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            // Your "before all tests" startup logic goes here
            // The following line registers a callback hook when the root test context is shut down
            context.getRoot().getStore(GLOBAL).put("callbackHook", this);
            
            System.out.println("-------------- set up ---------");
    		
    		String browserName = Optional.ofNullable(System.getProperty("browser")).orElse(defaultBrowser);
    		System.out.println("name " + browserName);

    		// This will launch broswer and specific url
    		driver = BrowserFactory.startBrowser(browserName, url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        	driver.manage().window().maximize();
            System.out.println("POKRENULO SE " + driver);
        }
    }

    @Override
    public void close() {
        // Your "after all tests" logic goes here
    	driver.quit();
    }
}