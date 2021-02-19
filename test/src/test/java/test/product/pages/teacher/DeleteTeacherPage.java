package test.product.pages.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import test.product.pages.PageObject;

public class DeleteTeacherPage extends PageObject {

	public DeleteTeacherPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/teacher']")
	WebElement teachersButton;

	@FindBy(how = How.CSS, using = "[data-rowindex='0']") // select first
	WebElement singleRow;

	@FindBy(how = How.CSS, using = "[data-test-id='delete']")
	WebElement deleteButton;

	public String[] deleteTeacher() {
		teachersButton.click();
		singleRow.click();
		String oldId = singleRow.getText().split("\\r?\\n")[0]; // get only second column which is teacher id

		deleteButton.click(); // delete selected student
		singleRow.click(); // select first to get its id
		String newId = singleRow.getText().split("\\r?\\n")[0]; // get only second column which is teacher id
		Reporter.log("[deleteTeacherPage] oldId[0]: " + oldId + ", newId[1]: " + newId, true);

		return new String[] { oldId, newId };
	}

}
