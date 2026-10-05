package a.validation_try_catch_throw_throws;

public class Ex03Exception_Throw {

    // validation: validate trước đoạn code có khả năng bị exception
    // try...catch: đưa đoạn code có khả năng bị exception vào khối try

    // throw_throws:
    // throw: ném exception trước khi đoạn code có khả năng bị exception xảy ra
    //      : ném khi mà exception xảy ra hay ko phụ thuộc vào param truyền vào lúc gọi hàm

    public static void main(String[] args) {

        // Vị trí A: gọi hàm divide
        //         : validate a, b nhập vào phải là số nguyên
        //         :             b phải khác 0
        System.out.println("Vị trí A: "+ devide(4,2));

        // Vị trí B: gọi hàm divide
        //         : cho a,b tùy ý chưa có validation
        try {
            System.out.println("Vị trí B: "+ devide(4,0));
        } catch (RuntimeException e) { // thay vì catch ArithmeticException thì có thể dùng thằng cha là RuntimeException
            // ---> Một exception CHA có thể bắt lỗi cho các exception CON
            System.out.println("message -> " + e.getMessage());
        }
    }

    private static int devide(int a, int b) {
        if(b == 0) {
            // fail first --> save time
            // custom exception, message
            throw new ArithmeticException("b must not be 0");
        }

        // a = query(); -> 30s

        return a / b;
    }
}
