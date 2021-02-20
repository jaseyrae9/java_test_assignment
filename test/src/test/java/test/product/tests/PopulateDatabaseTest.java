package test.product.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import test.product.BaseClass;
import test.product.pages.PopulateDatabasePage;

//@FixMethodOrder(MethodSorters.JVM)
public class PopulateDatabaseTest extends BaseClass {

	public static void populateDatabase() {
		System.out.println("driver" + driver);

		
		// Created Page Object using Page Factory
		PopulateDatabasePage page = new PopulateDatabasePage(driver);

		// Call the method
		String actual = page.clickSettingsButton();
		String expected = "Injected: Students(20), Teachers(20), Courses(20)";
		assertEquals(actual, expected);
	}
}
