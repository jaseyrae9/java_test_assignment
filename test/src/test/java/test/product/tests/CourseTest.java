package test.product.tests;

import static org.testng.Assert.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.course.CoursePage;

@FixMethodOrder(MethodSorters.JVM)
public class CourseTest extends BaseClass {
	
	@Test(description = "This test will add successfully new course.")
	public void addNewCourse() throws InterruptedException {
		// create page object using page factory
		CoursePage page = new CoursePage(driver);
		// call the method
		String[] ret = page.addCourse("kurs 1", 100, 2);
		Reporter.log("[addNewCourseTest] old: " + ret[0], true);
		
		Reporter.log("[addNewCourseTest] new: " + ret[1], true);

		assertNotEquals(ret[0], ret[1]); //old new
	}
	
	@Test(description = "This test will update successfully course.")
	public void updateCourse() {
		CoursePage page = new CoursePage(driver);
		String newName = "Promenjen";
		String oldName = page.updateCourseName(newName);
		Reporter.log("[updateCourseTest] oldName: " + oldName + ", newName: " + newName, true);
		assertNotEquals(oldName, newName); // check if old
	}
	
	@Test(description = "This test will delete successfully course.")
	public void deleteCourse() {
		CoursePage page = new CoursePage(driver);
		String[] ret = page.deleteCourse();
		Reporter.log("[deleteCourseTest] ret[0]: " + ret[0] + ", ret[1]: " + ret[1], true);

		assertNotEquals(ret[0], ret[1]);
	}
}
