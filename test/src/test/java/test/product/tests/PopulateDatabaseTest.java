package test.product.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.PopulateDatabasePage;

public class PopulateDatabaseTest extends BaseClass{

	/*@Test(description = "This test will populate database.")
	public void populateDatabase() {
		Reporter.log("driver" + driver, true);
		
		// This will launch broswer and specific url
		// WebDriver driver = BrowserFactory.startBrowser("firefox", url);
		
		// Created Page Object using Page Factory
		PopulateDatabasePage page = PageFactory.initElements(driver, PopulateDatabasePage.class);
		
		// Call the method
		String actual = page.clickSettingsButton();
		String expected = "Injected: Students(20), Teachers(20), Courses(20)";
		assertEquals(actual, expected);
		
	}*/
}
