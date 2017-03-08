package controllers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @Author Gladson Antony
 * @Date 25-Dec-2016
 */

public class BrowserFactory extends TestHelper
{
	@BeforeClass(enabled = true)
	public void StartBrowser() 
	{
		System.out.println("Operating System: " + OSName);

		if (BrowserType.toLowerCase().equalsIgnoreCase("firefox")) 
		{
			if (OSName.contains("Windows")) 
			{
				System.setProperty("webdriver.gecko.driver", WindowsDrivers + "geckodriver.exe");

				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
				firefoxProfile.setPreference("browser.download.folderList", 1);
				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed");
				firefoxProfile.setPreference("browser.startup.homepage_override.mstone", "about:blank");
				firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
				firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
				firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
				firefoxProfile.setPreference("browser.usedOnWindows10.introURL", "about:blank");
				driver = new FirefoxDriver(firefoxProfile);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Ubuntu") || OSName.contains("Linux"))
			{
				System.setProperty("webdriver.gecko.driver", LinuxDrivers + "geckodriver");
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			}
		}

		else if (BrowserType.toLowerCase().equalsIgnoreCase("chrome")) 
		{
			if (OSName.contains("Windows")) 
			{
				System.setProperty("webdriver.chrome.driver", WindowsDrivers + "chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Ubuntu") || OSName.contains("Linux")) 
			{
				System.setProperty("webdriver.chrome.driver", LinuxDrivers + "chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Mac"))
			{
				System.setProperty("webdriver.chrome.driver", MacDrivers + "chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			}
		}

		else if (BrowserType.toLowerCase().equalsIgnoreCase("ie"))
		{
			if (OSName.contains("Windows")) 
			{
				System.setProperty("webdriver.ie.driver", WindowsDrivers + "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else 
			{
				System.out.println("Internet Explorer Only Supports Windows Environment");
			}
		}

		else if (BrowserType.toLowerCase().equalsIgnoreCase("opera")) 
		{
			if (OSName.contains("Windows")) 
			{
				System.setProperty("webdriver.opera.driver", WindowsDrivers + "operadriver.exe");
				OperaOptions options = new OperaOptions();
				//ChromeOptions options = new ChromeOptions();
				options.setBinary("C:\\Program Files (x86)\\Opera\\launcher.exe");        

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				OperaDriver browser = new OperaDriver(capabilities);
				browser.manage().window().maximize();
				browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				browser.get(WebsiteURL);
			} 
			else if (OSName.contains("Ubuntu") || OSName.contains("Linux")) 
			{
				System.setProperty("webdriver.chrome.driver", LinuxDrivers + "operadriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Mac")) 
			{
				System.setProperty("webdriver.chrome.driver", MacDrivers + "operadriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			}
		} 
		else if (BrowserType.toLowerCase().equalsIgnoreCase("edge")) 
		{
			if (OSName.equals("Windows 10")) 
			{
				System.setProperty("webdriver.edge.driver", WindowsDrivers + "MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else 
			{
				System.out.println("Edge Browser is Only Supported on Windows 10 OS");
			}
		} 
		else if (BrowserType.toLowerCase().equalsIgnoreCase("unit")) 
		{
			driver = new HtmlUnitDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(WebsiteURL);
		} 
		else 
		{
			System.out.println("Please Provide a Valid Browser");
		}
	}
	
	
	@AfterClass(enabled=true, alwaysRun = true)
	public void tearDown() throws Exception 
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
}
