package test.product.tests;

import static org.testng.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.studentcourse.AddStudentCoursePage;
import test.product.pages.studentcourse.DeleteStudentCoursePage;
import test.product.pages.studentcourse.EditStudentCoursePage;

@FixMethodOrder(MethodSorters.JVM)
public class StudentCourseTest extends BaseClass {

	@Test(description = "This test will add course to student.")
	public void addCourseToStudent() {
		AddStudentCoursePage page = new AddStudentCoursePage(driver);
		page.addStudentCourse(2);
	}
	
	@Test(description = "This test will edit student course.")
	public void editStudentCourse() {
		EditStudentCoursePage page = new EditStudentCoursePage(driver);
		String actual = page.editStudentCourse(10);
		String expected = "10";
		assertEquals(actual, expected);
	}
	
	@Test(description = "This test will delete student course.")
	public void deleteStudentCourse() {
		DeleteStudentCoursePage page = new DeleteStudentCoursePage(driver);
		page.deleteStudentCourse();
	}
}
