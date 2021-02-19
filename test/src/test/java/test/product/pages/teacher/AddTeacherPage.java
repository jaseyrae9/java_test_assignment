package test.product.pages.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import test.product.pages.PageObject;

public class AddTeacherPage extends PageObject {

	public AddTeacherPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='/teacher']")
	WebElement teachersButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/button")
	WebElement addButton;
	
	@FindBy(how = How.NAME, using = "teacherName")
	WebElement teacherName;
	
	@FindBy(how = How.NAME, using = "teacherSurname")
	WebElement teacherSurname;
	
	@FindBy(how = How.NAME, using = "teacherEmail")
	WebElement teacherEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[4]/button[1]")
	WebElement saveButton;
	
	public ConfirmationPage addTeacher(String name, String surname, String email) {
		teachersButton.click(); // navigate to teachers page
		addButton.click(); // click add button
		setTeacherData(name, surname, email); 
		saveButton.click(); // save teacher
		return new ConfirmationPage(driver);
	}

	private void setTeacherData(String name, String surname, String email) {
		teacherName.sendKeys(name);
		teacherSurname.sendKeys(surname);
		teacherEmail.sendKeys(email);
	}
	
}
