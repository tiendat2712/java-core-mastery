package a.validation_try_catch_throw_throws;

import java.time.Year;
import java.util.Scanner;

public class Ex01Exception_Validation {

	// Enter year of birth --> calculate age of candidate

	public static void main(String[] args) {

		Scanner ip = new Scanner(System.in);

		// validation
		String yobAsText = "";
		do {
			System.out.print("Enter year of birth: ");
			yobAsText = ip.nextLine();
			if (yobAsText.matches("\\d+")) { // regex pattern, regular expression
				break;
			}
		} while (true);

		int yob = Integer.parseInt(yobAsText);

		int cyear = Year.now().getValue();
		int age = cyear - yob + 1;
		System.out.println("Your age: " + age);

		ip.close();
	}
	/*
	 * Exception in thread "main" java.lang.NumberFormatException: For input string:
	 * "abc" at java.base/java.lang.NumberFormatException.forInputString(
	 * NumberFormatException.java:67) at
	 * java.base/java.lang.Integer.parseInt(Integer.java:668) at
	 * java.base/java.lang.Integer.parseInt(Integer.java:786) at
	 * a.validation_try_catch_throw_throws.Ex01Exception_Validation.main(
	 * Ex01Exception_Validation.java:15)
	 */
}
