package datastructure.object.available;

public class Ex02DiffInitialValue {

    public static void main(String[] args) {

        // immutable (bất biến): không thể thay đổi trạng thái (giá trị các field);
        //                       mọi thay đổi sẽ tạo ra object mới trên heap

        // mutable   (khả biến): có thể thay đổi trạng thái (giá trị các field)
        //                       trên cùng object trong heap


        System.out.println("\n ------- ---------- --------- Integer Demo --------- --------- ---------");
        // Integer demo
        // Khởi tạo với từ khóa new --> giá trị sẽ lưu trữ ở vùng nhớ heap
        // --> Luôn tạo ra ô nhớ mới khi khời tạo giá trị
        Integer io1 = new Integer(24);
        Integer io2 = new Integer(36);
        Integer io3 = new Integer(24);
        Integer io4 = new Integer(18);


        System.out.println("io1(" + io1 + ") --> address(" + System.identityHashCode(io1) + ")");
        System.out.println("io2(" + io2 + ") --> address(" + System.identityHashCode(io2) + ")");
        System.out.println("io3(" + io3 + ") --> address(" + System.identityHashCode(io3) + ")");
        System.out.println("io4(" + io4 + ") --> address(" + System.identityHashCode(io4) + ")");

        System.out.println("\n=================================================\n");

        // Không dùng từ khoá new --> giá trị sẽ lưu trữ ở vùng nhớ 'heap/constant pool'
        // Nếu constant pool đã tồn tại giá trị của biến mới được khởi tạo thì gán luôn giá trị cho biến chứ ko cần tạo ô nhớ mới
        Integer i5 = 17; // --> kiểm tra constant pool
        Integer i6 = 28;
        Integer i7 = 11;
        Integer i8 = 17;
        i6 = 17; // (**) Toán tử = 100% hoạt động ở STACK

        System.out.println("i5(" + i5 + ") --> address(" + System.identityHashCode(i5) + ")");
        System.out.println("i6(" + i6 + ") --> address(" + System.identityHashCode(i6) + ")");
        System.out.println("i7(" + i7 + ") --> address(" + System.identityHashCode(i7) + ")");
        System.out.println("i8(" + i8 + ") --> address(" + System.identityHashCode(i8) + ")");


        System.out.println("\n ------- ---------- --------- String Demo --------- --------- ---------");
        // String demo
        String so1 = new String("a");
        String so2 = new String("a");
        String so3 = new String("c");
        String so4 = new String("a");

        System.out.println("so1(" + so1 + ") --> address(" + System.identityHashCode(so1) + ")");
        System.out.println("so2(" + so2 + ") --> address(" + System.identityHashCode(so2) + ")");
        System.out.println("so3(" + so3 + ") --> address(" + System.identityHashCode(so3) + ")");
        System.out.println("so4(" + so4 + ") --> address(" + System.identityHashCode(so4) + ")");
        System.out.println("\n=================================================\n");

        String s1 = "a";
        String s2 = "a";
        String s3 = "a";
        String s4 = "b";
        s3 = "lalalalalaa";

        System.out.println("s1(" + s1 + ") --> address(" + System.identityHashCode(s1) + ")");
        System.out.println("s2(" + s2 + ") --> address(" + System.identityHashCode(s2) + ")");
        System.out.println("s3(" + s3 + ") --> address(" + System.identityHashCode(s3) + ")");
        System.out.println("s4(" + s4 + ") --> address(" + System.identityHashCode(s4) + ")");

    }
}
