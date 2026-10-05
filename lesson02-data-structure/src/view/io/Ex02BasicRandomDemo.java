package view.io;

import java.util.Random;

public class Ex02BasicRandomDemo {

    public static void main(String[] args) {

        // ==============================
        // 1. Khởi tạo Random
        // ==============================
        Random rd = new Random(); // seed ngẫu nhiên theo thời gian hệ thống

        // ==============================
        // 2. Random số nguyên (int)
        // ==============================
        System.out.println("=== Random int ===");
        System.out.println("nextInt(): " + rd.nextInt()); // int bất kỳ

        System.out.println("nextInt(10): " + rd.nextInt(10)); // 0 -> 9

        // Random trong khoảng [min, max]
        int min = 5;
        int max = 15;
        int randomInRange = rd.nextInt(max - min + 1) + min;
        System.out.println("Random [5,15]: " + randomInRange);

        // ==============================
        // 3. Random số thực
        // ==============================
        System.out.println("\n=== Random double / float ===");
        System.out.println("nextDouble(): " + rd.nextDouble()); // [0.0, 1.0)
        System.out.println("nextFloat(): " + rd.nextFloat());   // [0.0, 1.0)

        // Random double trong khoảng [min, max)
        double dMin = 1.5;
        double dMax = 5.5;
        double randomDouble = dMin + rd.nextDouble() * (dMax - dMin);
        System.out.println("Random double [1.5,5.5): " + randomDouble);

        // ==============================
        // 4. Random boolean
        // ==============================
        System.out.println("\n=== Random boolean ===");
        System.out.println("nextBoolean(): " + rd.nextBoolean());

        // ==============================
        // 5. Random long
        // ==============================
        System.out.println("\n=== Random long ===");
        System.out.println("nextLong(): " + rd.nextLong());

        // ==============================
        // 6. Random với seed cố định
        // ==============================
        System.out.println("\n=== Random with seed ===");
        Random rdSeed = new Random(123);
        System.out.println(rdSeed.nextInt(100));
        System.out.println(rdSeed.nextInt(100));
        System.out.println(rdSeed.nextInt(100));

        //  Mỗi lần chạy chương trình, kết quả giống nhau
        //  Dùng cho test / debug

        // ==============================
        // 7. Random ký tự
        // ==============================
        System.out.println("\n=== Random character ===");
        char randomChar = (char) ('A' + rd.nextInt(26));
        System.out.println("Random char A-Z: " + randomChar);

        // ==============================
        // 8. Random chuỗi
        // ==============================
        System.out.println("\n=== Random String ===");
        String randomString = generateRandomString(rd, 8);
        System.out.println("Random string (8 chars): " + randomString);

        // ==============================
        // 9. Random phần tử trong mảng
        // ==============================
        System.out.println("\n=== Random array element ===");
        String[] names = {"Java", "Spring", "Docker", "Kubernetes"};
        String randomName = names[rd.nextInt(names.length)];
        System.out.println("Random name: " + randomName);
    }

    // ==============================
    // Hàm random chuỗi
    // ==============================
    private static String generateRandomString(Random rd, int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
