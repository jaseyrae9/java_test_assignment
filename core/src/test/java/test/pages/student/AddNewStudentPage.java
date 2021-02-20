package test.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import test.pages.ConfirmationPage;
import test.pages.PageObject;

public class AddNewStudentPage extends PageObject {

	public AddNewStudentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/student']")
	WebElement studentsButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/button")
	WebElement addButton;

	@FindBy(how = How.NAME, using = "name")
	WebElement name;

	@FindBy(how = How.NAME, using = "surname")
	WebElement surname;

	@FindBy(how = How.NAME, using = "accountName")
	WebElement accountName;

	@FindBy(how = How.NAME, using = "email")
	WebElement email;

	@FindBy(how = How.NAME, using = "bankCardNumber")
	WebElement bankCardNumber;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[6]/button[1]")
	WebElement saveButton;

	public ConfirmationPage addNewStudent(String argName, String argSurname, String argAccName, String argEmail,
			int argBankCardNum) {
		studentsButton.click(); // navigate to students page
		addButton.click(); // click add button
		setStudentData(argName, argSurname, argAccName, argEmail, argBankCardNum);
		saveButton.click(); // save student
		return new ConfirmationPage(driver);
	}

	private void setStudentData(String argName, String argSurname, String argAccName, String argEmail,
			int argBankCardNum) {
		name.sendKeys(argName);
		surname.sendKeys(argSurname);
		accountName.sendKeys(argAccName);
		email.sendKeys(argEmail);
		bankCardNumber.sendKeys(String.valueOf(argBankCardNum));
	}

}
