package view;

import bean.Tuple;

public class Ex03MethodStaticDemo {

    /**
     [static]

     Đặt ở đâu:
     + attribute:
        --> khi thuộc tính mang giá trị dùng chung cho tất cả các object của class ==> dùng static
            * không phụ thuộc vào đối tượng đang gọi nó

        --> thuộc tính mang giá trị riêng cho từng object ==> dùng non-static

     + method:
        --> không phụ thuộc vào đối tượng đang gọi ==> dùng static
        --> phụ thuộc vào đối tượng đang gọi ==> non-static

     + class:

     non-static: thuộc phạm vi của đối tượng, phải có đối tượng mới gọi được
     static    : thuộc phạm vi của lớp(class) --> nên gọi từ class (Class.staticAtrr)


     */

    public static void main(String[] args) {

        int result = sum(2,5);
        System.out.println("sum --> "+ result);

        Tuple t1 = new Tuple(2,5);
        System.out.println("Tuple sum 1 --> "+ t1.sum());

        Tuple t2 = new Tuple(21,5);
        System.out.println("Tuple sum 2 --> "+ t2.sum());

    }

    // thuộc về object ==> tạo 10 đối tượng thì KQ ko thay đổi, phụ thuộc vào a,b truyền vào
//    private int sum(int a, int b) {
//        return a + b;
//    }

    // chỉ phụ thuộc vào tham số truyền vào, ko phụ thuộc vào đối tượng gọi nó (dùng đối tượng nào gọi cũng như nhau)
    // ==> dùng static method
    private static int sum(int a, int b) {
        return a + b;
    }

}
