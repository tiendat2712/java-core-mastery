package controlling;

public class Ex03For {

    public static void main(String[] args) {

        demoForBasic();
        demoForArrayIndex();
        demoForEach();
        demoForBreakContinue();
    }

    // ==============================
    // 1. for cơ bản – lặp theo số lần
    // ==============================
    public static void demoForBasic() {
        System.out.println("=== demoForBasic ===");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }

    // =========================================
    // 2. for index – duyệt mảng theo chỉ số
    // =========================================
    public static void demoForArrayIndex() {
        System.out.println("\n=== demoForArrayIndex ===");

        int[] numbers = {10, 20, 30, 40};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " = " + numbers[i]);
        }
    }

    // =========================================
    // 3. for-each – duyệt mảng theo giá trị
    // =========================================
    public static void demoForEach() {
        System.out.println("\n=== demoForEach ===");

        int[] numbers = {10, 20, 30, 40};

        for (int value : numbers) {
            System.out.println("Value = " + value);
        }
    }

    // =========================================
    // 4. for + break / continue
    // =========================================
    public static void demoForBreakContinue() {
        System.out.println("\n=== demoForBreakContinue ===");

        for (int i = 1; i <= 10; i++) {

            if (i == 3) {
                continue; // bỏ qua i = 3
            }

            if (i == 7) {
                break; // dừng vòng lặp tại i = 7
            }

            System.out.println("i = " + i);
        }
    }
}
