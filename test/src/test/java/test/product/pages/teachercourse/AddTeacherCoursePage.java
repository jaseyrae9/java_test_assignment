package test.product.pages.teachercourse;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import test.product.pages.PageObject;

public class AddTeacherCoursePage extends PageObject {

	public AddTeacherCoursePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/teacher']")
	WebElement teachersButton;

	@FindBy(how = How.CSS, using = "[data-rowindex='0']")
	WebElement selectRow;

	@FindBy(how = How.CSS, using = "[data-test-id='courses']")
	WebElement toggleCoursesButton;

	@FindBy(how = How.CSS, using = "[data-test-id='add-courses']")
	WebElement addCoursesButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[1]/div")
	WebElement dropDown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[2]/button[1]")
	WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[3]/div/div[2]/div/p")
	WebElement numOfCourses;

	public String[] addTeacherCourse() throws InterruptedException {
		teachersButton.click(); // navigate to teachers page
		selectRow.click(); // select teacher
		toggleCoursesButton.click(); // open teachers courses

		String oldValue = numOfCourses.getText();
		Reporter.log("stara vrednost: " + oldValue, true);

		addCoursesButton.click(); // click add courses button
		dropDown.click(); // open dropdown

		// select course
		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.DOWN).perform();
//		actions.release();
		actions.sendKeys(Keys.ENTER).perform();
		actions.moveToElement(saveButton).click().perform();
		// Thread.sleep(1000);
		Reporter.log("nova vrednost: " + numOfCourses.getText(), true);

		String newValue = numOfCourses.getText();
		return new String[] { oldValue, newValue };
	}
}
