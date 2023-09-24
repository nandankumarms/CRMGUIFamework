package com.comcast.crm.generic.webdriver_utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		return random.nextInt(5000);
	}
	
	public static String getSystemDateYYYYMMDD() {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formatedDate=new SimpleDateFormat("yyyy-MM-dd");
		return formatedDate.format(calendar.getTime());
		
	}
	
	
	
	public static String getRequiredDateYYYYMMDD(int days) {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formatedDate=new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(calendar.DAY_OF_MONTH, days);
		return formatedDate.format(calendar.getTime());
	}
	
	

}
