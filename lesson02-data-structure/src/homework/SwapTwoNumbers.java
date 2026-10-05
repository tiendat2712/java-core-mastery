package homework;

public class SwapTwoNumbers {

    public static void main(String[] args) {

        CustomInteger x1 = new CustomInteger(5);
        CustomInteger x2 = new CustomInteger(10);

        swapInt(x1, x2);
        System.out.println("x1 --> "+ x1);
        System.out.println("x2 --> "+ x2);
    }

    // swap at HEAP
    private static void swapInt(CustomInteger x, CustomInteger y) {
        int temp = x.getValue();
        x.setValue(y.getValue());
        y.setValue(temp);
    }
}
