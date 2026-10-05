package datastructure.object.available;

import datastructure.object.custom.Item;

public class Ex01BasicDemo {

    public static void main(String[] args) {

        // primitive type
        int a = 5;

        // object type: custom
        Item i = new Item();
        Item i1 = new Item(2, "D", 22d);

        // object type
        Integer o1 = null;
//        Integer o2 = new Integer(8);
        Integer o2 = Integer.valueOf(11);
        System.out.println(o1);
        System.out.println(o2);

        Integer o3 = 77;
        Integer o4 = 88;

        // Để khởi tạo giá trị cho KDL đối tượng
        // Hầu hết sử dụng từ khóa 'new' --> dùng cho KDL đối tượng có sẵn của Java or Custom

        // Đặc biệt: với những KDL có SẴN của Java như (Integer, Float, Double, Long,...)
        //           có thể khởi tạo giá trị không cần dùng từ khóa 'new'




    }
}
