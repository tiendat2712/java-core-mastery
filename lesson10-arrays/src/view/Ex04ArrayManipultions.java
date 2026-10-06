package view;

import functional.Operator;

import static utils.ArrayUtils.*;

public class Ex04ArrayManipultions {

    public static void main(String[] args) {

        /**
         *
         * Cho 1 mang danh sach so nguyen duong [1,20]
         * Yeu cau:
         * 1. Tinh tong cac phan tu trong mang
         * 2. Tinh hieu cac phan tu trong mang
         * 3. Tim max
         * 4. Tim min
         * 5. Tim gia tri trung binh cac phan tu trong mang
         * --> Strategy pattern !!
         */

        // result = result + number
        // result = result - number
        // result > number ? number : result;
        // result < number ? number : result;

        // ==> Strategy: int count(int result, int number);

        int[] numbers = {1, 3, 12, 24, 14, 18, 29};

        generate("1. Sum -> ", reduce(0, (a, b) -> a + b, numbers));
        generate("2. Sub -> ", reduce(0, (a, b) -> a - b, numbers));
        generate("3. Max -> ", reduce(Integer.MIN_VALUE, (a, b) -> a < b ? b : a, numbers));
        generate("4. Min -> ", reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a, numbers));

        // cal average
        int sum = reduce(0, (a, b) -> a + b, numbers);
        double average = (double) sum / numbers.length;
        System.out.println("5. Average -> " + average);

    }

    // sum(int...numbers) -> numbers: nhan vao 0 | 1 | n phan tu int hoac mang int[] --> ex: sum(1, 3, 4, 5); => OKE!
    // sum(int[] numbers) -> numbers: nhan vao mang int[]

    private static int reduce(int initial, Operator operator, int...numbers) {
        int result = initial;
        for(int number : numbers) {
            result = operator.operate(result, number);
        }
        return result;
    }
}
