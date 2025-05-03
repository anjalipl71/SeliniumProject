package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static void getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyy-mm-dd");
		String formatedDate = dateFormat.format(date);
	}

}
