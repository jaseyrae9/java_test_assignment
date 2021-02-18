package test.product.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import test.product.BaseClass;
import test.product.pages.student.AddNewStudentPage;
import test.product.pages.student.EditStudentPage;

public class StudentTest extends BaseClass{
	
	@Test(description="This test will add successfully new student.")
	public void addNewStudent() {
		
		// Created Page Object using Page Factory
		AddNewStudentPage page = PageFactory.initElements(driver, AddNewStudentPage.class);
		
		// Call the method
		page.addNewStudent("Jelena", "Surlan", "Neki", "jelena@gmail.com", 123456);
	}

	
	@Test(description="This test will update student name.")
	public void updateStudentName() {
		EditStudentPage page = PageFactory.initElements(driver, EditStudentPage.class);
		page.updateStudentName("Promenjen");
	}
}
