package test.product.pages.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import test.product.pages.PageObject;

public class EditTeacherPage extends PageObject {

	public EditTeacherPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='/teacher']")
	WebElement teachersButton;
	
	@FindBy(how = How.CSS, using = "[data-rowindex='0']") // select first
	WebElement singleRow;
	
	@FindBy(how = How.NAME, using = "teacherName")
	WebElement teacherName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[5]/button[1]")
	WebElement saveButton;
	
	public String editTeacherName(String name) {
		teachersButton.click(); // navigate to teachers button
		singleRow.click(); // select teacher
		String oldName = singleRow.getText().split("\\r?\\n")[1]; // get only second column which is name

		teacherName.clear(); // delete old name
		teacherName.sendKeys(name); // enter new name
		saveButton.click(); // save teacher
		
		Reporter.log("[editTeacherNamePage] old name: " + oldName, true);
		return oldName;
	}
}
