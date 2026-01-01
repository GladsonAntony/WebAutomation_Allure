/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BrowserFactory;
import pageObjects.modules.GMailPageObjects;
import pageObjects.modules.GoogleHomePageObjects;
import pageObjects.modules.LandingPage;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 * 
 */
public class PageFactoryInitializer extends BrowserFactory
{
	public GoogleHomePageObjects googleHomePage()
	{
		return PageFactory.initElements(driver, GoogleHomePageObjects.class);
	}
	
	public GMailPageObjects gmailPage()
	{
		return PageFactory.initElements(driver, GMailPageObjects.class);
	}

	public LandingPage landingPage()
	{
		return PageFactory.initElements(driver, LandingPage.class);
	}
	

}
