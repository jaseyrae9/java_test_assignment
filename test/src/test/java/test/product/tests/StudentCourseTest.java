package test.product.tests;

import static org.testng.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.studentcourse.AddStudentCoursePage;
import test.product.pages.studentcourse.DeleteStudentCoursePage;
import test.product.pages.studentcourse.EditStudentCoursePage;

@FixMethodOrder(MethodSorters.JVM)
public class StudentCourseTest extends BaseClass {

	@Test(description = "This test will add course to student.")
	public void addCourseToStudent() {
		AddStudentCoursePage page = PageFactory.initElements(driver, AddStudentCoursePage.class);
		page.addStudentCourse(2);
	}
	
	@Test(description = "This test will edit student course.")
	public void editStudentCourse() {
		EditStudentCoursePage page = PageFactory.initElements(driver, EditStudentCoursePage.class);
		String actual = page.editStudentCourse(10);
		String expected = "10";
		assertEquals(actual, expected);
	}
	
	@Test(description = "This test will delete student course.")
	public void deleteStudentCourse() {
		DeleteStudentCoursePage page = PageFactory.initElements(driver, DeleteStudentCoursePage.class);
		page.deleteStudentCourse();
	}
}
