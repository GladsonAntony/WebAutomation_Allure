/**
 * 
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.util.Properties;

import controllers.InitMethod;
import org.testng.annotations.Test;

/**
 * @Author Gladson Antony
 * @Date 28-Jan-2017
 */
public class EnvironmentSetup extends InitMethod
{
	@Test
	public static void environmentSetup() throws Exception
	{
		System.out.println("Running Environment Setup");
		try
		{
			Properties properties = new Properties();
			properties.setProperty("Author", "Gladson Antony");
			System.out.println("Author --> " +properties.getProperty("Author"));
			System.out.println("Application URL --> " +properties.getProperty("Application URL"));
			properties.setProperty("OS", OSName);
			System.out.println("OS --> " +properties.getProperty("OS"));
			properties.setProperty("OS Architecture", OSArchitecture.toUpperCase());
			System.out.println("OS Architecture --> " +properties.getProperty("OS Architecture"));
			properties.setProperty("OS Bit", OSBit);
			System.out.println("OS Bit --> " +properties.getProperty("OS Bit"));
			properties.setProperty("Java Version" ,java.lang.Runtime.version().toString());
			System.out.println("Java Version --> " +properties.getProperty("Java Version"));
			properties.setProperty("Java Build Version" ,java.lang.Runtime.version().build().get().toString());
			System.out.println("Java Build Version --> " +properties.getProperty("Java Build Version"));
			properties.setProperty("Host Name", InetAddress.getLocalHost().getHostName());
			System.out.println("Host Name --> " +properties.getProperty("Host Name"));
			properties.setProperty("Host IP Address", InetAddress.getLocalHost().getHostAddress());
			System.out.println("Host IP Address --> " +properties.getProperty("Host IP Address"));

			File file = new File("./src/main/resources/environment.properties");
			System.out.println(file.getAbsolutePath());
			FileOutputStream fileOut = new FileOutputStream(file.getAbsoluteFile());
			properties.store(fileOut, "Environment Setup");
			fileOut.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
