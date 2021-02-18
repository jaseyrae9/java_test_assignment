package test.product.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewStudentPage {

	WebDriver driver;

	public AddNewStudentPage(WebDriver driver) {
		this.driver = driver;
	}

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

	public void addNewStudent(String argName, String argSurname, String argAccName, String argEmail,
			int argBankCardNum) {
		addButton.click();
		setStudentData(argName, argSurname, argAccName, argEmail, argBankCardNum);
		saveButton.click();
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
