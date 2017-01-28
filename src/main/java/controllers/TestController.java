/**
 * 
 */
package controllers;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.Method;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.VideoFormatKeys;
import org.monte.media.math.Rational;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.DateAndTime;
import utils.EnvironmentSetup;

/**
 * @Author Gladson Antony
 * @Date 28-Jan-2017
 */
public class TestController extends InitMethod
{
	@BeforeSuite
	public void beforeSuite() throws Exception
	{
		System.out.println("Browser: "+BrowserType);
		System.out.println("Website URL: "+WebsiteURL);
		EnvironmentSetup.environmentSetup();
	}
	

	/* Method to Start Video Recording of the Automation Session */
	@SuppressWarnings("static-access")
	@BeforeMethod(alwaysRun = true)
	public void startRecording(Method methodName) throws Exception 
	{
		File file = new File(Videos);
		String ExecutingMethod = methodName.getName();
		String FileName = String.valueOf(this.getClass().getSimpleName()) + "." + ExecutingMethod + "_"
				+ BrowserType.toUpperCase() + "_" + DateAndTime.getDate() + DateAndTime.getTime();
		
		Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		screenRecorder = new utils.SpecializedScreenRecorder(gc, captureSize,
				new Format(new Object[] { FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.MimeTypeKey,
				"video/avi" }),
				new Format(new Object[] { FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.EncodingKey,
						"tscc", VideoFormatKeys.CompressorNameKey, "tscc", VideoFormatKeys.DepthKey, 24,
						FormatKeys.FrameRateKey, Rational.valueOf((double) 15.0), VideoFormatKeys.QualityKey,
						Float.valueOf(1.0f), FormatKeys.KeyFrameIntervalKey, 900 }),
				new Format(new Object[] { FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.EncodingKey,
						"black", FormatKeys.FrameRateKey, Rational.valueOf((double) 30.0) }),
				null, file, FileName);

		if (VideoRecordingFeature.equalsIgnoreCase("enabled"))
		{
			this.screenRecorder.start();
		}
	}
	
	
	/* Method to Stop Video Recording of the Automation Session */
	public void stopRecording() throws Exception 
	{
		screenRecorder.stop();
	}

	/* After Test 'to Stop Recording of the Automation Session' */
	@AfterMethod
	public void stoprec() throws Exception {
		if (VideoRecordingFeature.equalsIgnoreCase("enabled")) 
		{
			stopRecording();
		}
	}
	
}
