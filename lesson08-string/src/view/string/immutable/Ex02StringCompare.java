package view.string.immutable;

public class Ex02StringCompare {
	
	public static void main(String[] args) {
		
		// So sánh lớn, bé --> compareTo, vì String implements Comparable<?>
		
		String s1 = "hello"; // H1
		String s2 = "z"; // H2
		String s3 = "hello"; // H1
		String s4 = new String("hello"); // H3
		
		System.out.println("s1 compareTo s2 --> " + s1.compareTo(s2));
		
		// So sánh bằng --> equals, từ class Object
		
		// Object#equals: so sánh == --> so sánh địa chỉ(stack)
		// String#equals: so sánh giá trị của String ở heap
		
		Ex02StringCompare o1 = new Ex02StringCompare();
		Ex02StringCompare o2 = new Ex02StringCompare();
		
		System.out.println("\no1 equals o2 --> " + o1.equals(o2));
		
		System.out.println("\ns1 equals s3 --> " + s1.equals(s3)); // true
		
		System.out.println("\ns1 equals s4 --> " + s1.equals(s4)); // true
		
	}
	
}
