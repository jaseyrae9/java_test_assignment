package test.product.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import test.product.pages.PageObject;

public class DeleteStudentPage extends PageObject {

	public DeleteStudentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/student']")
	WebElement studentsButton;

	@FindBy(how = How.CSS, using = "[data-rowindex='0']") // select first
	WebElement singleRow;
	
	@FindBy(how = How.CSS, using = "[data-test-id='delete']")
	WebElement deleteButton;
	
	public String[] deleteStudent() {
		studentsButton.click(); // navigate to students page
		singleRow.click(); // select first student
		String oldId = singleRow.getText().split("\\r?\\n")[0]; // get only second column which is student id
		
		deleteButton.click(); // click delete button
		
		singleRow.click(); // select first to get its id
		String newId = singleRow.getText().split("\\r?\\n")[0]; // get only second column which is student id
		Reporter.log("[deleteStudentPage] oldId[0]: " + oldId + ", newId[1]: " + newId, true);

		return new String[]{ oldId, newId };
	}
}
