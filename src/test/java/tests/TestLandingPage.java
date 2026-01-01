package tests;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.modules.LandingPage;

public class TestLandingPage extends PageFactoryInitializer
{
	@Description("To verify the working of Landing Page")
	@Test
	public void testLandingPage() throws Exception
	{
		landingPage().clickElementsSvgIcon();
	}
}
