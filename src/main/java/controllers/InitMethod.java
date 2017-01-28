/**
 * 
 */
package controllers;

import java.awt.Robot;
import java.io.File;
import java.net.URI;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

/**
 * @Author Gladson Antony
 * @Date 28-Jan-2017
 */
public class InitMethod 
{
	static ApplicationConfiguration appConfig = new ApplicationConfiguration();
	
	public static String  BrowserType = appConfig.getBrowserName();
	public static String  WebsiteURL = appConfig.getWebsiteURL();
	public static String  UserName = appConfig.getUserName();
	public static String  Password = appConfig.getPassword();
	public static String  VideoRecordingFeature = appConfig.getVideoRecordingFeature();
	
	public static WebDriver driver;
	public static String FS = File.separator;

	public static String OSName = System.getProperty("os.name");
	public static String OSArchitecture = System.getProperty("os.arch");
	public static String OSVersion = System.getProperty("os.version");
	public static String OSBit = System.getProperty("sun.arch.data.model");

	public static String ProjectWorkingDirectory = System.getProperty("user.dir");
	
	public static String Drivers = "./src/main/resources/Drivers";
	public static String WindowsDrivers= "./src/main/resources/Drivers/Windows/";
	public static String LinuxDrivers =  "./src/main/resources/Drivers/Linux/";
	public static String MacDrivers = "./src/main/resources/Drivers/Mac/";
	
	public static String ExcelFiles = "./src/test/resources/Excel Files/";
	public static String TestData = "./src/test/resources/TestData/";
	public static String PropertiesFiles = "./src/test/resources/Properties Files";
	public static String Reports = "./src/test/resources/Reports";
	
	public static String Images = Reports + FS + "Images" + FS;
	public static String Videos = "./src/test/resources/Reports/Videos/";
	
	public static Robot re;
	public static Alert al;
	public static String robotImageName;
	public static Select se;
	public static String FileToUpload;
	public static Actions ac;
	public static String VideoName;
	public static ScreenRecorder ScreenRec;
	public static ITestResult testResult;
	public static SoftAssert softAssert;
	public static WebDriver augmentedDriver;
	public static ITestResult result;
	public static URI uri;
	public static ScreenRecorder screenRecorder;
		
}
