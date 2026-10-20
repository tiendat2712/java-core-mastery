package view.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex03DateFormatter {
	
	public static void main(String[] args) {
		
		// Java07: DateFormat, SimpleDateFormat
		// #format(java.util.Date)
		
		// Date, Calendar, String
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = new Date();
		
		df.setLenient(false);
		
		try {
			df.parse("30/18/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("date: " + df.format(date));
		
		System.out.println();
		
		Calendar c = Calendar.getInstance();
		Date cDate = c.getTime();
		System.out.println("calendar: " + df.format(cDate));
		
	}
}
