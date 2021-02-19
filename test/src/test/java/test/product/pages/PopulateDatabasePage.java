package test.product.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class PopulateDatabasePage extends PageObject {
	
	public PopulateDatabasePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using="//a[@href='/settings']")
	WebElement settingsButton;

	@FindBy(how = How.CLASS_NAME, using="MuiButton-root")
	WebElement startButton;
	
	@FindBy(how = How.XPATH, using=("//*[@id=\"root\"]/div/main/div[2]/div/span"))
	WebElement resultSpan;
	
	public String clickSettingsButton() {
		settingsButton.click();		
		startButton.click();
		Reporter.log("aaa " + resultSpan.getText(), true);
		return resultSpan.getText();
	}
}
