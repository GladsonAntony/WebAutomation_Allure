package controllers;

import java.time.Duration;
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

	@BeforeClass(enabled = true)
	public void StartBrowser() 
	{
		System.out.println("Operating System: " + OSName);

		if (BrowserType.toLowerCase().equalsIgnoreCase("firefox"))
		{
			if (OSName.contains("Windows")) 
			{
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Ubuntu") || OSName.contains("Linux"))
			{
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			}
		}

		else if (BrowserType.toLowerCase().equalsIgnoreCase("chrome"))
		{
			if (OSName.contains("Windows")) 
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Ubuntu") || OSName.contains("Linux")) 
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Mac"))
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			}
		}

		else if (BrowserType.toLowerCase().equalsIgnoreCase("chrome_headless"))
		{
			if (OSName.contains("Windows")) 
			{
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");  
				chromeOptions.addArguments("--disable-gpu");  
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			} 
			else if (OSName.toLowerCase().contains("Ubuntu") || OSName.contains("Linux"))
			{
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");  
				chromeOptions.addArguments("--disable-gpu");  
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			} 
			else if (OSName.contains("Mac"))
			{
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");  
				chromeOptions.addArguments("--disable-gpu");  
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			}
		}

		else if (BrowserType.toLowerCase().equalsIgnoreCase("ie"))
		{
			if (OSName.contains("Windows")) 
			{
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			} 
			else 
			{
				System.out.println("Internet Explorer Only Supports Windows Environment");
			}
		}

		else if (BrowserType.toLowerCase().equalsIgnoreCase("edge"))
		{
			if (OSName.equals("Windows 10") || (OSName.equals("Windows 11")))
			{
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(WebsiteURL);
			} 
			else 
			{
				System.out.println("Edge Browser is Only Supported on Windows 11 OS");
			}
		} 
		else if (BrowserType.toLowerCase().equalsIgnoreCase("unit"))
		{
			driver = new HtmlUnitDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
