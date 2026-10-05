package a.validation_try_catch_throw_throws;

import java.time.Year;
import java.util.Scanner;

public class Ex01Exception_Validation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String yobAsText = "";
        do {
            System.out.println("Enter year of birth: ");
            yobAsText = sc.nextLine();

            if(yobAsText.matches("\\d+")) {
                break;
            }
        } while (true);

        int yob = Integer.parseInt(yobAsText); // --> NumberFormatException

        int cyear = Year.now().getValue();
        int age = cyear - yob + 1;

        System.out.println("Your age: "+ age);

        sc.close();

    }

}
