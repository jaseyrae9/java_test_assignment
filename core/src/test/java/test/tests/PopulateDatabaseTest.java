package test.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import test.BaseClass;
import test.pages.PopulateDatabasePage;

//@FixMethodOrder(MethodSorters.JVM)
public class PopulateDatabaseTest extends BaseClass {

	public void populateDatabase() {
		System.out.println("driver" + driver);

		// Created Page Object using Page Factory
		PopulateDatabasePage page = new PopulateDatabasePage(driver);

		// Call the method
		String actual = page.clickSettingsButton();
		String expected = "Injected: Students(20), Teachers(20), Courses(20)";
		assertEquals(actual, expected);
	}
}
