package a.validation_try_catch_throw_throws;

public class Ex03Exception_Throw {
	
	// validation: validation trước đoạn code có khả năng bị exception
	// try catch: đưa đoạn code có khả năng bị exception vào khối try
	
	// throw_throws
	// throw: ném exception trước khi đoạn code có khả năng bị exception xảy ra
	//      : ném khi mà exception xảy ra hay ko phụ thuộc vào param truyền vào
	//        lúc gọi hàm
	
	public static void main(String[] args) {
		// Vị trí A: gọi hàm divide
		//         : validate a, b nhập vào phải là số nguyên
		//         :             b phải khác 0
		System.out.println("Vị trí A: " + divide(4, 2));
		
		System.out.println("\n=================\n");
		
		// Vị trí B: gọi hàm divide
		//         : cho a, b tùy ý - chưa có validation
		try {
			System.out.println("Vị trí B: " + divide(4, 0));
		} catch (RuntimeException e) {
			System.out.println("ef -> " + e.getMessage());
		}
		
		// ko bắt buộc phải xử lý(try_catch/throws đi chỗ khác)
		divide(5, 7);
	}
	
	private static int divide(int a, int b) /*throws ArithmeticException*/ {
		if (b == 0) {
			// fail first --> save time
			// custom exception, message
			throw new ArithmeticException("e -> / by zero");
		}
		// a = query(); 20s
		return a / b;
	}
	
	/*
	 Exception in thread "main" java.lang.ArithmeticException: / by zero
		at a.validation_try_catch_throw_throws.Ex03Exception_Throw.divide(Ex03Exception_Throw.java:28)
		at a.validation_try_catch_throw_throws.Ex03Exception_Throw.main(Ex03Exception_Throw.java:23)
	 */
}
