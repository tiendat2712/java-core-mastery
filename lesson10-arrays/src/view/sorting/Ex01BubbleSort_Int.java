package view.sorting;

import functional.Compare_Int;

import static utils.ArrayUtils.*;

public class Ex01BubbleSort_Int {

    public static void main(String[] args) {

        int[] numbers = {1, 31, 2, 15, 3, 28, 6, 4};

        generate("1. Bubble sort ascending --> ", bubbleSort((a, b) -> a > b, numbers));
        generate("2. Bubble sort descending --> ", bubbleSort((a, b) -> a < b, numbers));

    }

    // sort ascending || descending
    private static int[] bubbleSort(Compare_Int compareInt, int... numbers) {
        // Vòng lặp ngoài: số lần duyệt qua mảng
        for (int i = 0; i < numbers.length - 1; i++) {
            // Vòng lặp trong: so sánh các cặp phần tử cạnh nhau
            // Trừ đi i vì các phần tử ở cuối đã được sắp xếp sau mỗi lượt
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (compareInt.compareTo(numbers[j], numbers[j + 1])) {
                    swap(numbers, j, j + 1);
                }
            }
        }
        return numbers;
    }


}
