package view.inheritance.iinterface;

public class InheritanceInterfaceDemo {

    public static void main(String[] args) {

//        Shape sh1 = new Shape(); --> Anonymous inner type --> compile error
//                                 --> bắt buộc phải override lại các method trong interface Shape

        // anonymous inner type
        // anonymous class
        Shape sh1 = new Shape() {
            @Override
            public void paint() {
                System.out.println("Circle --> Paint...");
            }

            @Override
            public void calS() {
                System.out.println("Circle --> CalS ....");
            }

            @Override
            public void onload() {
                System.out.println("Shape <parent> --> Onload ....");
            }
        };

        sh1.paint();
        sh1.calS();
        sh1.onload();
        sh1.coding();

        System.out.println("\n============================\n");

        // External class
        Shape sh2 = new Circle();
        sh2.paint();
        sh2.calS();
        sh2.onload();
        sh2.coding();
        sh2.testing();

        // Anonymous function

        /*
           ====>
           Để tạo 1 đối tượng cho biến KDL interface:
           Dùng - external class
                - anonymous class
                  ==> có thể có 1 hoặc nhiều hàm trừu tượng
                - anonymous function
                  ==> có duy nhất 1 hàm trừu tượng
         */

    }
}
