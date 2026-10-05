package view.funtional_interface;

public class Ex01FunctionalInterfaceDemo {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Đếm số lượng chẵn, lẻ, bội của 3, bội của 5

        System.out.println("Số phần tử chắn là: --> " + countNumbers(numbers, a -> a % 2 == 0));
        System.out.println("Số phần tử lẻ là: --> " + countNumbers(numbers, a -> a % 2 != 0));
        System.out.println("Số phần tử chia hết cho 3 là: --> " + countNumbers(numbers, a -> a % 3 == 0));
        System.out.println("Số phần tử chia hết cho 5 là: --> " + countNumbers(numbers, a -> a % 5 == 0));

    }

    private static int countNumbers(int[] numbers, IntTest intTest) {
        int count = 0;
        for(int number : numbers) {
            if(intTest.test(number)) {  //test(number) --> strategy <công thức chung>
                count++;
            }
        }
        return count;
    }
}
