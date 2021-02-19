package test.product.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import test.product.pages.PageObject;

public class EditStudentPage extends PageObject {

	public EditStudentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.NAME, using = "name")
	WebElement name;

	@FindBy(how = How.NAME, using = "surname")
	WebElement surname;

	@FindBy(how = How.NAME, using = "email")
	WebElement email;

	@FindBy(how = How.CSS, using = "[data-rowindex='0']") // select first
	WebElement singleRow;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[7]/button[1]")
	WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//a[@href='/student']")
	WebElement studentsButton;

	public String updateStudentName(String argName) {
		studentsButton.click(); // navigate to students page
		singleRow.click(); // select student
		name.clear(); // delete old name
		name.sendKeys(argName); // set new name
		saveButton.click(); // click save button

		String oldName = singleRow.getText().split("\\r?\\n")[1]; // get only second column which is name
		Reporter.log("[updateStudentNamePage] old student name: " + oldName, true);
		return oldName;
	}

}
