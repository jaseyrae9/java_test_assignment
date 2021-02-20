package test.product.pages.studentcourse;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import test.product.pages.PageObject;

public class AddStudentCoursePage extends PageObject {

	public AddStudentCoursePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/student']")
	WebElement studentsButton;

	@FindBy(how = How.CSS, using = "[data-rowindex='0']")
	WebElement selectRow;

	@FindBy(how = How.CSS, using = "[data-test-id='courses']")
	WebElement toggleCoursesButton;

	@FindBy(how = How.CSS, using = "[data-test-id='add-courses']")
	WebElement addCoursesButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[1]/div")
	WebElement dropDown;

	@FindBy(how = How.NAME, using = "classesBought")
	WebElement classesBought;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[3]/button[1]")
	WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[3]/div/div[2]/div/p")
	WebElement numOfCourses;

	public String[] addStudentCourse(Integer numOfClasses) throws InterruptedException {
		studentsButton.click(); // navigate to students page
		selectRow.click(); // select student
		toggleCoursesButton.click(); // toggle courses

		String oldValue = numOfCourses.getText();
		Reporter.log("[aaddStudentCoursePage] stara vrednost: " + oldValue, true);

		
		addCoursesButton.click(); // click add courdses button
		dropDown.click(); // open dropdown/select

		// select course
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.chord(Keys.DOWN)).perform();
		actions.release();
		actions.sendKeys(Keys.chord(Keys.ENTER)).perform();

		// enter number of bought classes
		classesBought.sendKeys(String.valueOf(numOfClasses));

		// click save button
		actions.moveToElement(saveButton).click().perform();
		
//		Thread.sleep(3000);
		Reporter.log("[addStudentCoursePage] nova vrednost: " + numOfCourses.getText(), true);

		String newValue = numOfCourses.getText();
		return new String[] { oldValue, newValue };

	}

}
