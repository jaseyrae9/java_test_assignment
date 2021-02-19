package test.product.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteStudentPage {

	WebDriver driver;

	public DeleteStudentPage(WebDriver driver) {
		this.driver = driver;
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
		return new String[]{ oldId, newId };
	}
}
