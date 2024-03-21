package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This utility consists of Java specific methods
 * @author Sandeep Anand
 */

public class JavaUtility {

	/**
	 * This method returns the current date in format
	 * @return
	 */
	
	public String getDate()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss"); // "dd-MM-yy hh-mm-ss" --> String format
		String date = f.format(d);
		return date;
	}
}
