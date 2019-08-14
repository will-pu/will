package com.neuedu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.util.Date String2UtilDate(String source){
		java.util.Date temp = null;
		try {
			temp = sdf.parse(source);
			return temp;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static java.sql.Date String2SqlDate(String source){
		java.util.Date temp = String2UtilDate(source);
		if(temp != null) {
			return new java.sql.Date(temp.getTime());
		}
		return null;
	}

}
