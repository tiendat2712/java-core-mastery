package common;

import homework.CustomInteger;

public class Ex02Swap {

    public static void main(String[] args) {
        // boxing, unboxing, autoboxing

        int x1 = 2;
        int x2 = 8;
        swapInt(x1, x2);
        System.out.println("x1 --> "+ x1); // 2
        System.out.println("x2 --> "+ x2); // 8

        System.out.println("\n ============================== \n");
        Integer x3 = 15;
        Integer x4 = 87;

        swapInt(x3, x4);
        System.out.println("x3 --> "+ x3); // 15
        System.out.println("x4 --> "+ x4); // 87


        // ---> vậy muốn có hàm SWAP được thì phải làm sao ??
        // ---> solution: tự tạo ra 1 class Integer custom của riêng mình rồi set thuộc tính value không phải là private final trong class CustomInteger đó

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

    // swap at HEAP
    private static void swapIntCustom(CustomInteger x, CustomInteger y) {
        int temp = x.getValue();
        x.setValue(y.getValue());
        y.setValue(temp);
    }
}
