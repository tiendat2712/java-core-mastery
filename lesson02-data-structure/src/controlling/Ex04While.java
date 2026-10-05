package controlling;

public class Ex04While {

    public static void main(String[] args) {
//        demoBasicWhile();
//        demoSumWhile();
//        demoBreakContinueWhile();

        checkNumber();
    }

    /**
     * Demo 1: while cơ bản
     */
    public static void demoBasicWhile() {
        int i = 0;

        while (i < 5) {
            System.out.println("demoBasicWhile - i = " + i);
            i++;
        }

        System.out.println("--------------------");
    }

    /**
     * Demo 2: while + biến tích lũy (tính tổng)
     * Tính tổng các số từ 1 đến 10
     */
    public static void demoSumWhile() {
        int i = 1;      // biến điều khiển
        int sum = 0;    // biến tích lũy

        /*
         * B1: kiểm tra i <= 10
         * B2: nếu true -> cộng i vào sum
         * B3: tăng i
         * Lặp lại đến khi điều kiện false
         */
        while (i <= 10) {
            sum += i;
            i++;
        }

        System.out.println("Tổng từ 1 đến 10 = " + sum);
        System.out.println("--------------------");
    }

    /**
     * Demo 3: while + break + continue
     */
    public static void demoBreakContinueWhile() {
        int i = 0;

        while (i < 10) {
            i++;

            // Bỏ qua số chẵn
            if (i % 2 == 0) {
                continue; // quay lại kiểm tra điều kiện while
            }

            // Dừng vòng lặp khi gặp số 7
            if (i == 7) {
                break; // thoát khỏi vòng lặp
            }

            System.out.println("Số lẻ: " + i);
        }

        System.out.println("Kết thúc demo break & continue");
    }

    // in ra các số nguyên lẻ, không âm nhỏ hơn 20
    public static void checkNumber() {
        int i = 0;
        int n = 20;
        while (i < n) {
            if (i % 2 != 0) {
                System.out.println("i --> "+ i);
            }
            i++;
        }
    }
}
