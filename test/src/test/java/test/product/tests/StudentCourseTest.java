package test.product.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.product.BaseClass;
import test.product.pages.studentcourse.AddStudentCoursePage;
import test.product.pages.studentcourse.DeleteStudentCoursePage;
import test.product.pages.studentcourse.EditStudentCoursePage;

//@FixMethodOrder(MethodSorters.JVM)
public class StudentCourseTest extends BaseClass {

	@Test
	@DisplayName("This test will add course to student.")
	public void addCourseToStudent() throws InterruptedException {
		AddStudentCoursePage page = new AddStudentCoursePage(driver);
		String[] ret = page.addStudentCourse(2);

		String oldValue = ret[0];
		String newValue = ret[1];
		System.out.println("[addCourseToTeacher] old: " + oldValue);

		System.out.println("[addCourseToTeacher] new: " + newValue);
		// assertNotEquals(oldValue, newValue); //old new
	}

	@Test
	@DisplayName("This test will edit student course.")
	public void editStudentCourse() {
		EditStudentCoursePage page = new EditStudentCoursePage(driver);
		String actual = page.editStudentCourse(10);
		String expected = "10";
		System.out.println("[editStudentCourseTest] actual : " + actual + ", expected: " + expected);
		assertEquals(actual, expected);
	}

	@Test
	@DisplayName("This test will delete student course.")
	public void deleteStudentCourse() throws InterruptedException {
		DeleteStudentCoursePage page = new DeleteStudentCoursePage(driver);
		String[] ret = page.deleteStudentCourse();
		System.out.println("[deleteTeacherCourseTEST] old: " + ret[0]);

		System.out.println("[deleteTeacherCourseTEST] new: " + ret[1]);
		assertNotEquals(ret[0], ret[1]); // old new

	}
}
