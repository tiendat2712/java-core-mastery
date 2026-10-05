package common;

import datastructure.object.custom.Item;

import javax.swing.*;

public class Ex01FinalDef {

    public static void main(String[] args) {

        // final --> final ở STACK --> không thể thay đổi giá trị cho biến ở STACK != ||||| immutable --> immutable ở HEAP
        // --> không thể dùng toán tử = (reassign) cho biến

        // Primitive type
        // giá trị lưu trữ ở STACK
        // biến lưu trữ ở STACK chứa thông tin giá trị
        final int a = 5;
        int b = 7;
        int c = 10;

        // a = b;  ---> lỗi, a là hằng số
        // a = 10;
        b = c;


        // Object type
        // giá trị lưu trữ ở HEAP
        // biến lưu trữ ở STACK chưa thông tin địa chỉ ô nhớ ở HEAP
        Item itA = new Item(1, "A", 22d);
        final Item itB = new Item(2, "B", 33d);
        Item itC = new Item(3, "C", 44d);

        itA = itB;

        // itB = itC; --> compile error --> 1 object type variable
        // nhưng có thể thay đổi giá trị ở HEAP của biến final
        itB.setId(2);
        itB.setName("Updated name");
        itB.setPrice(100d);

        itC = itA;

        System.out.println("itA = " + itA);
        System.out.println("itB = " + itB);
        System.out.println("itC = " + itC);

    }

}
