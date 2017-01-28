/**
 * 
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Gladson Antony
 * @Date 28-Jan-2017
 */
public class DateAndTime 
{
	/*	To get the Current Time*/
	public static String getTime() throws Exception 
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("kk.mm");
		String TimeNow = dateFormat.format(date);
		return TimeNow;
	}

	/*	To get the Current Date*/
	public static String getDate() throws Exception 
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String DateNow = dateFormat.format(date);
		return DateNow;
	}

}
