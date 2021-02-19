package test.product.tests;

import static org.testng.Assert.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.course.CoursePage;

@FixMethodOrder(MethodSorters.JVM)
public class CourseTest extends BaseClass {
	
	@Test(description = "This test will add successfully new course.")
	public void addNewCourse() {
		// create page object using page factory
		CoursePage page = PageFactory.initElements(driver, CoursePage.class);
		
		// call the method
		page.addCourse("kurs 1", 100, 2);
	}
	
	@Test(description = "This test will update successfully course.")
	public void updateCourse() {
		CoursePage page = PageFactory.initElements(driver, CoursePage.class);
		String newName = "Promenjen";
		String oldName = page.updateCourseName(newName);
		assertNotEquals(oldName, newName); // check if old
	}
	
	@Test(description = "This test will delete successfully course.")
	public void deleteCourse() {
		CoursePage page = PageFactory.initElements(driver, CoursePage.class);
		String[] ret = page.deleteCourse();
		assertNotEquals(ret[0], ret[1]);
	}
}
