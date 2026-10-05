package common;

import datastructure.object.custom.Item;

// Java --> block scope

// Java --> class
// + KDL đối tượng --> attributes, constructors, getters, setters
// code demo --> main, != methods

public class Ex04VariableScope {

    // cú pháp khai báo biến
    // attribute: [access modifier] [static] [final] return_type var_name [=value];
    // local variable:                       [final] return_type var_name [=value];

    // phạm vi trong class
    // được dùng trong bất kỳ hàm nào của class Ex04VariableScope

    // biến toàn cục (global variable)
    private static int a = 9999;
    public static String b = "Hello Friends";
    private static double c = 99.5;

    public static void main(String[] args) {
        // phạm vi trong hàm main
        // biến cục bộ (local variable)
        int a = 11;
        String b = "Welcome";
        Item i1 = new Item(1, "Abc", 33d);
        System.out.println("a local variable --> "+ a ); // --> nếu cùng tên thì ưu tiên local variable hơn
        System.out.println("a global variable --> "+ Ex04VariableScope.a );

        // priority: local > global
    }

    public static void testScope() {
        // phạm vi trong method testScope
        // biến cục bộ (local variable)
        int a = 10;
        String b = "hello";
    }
}
