package view.localdatetime;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ex04TimeZoneDemo {
	
	public static void main(String[] args) {
		
		// TimeZone = ZoneId
		// GTM+7, UTC+7
		// ICT, HST, Europe/Berlin
		
		ZoneId zoneId = ZoneId.of("Europe/Berlin");
		
		LocalDateTime ldatetime = LocalDateTime.now(zoneId);
		
		System.out.println("ldatetime: " + ldatetime);
		
		// Lưu trữ --> LocalDate, LocalTime, LocalDatetime: JAVA08
		
		// Xử lý --> dùng các hàm của JAVA08
		
		//       --> khi nào trong JAVA08 ko xử lý được
		//       --> chuyển đổi sang Calendar, Date để dùng hàm xử lý trong JAVA07
	}
	
}
