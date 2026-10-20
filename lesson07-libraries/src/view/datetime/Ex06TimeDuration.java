package view.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import utils.DateUtils;

public class Ex06TimeDuration {
	
	public static void main(String[] args) {
		// start 1575 mm
		// end   2891 mm
		// --> m dm cm mm
		// 1316mm
		// 1316/1000 = 1m
		// 1316 - 1*1000 - 316
		// 316/100 = 3dm
		// 316 - 3.100 = 16
		// 16/10 = 1cm
		// 16 - 1*10 = 6mm
		
		// start, end --> ms(number)
		
		// Năm, Tháng, [Ngày, Giờ, Phút, Giây] ms
		
		Date start = DateUtils.toDate("15/10/2023 22:00:00", "dd/MM/yyyy HH:mm:ss", false);
		Date end = Calendar.getInstance().getTime();
		
		if (start.after(end)) {
			throw new IllegalArgumentException("Date range is invalid");
		}
		
		long startTime = start.getTime();
		long endTime = end.getTime();
		long duration = endTime - startTime; // ms
		
		long days = TimeUnit.MILLISECONDS.toDays(duration); // convert from ms to days
		
		duration = duration - TimeUnit.DAYS.toMillis(days);
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		
		duration = duration - TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		
		duration = duration - TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		
		System.out.println("days: " + days);
		System.out.println("hours: " + hours);
		System.out.println("minutes: " + minutes);
		System.out.println("seconds: " + seconds);
		
		/*
		 
		 Hạn chế của Date Time trước JAVA 1.8
		 
		 + Date, Calendar luôn lưu trữ dMy Hms
		   --> ko hỗ trợ riêng lẽ
		   --> khó khăn khi lưu trữ cũng như chuyển đổi qua về với date(dMy) time(Hms) trong database
		 + Ít hỗ trợ hàm tìm hiệu giữa 2 mốc thời gian
		 
		 */
	}
	
}
