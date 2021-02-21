package test.tests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import test.BaseClass;
import test.pages.ConfirmationPage;
import test.pages.student.AddNewStudentPage;
import test.pages.student.DeleteStudentPage;
import test.pages.student.EditStudentPage;

//@FixMethodOrder(MethodSorters.JVM)
@ExtendWith(BaseClass.class)
public class StudentTest extends BaseClass {

	@Test
	@DisplayName("This test will add successfully new student.")
	public void addNewStudent() {

		// Created Page Object using Page Factory
		AddNewStudentPage page = new AddNewStudentPage(driver);

		// Call the method
		ConfirmationPage confirmationPage = page.addNewStudent("Jelena", "Surlan", "Neki", "surlan@gmail.com", 123456);
		assertTrue(confirmationPage.isInitialized());
	}

	@Test
	@DisplayName("This test will update student name.")
	public void updateStudentName() {
		EditStudentPage page = new EditStudentPage(driver);
		String newName = "Promenjen";
		String oldName = page.updateStudentName(newName);
		System.out.println("[updateStudentNameTest] old name: " + oldName + ", new name: " + newName);
		assertNotEquals(oldName, newName);
	}

	@Test
	@DisplayName("This test will delete student.")
	public void deleteStudent() {
		DeleteStudentPage page = new DeleteStudentPage(driver);
		String[] ret = page.deleteStudent();
		System.out.println("[deleteStudentTest] ret[0]: " + ret[0] + ", ret[1]: " + ret[1]);
		assertNotEquals(ret[0], ret[1]);
	}

}
