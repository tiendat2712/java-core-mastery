package view.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Ex02Format {
	
	public static void main(String[] args) {
		// hàm bị gạch ngang --> deprecated method
		
		 // singleton pattern
		 // pattern cho việc khởi tạo đối tượng
		 // class áp dụng singleton, chỉ cho phép tạo ra duy nhất 1 đối tượng cho class đó
		
		double value = 729292010220211.762d; // 7.29292010220211E14
		
		System.out.println("double value --> " + value);
		
		// locale(language, country): vị trí, định ví của mỗi quốc gia, khu vực
		// default setting của Java: en_US
		
		System.out.println("default locale: " + Locale.getDefault());
		
		// NumberFormat: Sử dụng format có sẵn trong class --> ko thể biến đổi
		// NumberFormat nf = NumberFormat.getInstance(new Locale("vn", "VN")); // format ra số
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); // format ra tiền tệ
		String fmtValue = nf.format(value);
		
		System.out.println("fmtValue --> " + fmtValue);
		
		// Demimal Format --> format với định dang, pattern truyền vào
		
		value = 726.2827d;
		DecimalFormat df = new DecimalFormat("#,###.##");
		String dffmValue = df.format(value);
		
		System.out.println("dffmValue --> " + dffmValue);
		
		// ---> Công thức, tính toán, làm tròn --> BigDecimal
		//                                     --> setScale(scale, roundingMode)
	}
	
}
