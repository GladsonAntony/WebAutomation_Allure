package controllers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @Author Gladson Antony
 * @Date 25-Dec-2016
 */

public class BrowserFactory extends TestHelper
{
	static DesiredCapabilities capabilities;

	@SuppressWarnings("deprecation")
	@BeforeClass(enabled = true)
	public void StartBrowser() 
	{
		System.out.println("Operating System: " + OSName);

		if (BrowserType.toLowerCase().equalsIgnoreCase("firefox")) 
		{
			if (OSName.contains("Windows")) 
			{
				System.setProperty("webdriver.gecko.driver", WindowsDrivers + "geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
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

		else if (BrowserType.toLowerCase().equalsIgnoreCase("chrome_headless")) 
		{
			if (OSName.contains("Windows")) 
			{
				System.setProperty("webdriver.chrome.driver", WindowsDrivers + "chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");  
				chromeOptions.addArguments("--disable-gpu");  
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Ubuntu") || OSName.contains("Linux")) 
			{
				System.setProperty("webdriver.chrome.driver", LinuxDrivers + "chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");  
				chromeOptions.addArguments("--disable-gpu");  
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Mac"))
			{
				System.setProperty("webdriver.chrome.driver", MacDrivers + "chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");  
				chromeOptions.addArguments("--disable-gpu");  
				driver = new ChromeDriver(chromeOptions);
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
				System.setProperty("webdriver.chrome.driver", WindowsDrivers + "operadriver.exe");
				capabilities = DesiredCapabilities.opera();
				ChromeOptions optionsOpera = new ChromeOptions();
				optionsOpera.setBinary("C:/Program Files/Opera/launcher.exe");
				capabilities.setCapability(ChromeOptions.CAPABILITY, optionsOpera);
				driver = new ChromeDriver(capabilities);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(WebsiteURL);
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
