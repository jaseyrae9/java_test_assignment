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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]/div[1]")
	WebElement singleRow;
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[7]/button[1]")
	WebElement saveButton;


	public void updateStudentName(String argName) {
		singleRow.click(); // it may not be necessary because it opens immediately
		name.clear();
		name.sendKeys(argName);
		saveButton.click();
	}

}
