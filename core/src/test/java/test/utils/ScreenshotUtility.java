package test.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./src/test/resources/screenshots/ " + screenshotName + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception while taking screenshot " + e.getMessage());
		}

		System.err.println("screenshot taken");
	}

}
