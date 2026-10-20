package view.string.mutable;

public class Ex01StringMutableDemo {
	
	public static void main(String[] args) {
		// 1. Phân biệt String Literal và String Object
		// 2. Phần biệt StringBuilder và StringBuffer(3...)
		// 3. Khái niệm immutable là gì, ví dụ
		// 4. Phân biệt String Immutable và Mutable
		
		// String Immutable: String
		
		// String Mutable: StringBuilder, StringBuffer
		
		StringBuilder sb1 = new StringBuilder("todo-app-2.4");
		
		sb1.append("-snapshot")
		   .append("-test");
		
		System.out.println("sb hash 01: " + System.identityHashCode(sb1));
		
		System.out.println("sb append --> " + sb1);
		
		sb1.deleteCharAt(0)
		   .setCharAt(0, 'a');
		
		System.out.println("sb hash 01: " + System.identityHashCode(sb1));
		
		System.out.println("\nsb deleted --> " + sb1);
		
		System.out.println("\nThread --> " + Thread.currentThread().getName());
		
		// Khi các đoạn code, công việc, task thực thi ko depends lẫn nhau
		
		// Load A --> 4s
		
		// Load B --> 2s
		
		// Load C --> 5s
		
		// Thread 'main'-single --> 11s
		
		// Tạo ra 3 threads --> 5s
		
		// thread pool
		
		// thread: là 1 luồng thực thì giúp thực thi 1 công việc, tác vụ nào đó
		
	}
	
}
