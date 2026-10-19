package view;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;

public class Ex04MethodReference {

    public static void main(String[] args) {

        /*

         1. Implementation class
		 2. Anonymous class
		 3. Anonymous function (lambda "*")
		 4. Method Reference (là cách viết ngắn gọn của lambda "*")
		    --> static method reference
		    Có thể chuyển 1 lambda bất kỳ sang static method reference

		    Nên dùng khi
		    + Lambda có dạng giống với 1 static method đã tồn tại trong dự án(Java + Custom)
		    + Lambda có body dài và sử dụng được gọi nhiều chỗ

		    --> non-static method reference

		 Bài tập: cho danh sách các số nguyên. Viết chương trình
		 + Tìm tổng các phần tử trong danh sách
		 + Tìm giá trị lớn nhất của các phần tử trong mảng
		 + Tìm giá trị nhỏ nhất của các phần tử trong mảng

         */

        int[] numbers = { 1, 6, 8, 2, 15, 22, 7 };

        int sum = sum(numbers);
        int max = max(numbers);
        int min = min(numbers);

        System.out.println(""
                + "sum = " + sum
                + "\nmax = " + max
                + "\nmin = " + min);

        System.out.println("---------- strategy -----------");

        int sum1 = process(numbers, 0, (x, y) -> x + y);
        int sum11 = process(numbers, 0, Integer::sum);

        int max1 = process(numbers, Integer.MIN_VALUE, (x, y) -> x < y ? y : x);
        int max11 = process(numbers, Integer.MIN_VALUE, Integer::max);

        int min1 = process(numbers, Integer.MAX_VALUE, (x, y) -> x > y ? y : x);
        int min11 = process(numbers, Integer.MAX_VALUE, Integer::min);

        System.out.println(""
                + "sum1 <lambda> = " + sum1
                + "\nsum1 <method reference> = " + sum11
                + "\n"
                + "\nmax1 <lambda> = " + max1
                + "\nmax1 <method reference> = " + max11
                + "\n"
                + "\nmin1 <lambda> = " + min1
                + "\nmin1 <method reference> = " + min11);

    }

    // khai báo static method reference
    private static int sum(int x, int y) { // = Integer::sum
        return x + y;
    }

    private static int max(int a, int b) { // = Integer::max
        return a < b ? b : a;
    }

    private static int min(int a, int b) { // Integer::min
        return a > b ? b : a;
    }

    // sum = sum + element;
    // max = max < element ? element : max;
    // min = min > element ? element : min;

    // int method(int, int) --> IntBinaryOperator

    // Function<T, R>
    // BiFunction<T, U, R>
    // BinaryOperator<T> extends BiFunction<T, T, T>

    // Stream#filter
    // Stream#reduce = process();

    private static int process(int[] elements, int initial, IntBinaryOperator operator) {
        int result = initial;
        for (int element: elements) {
            result = operator.applyAsInt(result, element);
        }
        return result;
    }

    private static int sum(int[] elements) {
        int sum = 0;
        for (int element: elements) {
            sum = sum + element;
        }
        return sum;
    }

    private static int max(int[] elements) {
        int max = Integer.MIN_VALUE;
        for (int element: elements) {
            max = max < element ? element : max;
        }
        return max;
    }

    private static int min(int[] elements) {
        int min = Integer.MAX_VALUE;
        for (int element: elements) {
            min = min > element ? element : min;
        }
        return min;
    }

}
