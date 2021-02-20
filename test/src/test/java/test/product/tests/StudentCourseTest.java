package test.product.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.studentcourse.AddStudentCoursePage;
import test.product.pages.studentcourse.DeleteStudentCoursePage;
import test.product.pages.studentcourse.EditStudentCoursePage;

@FixMethodOrder(MethodSorters.JVM)
public class StudentCourseTest extends BaseClass {

	@Test(description = "This test will add course to student.")
	public void addCourseToStudent() throws InterruptedException {
		AddStudentCoursePage page = new AddStudentCoursePage(driver);
		String[] ret = page.addStudentCourse(2);

		String oldValue = ret[0];
		String newValue = ret[1];
		Reporter.log("[addCourseToTeacher] old: " + oldValue, true);

		Reporter.log("[addCourseToTeacher] new: " + newValue, true);
		// assertNotEquals(oldValue, newValue); //old new
	}

	@Test(description = "This test will edit student course.")
	public void editStudentCourse() {
		EditStudentCoursePage page = new EditStudentCoursePage(driver);
		String actual = page.editStudentCourse(10);
		String expected = "10";
		Reporter.log("[editStudentCourseTest] actual : " + actual + ", expected: " + expected, true);
		assertEquals(actual, expected);
	}

	@Test(description = "This test will delete student course.")
	public void deleteStudentCourse() throws InterruptedException {
		DeleteStudentCoursePage page = new DeleteStudentCoursePage(driver);
		String[] ret = page.deleteStudentCourse();
		Reporter.log("[deleteTeacherCourseTEST] old: " + ret[0], true);

		Reporter.log("[deleteTeacherCourseTEST] new: " + ret[1], true);
		assertNotEquals(ret[0], ret[1]); // old new

	}
}
