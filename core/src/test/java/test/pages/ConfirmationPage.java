package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfirmationPage extends PageObject {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "[data-test-id='courses']")
	WebElement toggleCourses;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div/p")
	WebElement paginationFooterCourse;

	public boolean isInitialized() {
		return toggleCourses.isDisplayed();
	}

	public String getPaginationFooterCourse() {
		return paginationFooterCourse.getText();
	}
}
