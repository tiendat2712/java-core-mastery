package view.funtional_interface;

public class TestFunctionalInterface {

    public static void main(String[] args) {

        // Tạo 1 đối tượng(thể hiện - instance) cho interface IntComparator

        // --> Sử dụng external class, anonymous class để tạo đối tượng cho 1 interface bất kỳ

        // Cách 1: External class


        // Cách 2: Anonymous class -> code dài chỗ tạo đối tượng => class ẩn danh
        IntComparator ic1 = new IntComparator() {
            @Override
            public int compare(int a, int b) {
                return a - b;
            }
        };
        int result = ic1.compare(5, 7);
        System.out.println(result);


        // --> Sử dụng external class, anonymous class, anonymous function (lambda expression)
        //          để tạo đối tượng cho 1 'functional interface'
        // --> 'functional interface' là interface có duy nhất 1 hàm trừu tượng

        // Cách 3: Anonymous function (Từ java 8 trở đi) => hàm ẩn danh
        // -> Là đoạn code để override hàm trừu tượng (abstract method) từ interface
        IntComparator ic2 = (int a, int b) -> {
            return a - b;
        };
        int result1 = ic2.compare(3, 19);
        System.out.println(result1);

        // - Không bắt buộc khai báo KDL cho các tham số
        // - Nếu chỉ có 1 tham số -> có thể bỏ luôn ()
        // - Nếu body chỉ có 1 dòng -> có thể xóa luôn phần {}
        //                        -> body return void : code như bình thường
        //                        -> body return !void: xóa luôn return
        //
        IntComparator ic3 = (a, b) -> a - b;
        int result2 = ic3.compare(3, 19);
        System.out.println(result2);

        /**
           ?? lambda, anonymous function là cái gì ? khi nào sử dụng ?
           --> Trả lời:
               -> là cách viết ngắn gọn để tạo 1 đối tượng cho 1 functional interface

           ??: dùng lambda để tạo đối tượng cho 1 interface được không ?
           --> Trả lời:
               ->  chỉ dùng được cho functional interface, ko dùng được cho interface có nhiều hàm trừu tượng
               -> vì khi các hàm trừu tượng có chung danh sách tham số thì lambda không biết override cho hàm nào cả

         */

        // STRATEGY PATTERN
        // --> Viết ra 1 hàm truyền vào strategy<công thức chung> là 1 hàm biết được số lượng tham số và KDL trả về
        // --> khi nào ai gọi hàm này thì sẽ truyền nội dung của strategy vào

    }
}
