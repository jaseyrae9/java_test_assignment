package test.product.tests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.product.BaseClass;
import test.product.pages.teachercourse.AddTeacherCoursePage;
import test.product.pages.teachercourse.DeleteTeacherCoursePage;

//@FixMethodOrder(MethodSorters.JVM)
public class TeacherCourseTest extends BaseClass {

	@Test
	@DisplayName("This test will add course to teacher.")
	public void addCourseToTeacher() throws InterruptedException {
		AddTeacherCoursePage page = new AddTeacherCoursePage(driver);
		String[] ret = page.addTeacherCourse();
		String oldValue = ret[0];
		String newValue = ret[1];
		System.out.println("[addCourseToTeacher] old: " + oldValue);

		System.out.println("[addCourseToTeacher] new: " + newValue);
		// assertNotEquals(oldValue, newValue); //old new

	}
	
	@Test()
	@DisplayName("This test will delete teacher course.")
	public void deleteTeacherCourse() throws InterruptedException {
		DeleteTeacherCoursePage page = new DeleteTeacherCoursePage(driver);
		String[] ret = page.deleteTeacherCourse();
		System.out.println("[deleteTeacherCourse] old: " + ret[0]);

		System.out.println("[deleteTeacherCourse] new: " + ret[1]);
		assertNotEquals(ret[0], ret[1]); //old new

	}

}
