package test.product.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditStudentPage {

	WebDriver driver;

	public EditStudentPage(WebDriver driver) {
		this.driver = driver;
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

	public void updateStudentName(String argName) {
		studentsButton.click(); // navigate to students page
		singleRow.click(); // select student
		name.clear(); // delete old name
		name.sendKeys(argName); // set new name
		saveButton.click(); // click save button
	}

}
