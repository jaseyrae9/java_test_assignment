package test.product.pages.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import test.product.pages.PageObject;

public class ConfirmationPage extends PageObject {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[4]/button")
	@FindBy(how = How.CSS, using = "[data-test-id='courses']")
	WebElement toggleCourses;

	public boolean isInitialized() {
		return toggleCourses.isDisplayed();
	}

}
