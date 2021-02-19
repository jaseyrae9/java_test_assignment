package test.product.tests;

import static org.testng.Assert.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.teachercourse.AddTeacherCoursePage;
import test.product.pages.teachercourse.DeleteTeacherCoursePage;

@FixMethodOrder(MethodSorters.JVM)
public class TeacherCourseTest extends BaseClass {

	@Test(description = "This test will add course to teacher.")
	public void addCourseToTeacher() throws InterruptedException {
		AddTeacherCoursePage page = new AddTeacherCoursePage(driver);
		String[] ret = page.addTeacherCourse();
		String oldValue = ret[0];
		String newValue = ret[1];
		Reporter.log("[addCourseToTeacher] old: " + oldValue, true);

		Reporter.log("[addCourseToTeacher] new: " + newValue, true);
		// assertNotEquals(oldValue, newValue); //old new

	}
	
	@Test(description = "This test will delete teacher course.")
	public void deleteTeacherCourse() {
		DeleteTeacherCoursePage page = new DeleteTeacherCoursePage(driver);
		String[] ret = page.deleteTeacherCourse();
		Reporter.log("[deleteTeacherCourse] old: " + ret[0], true);

		Reporter.log("[deleteTeacherCourse] new: " + ret[1], true);
		assertNotEquals(ret[0], ret[1]); //old new

	}

}
