package common;

public class Ex03Jdl1_5Boxing {

    public static void main(String[] args) {

        // Với những KDL có sẵn của java (primitive & object type)
        // int -> Integer: int
        // float -> Float: float
        // long -> Long: long

        int x1 = 2;
        int x2 = 8;

        Integer b1 = x1; // --> auto-boxing
        x2 = b1;         // --> auto-unboxing

        System.out.println("\n ============================== \n");
        Integer x3 = 15;
        Integer x4 = 87;

        swapInt(x1, x3);
        swapInteger(x2, x4);

        // -> int có thể nhận giá trị từ Integer --> ko cần ép kiểu
        // -> Integer có thể nhận giá trị từ int --> ko cần ép kiểu

        // từ jdk ver 1.0 đến 1.4 chưa xuất hiện khái niệm auto-boxing, auto-unboxing

        // từ jdk ver 1.5 --> xuất hiện khái niệm auto-boxing, auto-unboxing

        // auto-boxing --> Java sẽ tự động convert kiểu nguyên thủy sang kiểu đối tượng tương ứng (chỉ những KDL có sẵn của Java)
        // ex: int -> Integer, long -> Long

        // auto-unboxing --> Java sẽ tự động convert kiểu đối tượng sang kiểu nguyên thủy tương ứng

        // Nhưng cẩn thận khi unboxing (từ đối tượng sang nguyên thủy)
        // Object(value, null)
        // Primitive(value)

        Integer b2; // b2(null)
        // x1 = b2; --> error (b2.intValue() --> NullPointerException)

    }

    // swap at STACK
    private static void swapInt(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    // swap at STACK
    private static void swapInteger(Integer a, Integer b){
        int temp = a;
        a = b;
        b = temp;
    }
}
