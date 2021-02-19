package test.product.tests;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.ConfirmationPage;
import test.product.pages.student.AddNewStudentPage;
import test.product.pages.student.DeleteStudentPage;
import test.product.pages.student.EditStudentPage;

@FixMethodOrder(MethodSorters.JVM)
public class StudentTest extends BaseClass {

	@Test(description = "This test will add successfully new student.")
	public void addNewStudent() {

		// Created Page Object using Page Factory
		AddNewStudentPage page = new AddNewStudentPage(driver);
	
		// Call the method
		ConfirmationPage confirmationPage = page.addNewStudent("Jelena", "Surlan", "Neki", "jelena@gmail.com", 123456);
		assertTrue(confirmationPage.isInitialized());
	}

	@Test(description = "This test will update student name.")
	public void updateStudentName() {
		EditStudentPage page = new EditStudentPage(driver);
		String newName = "Promenjen";
		String oldName = page.updateStudentName(newName);
		Reporter.log("[updateStudentNameTest] old name: " + oldName + ", new name: " + newName, true);
		assertNotEquals(oldName, newName);
	}

	@Test(description = "This test will delete student.")
	public void deleteStudent() {
		DeleteStudentPage page = new DeleteStudentPage(driver);
		String[] ret = page.deleteStudent();
		Reporter.log("[deleteStudentTest] ret[0]: " + ret[0] + ", ret[1]: " + ret[1], true);
		assertNotEquals(ret[0], ret[1]);
	}

}
