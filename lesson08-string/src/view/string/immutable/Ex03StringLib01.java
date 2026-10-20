package view.string.immutable;

public class Ex03StringLib01 {
	
	public static void main(String[] args) {
		
		String s = "   welcome   to    class   ";
		
		// Tính chiều dài của chuỗi s --> length
		 
		// Nối chuỗi s1 vào chuỗi s --> +, concat
		
		// Lấy một ký tự tại vị trí index(3) trong chuỗi s
		char letter = s.charAt(3);
		
		// Duyệt từng kí tự trong chuỗi
		for(int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + " ");
		}
		
		System.out.println("\n\n");
		
		// Duyệt từng từ trong chuỗi, các từ cách nhau bởi space
		
		System.out.println("s hash --> " + System.identityHashCode(s));
		
		// Thủ công
		s = s.strip().replaceAll("\\s+", " ");
		
		System.out.println("s hash --> " + System.identityHashCode(s));
		
		System.out.println("s replaced --> |||" + s + "|||");
		String word = "";
		for(int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (tmp == ' ') {
				System.out.println("word: " + word);
				word = "";
			} else {
				word = word + tmp;
				if (i == s.length() - 1) {
					System.out.println("word: " + word);
				}
			}
		}
		
		System.out.println("\n========\n");
		
		s = "welcome   to x x x x x our     class";
		String regex = "\\s+";
		// Dùng hàm có sẵn --> split
		String[] tokens = s.strip().split(regex);
		for (String token: tokens) {
			System.out.println("tk --> |" + token + "|");
		}
		
		// Tìm vị trí – chỉ số xuất hiện đầu tiên, cuối cùng của kí tự  'c' trong chuỗi s
		// --> bắt đầu : 3
		// --> kết thúc: 22
		System.out.println("Vị trí bắt đầu của 'c' --> " + s.indexOf("c"));
		System.out.println("Vị trí kết thúc của 'c' --> " + s.lastIndexOf("c"));
	}
	
}
