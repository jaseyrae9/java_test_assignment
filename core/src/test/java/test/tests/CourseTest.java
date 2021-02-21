package test.tests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import test.BaseClass;
import test.pages.course.CoursePage;

//@FixMethodOrder(MethodSorters.JVM)
@ExtendWith(BaseClass.class)
public class CourseTest extends BaseClass {

	@Test
	@DisplayName("This test will add successfully new course.")
	public void addNewCourse() throws InterruptedException {
		// create page object using page factory
		CoursePage page = new CoursePage(driver);
		// call the method
		String[] ret = page.addCourse("kurs 1", 100, 2);
		System.out.println("[addNewCourseTest] old: " + ret[0]);

		System.out.println("[addNewCourseTest] new: " + ret[1]);
		assertNotEquals(ret[0], ret[1]); // old new
	}

	@Test
	@DisplayName("This test will update successfully course")
	public void updateCourse() {
		CoursePage page = new CoursePage(driver);
		String newName = "Promenjen";
		String oldName = page.updateCourseName(newName);
		System.out.println("[updateCourseTest] oldName: " + oldName + ", newName: " + newName);
		assertNotEquals(oldName, newName); 
	}

	@Test
	@DisplayName("This test will delete successfully course.")
	public void deleteCourse() {
		CoursePage page = new CoursePage(driver);
		String[] ret = page.deleteCourse();
		System.out.println("[deleteCourseTest] ret[0]: " + ret[0] + ", ret[1]: " + ret[1]);

		assertNotEquals(ret[0], ret[1]);
	}
}
