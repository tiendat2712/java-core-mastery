package view.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex04DateConverter {
	
	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false); // format in rage
		
		// input
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		String text = "40/10/2023";
		
		// converter
		Date convertedDate = c.getTime();
		System.out.println("calendar -> date: " + convertedDate);
		
		String convertedText = df.format(convertedDate);
		System.out.println("\ncalendar -> date -> string: " + convertedText);
		
		Calendar convertedCalender = Calendar.getInstance();
		convertedCalender.setTime(date);
		System.out.println("\ndate -> calendar: " + convertedCalender);
		
		try {
			convertedDate = df.parse(text); // 10/10/2023 20.10.2023 abc 35/15/2000
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("\nstring -> date: " + convertedDate);
		
		
	}
	
}
