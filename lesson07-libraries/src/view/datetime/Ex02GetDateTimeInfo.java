package view.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Ex02GetDateTimeInfo {
	
	public static void main(String[] args) {
		// Locale.setDefault(new Locale("vi", "VN"));
		
		// Lấy thông tin thời gian hiện tại với [timezone]
		Calendar c = Calendar.getInstance(new Locale("vi", "VN"));
		// c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		// c.set(Calendar.YEAR, 2020);
		// c.set(Calendar.MONTH, Calendar.FEBRUARY);
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		// + 1. Ngày, Tháng, Năm
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH) + 1; // month [0, 11]
		int year = c.get(Calendar.YEAR);
		String dmy = day + "/" + month + "/" + year;
		System.out.println("1. Ngày, Tháng, Năm: " + dmy);
		
		// + 2. Giờ 12-24, Phút, Giây
		int hour12 = c.get(Calendar.HOUR);
		int ap = c.get(Calendar.AM_PM);
		System.out.println("2. Giờ: " + hour12 + (ap == 1 ? " PM" : " AM"));
		
		// + 3. Ngày trong tuần(thứ mấy): 1(sunday),2,3,4,5,6,7(saturday)
		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("dow: " + dow); // 1 --> Chủ Nhật, 2 --> Thứ Hai
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		String dowAsString = dayOfWeeks[dow-1];
		System.out.println("dowAsString --> " + dowAsString);
	    
		// + 4. Đếm số ngày trong tháng, năm hiện tại >> Calendar
		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("daysInMonth: " + daysInMonth);
		
		int daysInYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("daysInYear: " + daysInYear);
		
		// + 5. Kiểm tra năm hiện tại có phải năm nhuận không
		GregorianCalendar gc = new GregorianCalendar();
		boolean isLeapYear = gc.isLeapYear(year);
		System.out.println("isLeapYear: " + isLeapYear);
		
		// + 6. Ngày đầu tiên trong tuần là ngày thứ mấy
		String fdow = dayOfWeeks[c.getFirstDayOfWeek() - 1];
		System.out.println("fdow: " + fdow); // Thứ Hai
	    
		// + 7. Ngày đầu tiên trong tuần hiện tại là ngày mấy
		Calendar cloned = Calendar.getInstance(new Locale("vi", "VN"));
		cloned.setTimeInMillis(c.getTimeInMillis());
		
		int duration =  cloned.getFirstDayOfWeek() - dow;
		cloned.add(Calendar.DAY_OF_MONTH, 
				dow == Calendar.SUNDAY ? duration - 7 : duration);
		
		int fdowAsNumber = cloned.get(Calendar.DAY_OF_MONTH);
		int fmonth = cloned.get(Calendar.MONTH) + 1;
		
		System.out.println("fdowAsNumber: " + fdowAsNumber + "/" + fmonth);
		
		// =>>> Epoch time
	}
}
