package tests;

import org.testng.annotations.Test;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class Test1 extends PageFactoryInitializer
{	
	@TestCaseId("TC_GMail_001")
	@Description("To verify the working of GMail link from Google Home Page using JavaScript Executor")
	@Test
	public void testGoogle() throws Exception
	{
		googleHomePage()
		.verifyPageTitle()
		.clickonGmailLink();
	}
}
