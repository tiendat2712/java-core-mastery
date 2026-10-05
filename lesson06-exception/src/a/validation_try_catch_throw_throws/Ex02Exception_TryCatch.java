package a.validation_try_catch_throw_throws;

import java.time.Year;
import java.util.Scanner;

public class Ex02Exception_TryCatch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //validation
        System.out.println("Enter your year of birth: ");

        int yob = 0;
        try {
            yob = Integer.parseInt(sc.nextLine());

            int cyear = Year.now().getValue();
            int age = cyear - yob + 1;
            System.out.println("Your age: "+ age);
        } catch (NumberFormatException e) { // nếu bắt lỗi ở đây ko đúng thì sẽ ko chạy khối catch --> chương trình bị dừng
//            e.printStackTrace(); // default trace error from JAVA
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}
