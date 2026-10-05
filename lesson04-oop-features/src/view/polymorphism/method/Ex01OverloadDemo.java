package view.polymorphism.method;

public class Ex01OverloadDemo {

    public static void main(String[] args) {

        System.out.println("sum --> "+ sum(2.3d, 4));
        System.out.println("sum --> "+ sum(2,6,9));
        System.out.println("sum --> "+ sum(12,8));

    }

    private static double sum(double a, int b) {
        return a + b;
    }

    private static int sum(int a, int b){
        return a + b;
    }

    private static int sum(int a, int b, int c){
        return a + b + c;
    }

    /*
       . overloading
        --> 2 hay nhiều phương thức được gọi là overload nếu
        + Cùng 1 type(class), tên hàm
        + Khác:
          KDL truyền vào của tham số
          Số lượng tham số truyền vào
     */


}
