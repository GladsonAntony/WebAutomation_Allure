package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class Test1 extends PageFactoryInitializer
{
	@Description("To verify the working of GMail link from Google Home Page using JavaScript Executor")
	@Test(dataProvider="excelSheetNameAsMethodName", dataProviderClass=ExcelDataProvider.class)
	public void testGoogle(String TestCaseID, String UserName, String Password)
			throws Exception
	{
		System.out.println("TestCase ID: "+TestCaseID);
		System.out.println("UserName: "+UserName);
		System.out.println("Password: "+Password);
	}
}
