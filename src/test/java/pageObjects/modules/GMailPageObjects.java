/**
 * 
 */
package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.RandomGenerator;

/**
 * @author Gladson Antony
 * @date Sep 17, 2016
 * 
 */
public class GMailPageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailIDTextBox;
	
	@FindBy(xpath="//input[@id='next']")
	private WebElement nextButton;

	@Step("To Enter Email ID and Click Next Button")
	public void enterEmailID() 
	{
		utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, emailIDTextBox);
		emailIDTextBox.sendKeys(RandomGenerator.GenerateRandomEMAILIDs("google.com"));	
		nextButton.click();
	}
	
	
	
}
