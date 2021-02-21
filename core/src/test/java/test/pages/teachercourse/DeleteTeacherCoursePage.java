package test.pages.teachercourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import test.pages.PageObject;

public class DeleteTeacherCoursePage extends PageObject {

	public DeleteTeacherCoursePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/teacher']")
	WebElement teachersButton;

	@FindBy(how = How.CSS, using = "[data-rowindex='0']")
	WebElement selectRow;

	@FindBy(how = How.CSS, using = "[data-test-id='courses']")
	WebElement toggleCoursesButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[1]")
	WebElement selectedCourse;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[2]/button[1]")
	WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[3]/div/div[2]/div/p")
	WebElement num;

	public String[] deleteTeacherCourse() throws InterruptedException {
		teachersButton.click(); // navigate to teachers page
		selectRow.click(); // select teacher
		toggleCoursesButton.click(); // get teacher courses
		String oldValue = num.getText();
		System.out.println("[deleteTeacherCoursePAGE] stara: " + oldValue);
		selectedCourse.click(); // select first course
		deleteButton.click(); // delete course
		Thread.sleep(200);
		String newValue = num.getText();
		System.out.println("[deleteTeacherCoursePAGE] nova: " + newValue);
		return new String[] { oldValue, newValue };
	}

}
