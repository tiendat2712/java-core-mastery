package datastructure.primitive;

public class Ex03FunctionPassing {

    public static void main(String[] args) {
        int a = 22;
        int b = 27;

        Character c = Character.valueOf('?');
        System.out.println("Character object --> "+ c);

        swap(a, b);

        System.out.println("a ---> "+ a);
        System.out.println("b ---> "+ b);

        /*
        --> Java: pass by value 100% AT STACK == toán tử '=' --> 100% gán ở STACK
       ---> truyền tham số qua hàm thì --> truyền giá trị(STACK) cho tham số còn ô nhớ của biến không thay đổi

         */
    }

    private static void modify(int a) {
        a = 999;
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
