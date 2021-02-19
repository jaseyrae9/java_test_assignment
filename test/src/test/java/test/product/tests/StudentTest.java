package test.product.tests;

import static org.testng.Assert.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.student.AddNewStudentPage;
import test.product.pages.student.DeleteStudentPage;
import test.product.pages.student.EditStudentPage;

@FixMethodOrder(MethodSorters.JVM)
public class StudentTest extends BaseClass {

	@Test(description = "This test will add successfully new student.")
	public void addNewStudent() {

		// Created Page Object using Page Factory
		AddNewStudentPage page = PageFactory.initElements(driver, AddNewStudentPage.class);

		// Call the method
		page.addNewStudent("Jelena", "Surlan", "Neki", "jelena@gmail.com", 123456);
	}

	@Test(description = "This test will update student name.")
	public void updateStudentName() {
		EditStudentPage page = PageFactory.initElements(driver, EditStudentPage.class);
		String newName = "Promenjen";
		String oldName = page.updateStudentName(newName);
		assertNotEquals(oldName, newName);
	}

	@Test(description = "This test will delete student.")
	public void deleteStudent() {
		DeleteStudentPage page = PageFactory.initElements(driver, DeleteStudentPage.class);
		String[] ret = page.deleteStudent();
		assertNotEquals(ret[0], ret[1]);
	}

}
