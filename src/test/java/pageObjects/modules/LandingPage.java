package pageObjects.modules;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LandingPage extends PageFactoryInitializer
{
    @FindBy(xpath = "//h5[normalize-space()='Elements']")
    private WebElement iconElements;

    @Step("To Click on the Element SVG Icon")
    public void clickElementsSvgIcon()
    {
        iconElements.click();
    }

}
