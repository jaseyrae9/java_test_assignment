package test.pages.studentcourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import test.pages.PageObject;

public class DeleteStudentCoursePage extends PageObject {

	public DeleteStudentCoursePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/student']")
	WebElement studentsButton;

	@FindBy(how = How.CSS, using = "[data-rowindex='0']")
	WebElement selectedStudent;

	@FindBy(how = How.CSS, using = "[data-test-id='courses']")
	WebElement toggleCoursesButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[1]")
	WebElement selectedCourse;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[3]/button[3]")
	WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[3]/div/div[2]/div/p")
	WebElement numOfCourses;

	public String[] deleteStudentCourse() throws InterruptedException {
		studentsButton.click(); // navigate to students page
		selectedStudent.click(); // select student
		toggleCoursesButton.click(); // toggle courses
		String oldValue = numOfCourses.getText();
		System.out.println("[deleteStudentCoursePAGE]stara: " + oldValue);
		selectedCourse.click(); // select course
		deleteButton.click(); // save changes
		Thread.sleep(3000);
		String newValue = numOfCourses.getText();
		System.out.println("[deleteStudentCoursePAGE]nova: " + newValue);
		return new String[] { oldValue, newValue };
	}

}
