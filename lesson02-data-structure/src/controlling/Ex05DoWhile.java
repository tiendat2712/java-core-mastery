package controlling;

public class Ex05DoWhile {

    public static void main(String[] args) {

        demoBasicDoWhile();
        demoSumDoWhile();
        demoMenuDoWhile();
    }

    /**
     * ======================================
     * Demo 1: do-while cơ bản
     * ======================================
     * B1: Thực hiện statement
     * B2: Kiểm tra expression
     * - true  -> quay lại B1
     * - false -> thoát vòng lặp
     */
    public static void demoBasicDoWhile() {

        int i = 0; // Exp01

        do {
            // statement
            System.out.println("demoBasicDoWhile - i = " + i);
            i++; // Exp03
        } while (i < 5); // Exp02

        System.out.println("--------------------");
    }

    /**
     * ======================================
     * Demo 2: do-while + biến tích lũy
     * Tính tổng các số từ 1 đến 10
     * ======================================
     */
    public static void demoSumDoWhile() {

        int i = 1;
        int sum = 0;

        /*
         * Lưu ý:
         * - Dù điều kiện sai ngay từ đầu
         * - statement vẫn được chạy ít nhất 1 lần
         */
        do {
            sum += i;
            i++;
        } while (i <= 10);

        System.out.println("Tổng từ 1 đến 10 = " + sum);
        System.out.println("--------------------");
    }

    /**
     * ======================================
     * Demo 3: do-while thực tế (menu giả lập)
     * ======================================
     * Rất hay dùng trong:
     * - Menu chương trình
     * - Lựa chọn
     * - 1 -> Chức năng A
     * - 2 -> Chức năng B
     * - 3 -> Chức năng B
     * - 0 -> Thoát chương trình
     */
    public static void demoMenuDoWhile() {

        int choice = 0;

        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xóa");
            System.out.println("0. Thoát");
            System.out.println("==================");

        } while (choice != 0 && choice < 3);

        System.out.println("Thoát chương trình");
    }

}
