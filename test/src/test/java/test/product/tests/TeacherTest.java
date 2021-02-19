package test.product.tests;

import static org.testng.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.teacher.AddTeacherPage;
import test.product.pages.teacher.ConfirmationPage;

@FixMethodOrder(MethodSorters.JVM)
public class TeacherTest extends BaseClass {

	@Test(description = "This test will add new teacher")
	public void addTeacher() {
		// create page object using page factory
		AddTeacherPage page = new AddTeacherPage(driver);
		ConfirmationPage confirmationPage = page.addTeacher("Neko", "Neko", "neko@gmail.com");
		assertTrue(confirmationPage.isInitialized());
	}
}
