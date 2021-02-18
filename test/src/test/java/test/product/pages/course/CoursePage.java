package test.product.pages.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class CoursePage {

	WebDriver driver;

	public CoursePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/course']")
	WebElement courseButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/button")
	WebElement addButton;

	@FindBy(how = How.NAME, using = "developerCourseName")
	WebElement developerCourseName;

	@FindBy(how = How.NAME, using = "costPerClass")
	WebElement costPerClass;

	@FindBy(how = How.NAME, using = "classesPerWeek")
	WebElement classesPerWeek;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[4]/button[1]")
	WebElement saveButton;
	
//	@FindBy(how = How.CSS, using = "[data-id='1']")
//	@FindBy(how = How.CSS, using = "[data-rowindex='0']")

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]")
	WebElement selectedRow; // TODO: mozda promeni na  data-rowindex='0' -> proveri
	
	@FindBy(how = How.CSS, using = "[data-test-id='delete']")
	WebElement deleteButton;

	public void addCourse(String courseName, Integer cost, Integer numOfClassesPerWeek) {
		courseButton.click(); // navigate to course page
		addButton.click(); // open add form

		setCourseData(courseName, cost, numOfClassesPerWeek);
		saveButton.click(); // save course
	}

	public void deleteCourse() {
		selectRow();
		deleteButton.click();
	}
	
	public void selectRow() {
		selectedRow.click();
	}
	
	public void updateCourseName(String courseName) {
		selectRow();
		developerCourseName.clear();
		developerCourseName.sendKeys(courseName);
		saveButton.click(); // save course
	}

	private void setCourseData(String courseName, Integer cost, Integer numOfClassesPerWeek) {
		developerCourseName.sendKeys(courseName);
		costPerClass.sendKeys(String.valueOf(cost));
		classesPerWeek.sendKeys(String.valueOf(numOfClassesPerWeek));
	}
}
