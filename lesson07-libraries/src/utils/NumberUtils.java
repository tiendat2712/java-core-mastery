package utils;

import java.math.BigDecimal;

public class NumberUtils {
	
	private NumberUtils() {
	}
	
	public static BigDecimal bd(double value) {
		// C1 --> new BigDecimal(String)
		// C2 --> BigDecimal.valueOf(double)
		return new BigDecimal(String.valueOf(value));
	}
	
	public void test(int a) {
		
	}
	
}
