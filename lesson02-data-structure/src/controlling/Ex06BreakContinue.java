package controlling;

public class Ex06BreakContinue {

    public static void main(String[] args) {

        /*
         =====================================================
         CONTINUE
         =====================================================
         - Chỉ dùng trong vòng lặp (for, while, do-while)
         - Kết thúc sớm lần lặp hiện tại
         - Nhảy sang lần lặp tiếp theo
         */

        System.out.println("=== DEMO CONTINUE ===");

        for (int i = 0; i < 10; i++) {

            // Nếu i == 2 thì bỏ qua lần lặp này
            if (i == 2) {
                continue;
            }

            System.out.println("continue -> i = " + i);
        }

        System.out.println();


        /*
         =====================================================
         BREAK (TRONG VÒNG LẶP)
         =====================================================
         - Thoát hoàn toàn khỏi vòng lặp hiện tại
         */

        System.out.println("=== DEMO BREAK TRONG VÒNG LẶP ===");

        for (int i = 0; i < 10; i++) {

            // Nếu i == 5 thì thoát khỏi vòng lặp
            if (i == 5) {
                break;
            }

            System.out.println("break(loop) -> i = " + i);
        }

        System.out.println();


        /*
         =====================================================
         KẾT HỢP CONTINUE + BREAK
         =====================================================
         */

        System.out.println("=== DEMO CONTINUE + BREAK ===");

        for (int i = 0; i < 10; i++) {

            if (i == 2) continue; // bỏ qua i = 2
            if (i == 7) break;    // dừng hẳn khi i = 7

            System.out.println("mix -> i = " + i);
        }

        System.out.println();


        /*
         =====================================================
         BREAK (TRONG SWITCH CASE)
         =====================================================
         - Thoát khỏi switch case
         - Nếu không có break → sẽ chạy xuyên case (fall-through)
         */

        System.out.println("=== DEMO BREAK TRONG SWITCH CASE ===");

        int option = 2;

        switch (option) {
            case 1:
                System.out.println("Bạn chọn 1");
                break;

            case 2:
                System.out.println("Bạn chọn 2");
                break;

            case 3:
                System.out.println("Bạn chọn 3");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ");
        }

        System.out.println();


        /*
         =====================================================
         LƯU Ý QUAN TRỌNG
         =====================================================
         - continue: chỉ bỏ qua 1 lần lặp
         - break   : thoát hoàn toàn vòng lặp / switch
         - break KHÔNG thoát khỏi if
         */

        System.out.println("=== END DEMO ===");
    }
}
