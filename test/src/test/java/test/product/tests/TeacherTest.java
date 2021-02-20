package test.product.tests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.product.BaseClass;
import test.product.pages.ConfirmationPage;
import test.product.pages.teacher.AddTeacherPage;
import test.product.pages.teacher.DeleteTeacherPage;
import test.product.pages.teacher.EditTeacherPage;

//@FixMethodOrder(MethodSorters.JVM)
public class TeacherTest extends BaseClass {

	@Test
	@DisplayName("This test will add new teacher")
	public void addTeacher() {
		// create page object using page factory
		AddTeacherPage page = new AddTeacherPage(driver);
		ConfirmationPage confirmationPage = page.addTeacher("Neko", "Neko", "neko@gmail.com");
		assertTrue(confirmationPage.isInitialized());
	}
	
	@Test
	@DisplayName("This test will edit teacher name.")
	public void editTeacherName() {
		EditTeacherPage page = new EditTeacherPage(driver);
		String newName = "Promenjeno";
		String oldName = page.editTeacherName(newName);
		System.out.println("[editTeacherNameTEst] oldName : "+ oldName + ", newName: " + newName);

		assertNotEquals(newName, oldName);
	}
	
	@Test
	@DisplayName("This test will delete teacher") 
	public void deleteTeacher() {
		DeleteTeacherPage page = new DeleteTeacherPage(driver);
		String[] ret = page.deleteTeacher();
		System.out.println("[deleteTeacherTEst] id[0]: " + ret[0] + ", id[1]: " + ret[1]);

		assertNotEquals(ret[0], ret[1]);
	}

}
