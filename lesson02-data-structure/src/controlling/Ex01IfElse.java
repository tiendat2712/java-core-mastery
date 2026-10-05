package controlling;

import org.w3c.dom.ls.LSOutput;

public class Ex01IfElse {

    public static void main(String[] args) {

        // Demo bài toán 1
        double avgScore = 7.8;
        classifyStudent(avgScore);

        // Demo bài toán 2
        int age = 17;
        checkDrivingAge(age);

        System.out.println();

        // Toán tử 3 ngôi
        // (exp1) ? result1 : result2; --> (****)

    /*       (****)
       if(exp1) {
            return result1;
       } else {
            return result2;
       }
     */

        // Tìm max của 2 số nguyên a và b
        int a = 10;
        int b = 12;
        int max = (a > b) ? a : b;
        int min = (a < b) ? a : b;
        System.out.println("max in (a, b) = " + max);
        System.out.println("min in (a, b) = " + min);
    }

    // ==============================
    // Bài toán 1: Xếp loại học lực
    // ==============================
    public static void classifyStudent(double averageScore) {

        System.out.println("Điểm trung bình: " + averageScore);

        if (averageScore >= 8.5) {
            System.out.println("Xếp loại: Giỏi");
        } else if (averageScore >= 7.0) {
            System.out.println("Xếp loại: Khá");
        } else if (averageScore >= 5.0) {
            System.out.println("Xếp loại: Trung bình");
        } else {
            System.out.println("Xếp loại: Yếu");
        }
    }

    // ==============================
    // Bài toán 2: Kiểm tra độ tuổi lái xe
    // ==============================
    public static void checkDrivingAge(int age) {

        System.out.println("\nTuổi: " + age);

        if (age >= 18) {
            System.out.println("Đủ tuổi để lái xe");
        } else {
            System.out.println("Chưa đủ tuổi để lái xe");
        }
    }

}
