package test.product.tests;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.ConfirmationPage;
import test.product.pages.teacher.AddTeacherPage;
import test.product.pages.teacher.DeleteTeacherPage;
import test.product.pages.teacher.EditTeacherPage;

@FixMethodOrder(MethodSorters.JVM)
public class TeacherTest extends BaseClass {

	@Test(description = "This test will add new teacher")
	public void addTeacher() {
		// create page object using page factory
		AddTeacherPage page = new AddTeacherPage(driver);
		ConfirmationPage confirmationPage = page.addTeacher("Neko", "Neko", "neko@gmail.com");
		assertTrue(confirmationPage.isInitialized());
	}
	
	@Test(description = "This test will edit teacher name.")
	public void editTeacherName() {
		EditTeacherPage page = new EditTeacherPage(driver);
		String newName = "Promenjeno";
		String oldName = page.editTeacherName(newName);
		Reporter.log("[editTeacherNameTEst] oldName : "+ oldName + ", newName: " + newName, true);

		assertNotEquals(newName, oldName);
	}
	
	@Test(description = "This test will delete teacher") 
	public void deleteTeacher() {
		DeleteTeacherPage page = new DeleteTeacherPage(driver);
		String[] ret = page.deleteTeacher();
		Reporter.log("[deleteTeacherTEst] id[0]: " + ret[0] + ", id[1]: " + ret[1], true);

		assertNotEquals(ret[0], ret[1]);
	}

}
