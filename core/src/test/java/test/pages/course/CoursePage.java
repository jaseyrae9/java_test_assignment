package test.pages.course;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import test.pages.PageObject;

public class CoursePage extends PageObject {

	public CoursePage(WebDriver driver) {
		super(driver);
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

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]") // get
																																	// first
																																	// course
	WebElement selectedRow;

	@FindBy(how = How.CSS, using = "[data-test-id='delete']")
	WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div/p")
	WebElement paginationFooter;

	public String[] addCourse(String courseName, Integer cost, Integer numOfClassesPerWeek)
			throws InterruptedException {
		courseButton.click(); // navigate to course page
		addButton.click(); // open add form
		System.out.println(" pre klika [addCoursePage] " + paginationFooter.getText());
		String oldValue = paginationFooter.getText();
		setCourseData(courseName, cost, numOfClassesPerWeek);
		saveButton.click(); // save course
		Thread.sleep(3000);
		System.out.println("posle [addCoursePage] " + paginationFooter.getText());
		String newValue = paginationFooter.getText();

		return new String[] { oldValue, newValue };
	}

	public String[] deleteCourse() {
		selectRow(); // select course
		String oldId = selectedRow.getText().split("\\r?\\n")[0]; // get only second column which is course id
		deleteButton.click(); // delete course

		selectedRow.click(); // select first to get its id

		String newId = selectedRow.getText().split("\\r?\\n")[0]; // get only second column which is course id
		System.out.println("[deleteCoursePage] course: oldId: " + oldId + ", newId: " + newId);

		return new String[] { oldId, newId };
	}

	public void selectRow() {
		courseButton.click(); // navigate to course page
		selectedRow.click(); // select course
	}

	public String updateCourseName(String courseName) {
		selectRow(); // select course
		String oldName = selectedRow.getText().split("\\r?\\n")[1]; // get only second column which is course name
		System.out.println("[updateCourseNamePage] old course name: " + oldName);

		developerCourseName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		// developerCourseName.clear(); // delete old course name
		developerCourseName.sendKeys(courseName); // set new course name

		saveButton.click(); // update course
		return oldName;
	}

	private void setCourseData(String courseName, Integer cost, Integer numOfClassesPerWeek) {
		developerCourseName.sendKeys(courseName);
		costPerClass.sendKeys(String.valueOf(cost));
		classesPerWeek.sendKeys(String.valueOf(numOfClassesPerWeek));
	}
}
