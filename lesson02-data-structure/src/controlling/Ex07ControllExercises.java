package controlling;

import java.util.Random;
import java.util.Scanner;

public class Ex07ControllExercises {

    public static void main(String[] args) {

        System.out.println("Nhập 3 số, tìm số lớn nhất.");
        int[] numbers = {3,5,7};
        System.out.println("Max = " + findMax(numbers));

        printTriangle(4);
        printCenteredTriangle(5);

        displayMenu();

    }

    /*
         =====================================================
         BÀI 1 – IF / ELSE (RẼ NHÁNH ĐIỀU KIỆN)
         =====================================================
         1. Nhập 3 số, tìm số lớn nhất.
         2. Nhập một số, kiểm tra số đó có chia hết cho 2 và 3 hay không.
         3. Giải phương trình bậc nhất: ax + b = 0
        */
    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static boolean divideBy2vs3(int a) {
        return ((a % 2 == 0) && (a % 3 == 0));
    }

    public static void solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            double x = -b / a;
            System.out.println("Phương trình có nghiệm duy nhất: x = " + x);
        }
    }


            /*
             =====================================================
             BÀI 2 – SWITCH CASE (NHIỀU NHÁNH CỐ ĐỊNH)
             =====================================================
             1. Tạo menu chọn phép toán (+, -, *, /) và thực hiện phép toán đó.
             2. Đổi đơn vị đo lường:
                - m ↔ cm
                - cm ↔ mm
            */
        public static int convertUnit(int a, String unit) {
            return switch (unit) {    // ** phải có return ở Switch
                case "m" -> a * 100;  // Đổi từ m sang cm
                case "cm" -> a * 10; // Đổi từ cm sang mm
                default -> a;        // Giữ nguyên nếu không khớp
            };
        }


        /*
         =====================================================
         BÀI 3 – VÒNG LẶP FOR (SỐ LẦN XÁC ĐỊNH)
         =====================================================
         1. In bảng cửu chương từ 2 đến 9.
         2. In tam giác sao (*) bằng vòng lặp for.
        */
    public static void bangcuuchuong2vs9() {
        for(int i = 2; i <= 9; i++) {
            System.out.println("");
            System.out.println("Bang cuu chuong "+ i);
            for(int j = 1; j <= 10; j++ ) {
                System.out.println(i + "*" + j + "=" + i*j);
            }
            System.out.println("------------ || ---------------- || ------------");
        }
    }

    public static void printTriangle(int n) {
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void printCenteredTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            // 1. Vòng lặp in khoảng trắng căn giữa
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // 2. Vòng lặp in dấu sao
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // 3. Xuống dòng
            System.out.println();
        }
    }


        /*
         =====================================================
         BÀI 4 – WHILE / DO-WHILE (LẶP KHÔNG XÁC ĐỊNH TRƯỚC)
         =====================================================

         1. Nhập số nguyên dương, nếu nhập sai thì yêu cầu nhập lại.

         2. Nhập các số cho đến khi tổng > 100 thì dừng.

         3. Trò chơi đoán số:
            - Máy sinh số ngẫu nhiên
            - Người dùng đoán cho đến khi đúng thì dừng

         4. Menu lặp lại cho đến khi người dùng chọn thoát.

         5. Nhập chuỗi ký tự, lặp lại cho đến khi độ dài chuỗi >= 5.
        */
    public static void inputPositiveNumber() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhập vào số nguyên dương: ");
            n = sc.nextInt();

            if (n <= 0) {
                System.out.println("⚠Nhập sai! Số phải lớn hơn 0. Vui lòng nhập lại.");
            }
        }
        while(n <= 0);

    }

    public static int inputUntilSumGreaterThan100() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(sum < 100) {
            System.out.print("Nhập số: ");
            int i = sc.nextInt();
            sum += i;
        }
        return sum;
    }

    public static void guessNumberGame() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int targetNumber = rd.nextInt(10) + 1;
        int guess = 0;
        int count = 0; // đếm số lần đoán

        System.out.println("=== CHÀO MỪNG ĐẾN VỚI TRÒ CHƠI ĐOÁN SỐ ===");
        System.out.println("Máy đã chọn một số từ 1 đến 10. Đố bạn đoán được!");

        // Vòng lặp chạy cho đến khi đoán đúng
        while (guess != targetNumber) {
            System.out.print("Nhập dự đoán của bạn: ");
            guess = sc.nextInt();
            count++;

            if (guess < targetNumber) {
                System.out.println("Số bí mật LỚN HƠN. Thử lại nhé!");
            } else if (guess > targetNumber) {
                System.out.println("Số bí mật NHỎ HƠN. Thử lại nhé!");
            } else {
                System.out.println("Chúc mừng! Bạn đã đoán đúng số " + targetNumber + " sau " + count + " lần đoán.");
            }
        }
    }

    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=================== MENU CHÍNH ===================");
            System.out.println("1. Tìm số lớn nhất trong mảng");
            System.out.println("2. Giải phương trình bậc nhất (ax + b = 0)");
            System.out.println("3. Chơi trò chơi đoán số");
            System.out.println("0. Thoát chương trình");
            System.out.println("==================================================");
            System.out.print(" Mời bạn chọn chức năng (0 - 3): ");

            choice = sc.nextInt();

            // Sử dụng switch expression / lambda syntax (Java 14+)
            switch (choice) {
                case 1 -> {
                    System.out.println("\n[Đang chạy chức năng 1...]");
                    // Gọi hàm tìm max vào đây
                }
                case 2 -> {
                    System.out.println("\n[Đang chạy chức năng 2...]");
                    // Gọi hàm giải phương trình vào đây
                }
                case 3 -> {
                    System.out.println("\n[Đang chạy chức năng 3...]");
                    // Gọi hàm đoán số vào đây
                }
                case 0 -> System.out.println("\n Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                default -> System.out.println("\n Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 3.\n");
            }

        } while (choice != 0);
    }


        /*
         =====================================================
         BÀI 5 – BREAK / CONTINUE / RETURN
         =====================================================

         1. Tìm số đầu tiên chia hết cho cả 5 và 7 trong đoạn [-1000, 1000]
            (dùng break).

         2. In các số từ 1 đến 50, bỏ qua các số chia hết cho 3
            (dùng continue).

         3. Viết hàm kiểm tra số nguyên tố,
            trả về true / false (dùng return).

         4. Tìm số chính phương đầu tiên lớn hơn n.

         5. Menu có lựa chọn thoát chương trình sớm
            (dùng break hoặc return).
        */



}
