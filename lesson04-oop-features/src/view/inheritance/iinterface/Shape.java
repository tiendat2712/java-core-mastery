package view.inheritance.iinterface;

import java.rmi.Remote;

public interface Shape extends JsBehavior {

        /*
           - Trước JAVA08 (JDK 1.8) ==> Interface trước JAVA8 và sau JAVA8 khác nhau như thế nào ??
             Hàm trong interface chỉ được phép là hàm trừu tượng (abstract method)
             . Hàm trừu tượng: là hàm chỉ có phần khai báo, không có phần thực thi
         */

    // Vì sao hàm, thuộc tính trong interface không có access modifier ?
    // mặc định trong interface:
    //                    hàm --> public abstract
    //                    thuộc tính --> public static final và bắt buộc phải khởi tạo giá trị

    // Thông thường --> chỉ dùng interface để chứa các hàm trừu tượng

    int s = 6;

    void paint();

    void calS();

          /*
            - JAVA8 --> default, static method
            - JAVA9 --> private method ==> để hỗ trợ code reuse
          */

    // 'default' --> ko phải access modifier, mà nó là từ khóa giúp method trong interface có body
    default void coding() {
        isOdd();
        System.out.println("I am coding");;
    }

    default void testing() {
        isOdd();
        System.out.println("I am testing");
    }

    private boolean isOdd() {
        return true;
    }

    /*
       Static method trong interface dùng để:
       - Gắn logic liên quan trực tiếp tới abstraction (Shape)
       - Là helper / factory / rule checker cho Shape
       - KHÔNG liên quan tới object cụ thể
     */
    // ===== STATIC METHODS =====

    // 1. Utility gắn với abstraction Shape
    static boolean isValidArea(double area) {
        return area > 0;
    }

    // 2. Helper method liên quan Shape
    static void printInfo(Shape shape) {
        System.out.println("Printing shape info...");
        shape.paint();
        shape.calS();
    }

    // 3. Factory method (RẤT QUAN TRỌNG)
    static Shape rectangle(double width, double height) {
        return new Shape() {
            @Override
            public void paint() {
                System.out.println("Paint rectangle");
            }

            @Override
            public void calS() {
                double area = width * height;
                System.out.println("Area = " + area);
            }

            @Override
            public void onload() {
                System.out.println("onload");
            }
        };
    }

}
