package view;

import java.util.Arrays;

public class Ex01ArrayDeclaration {

    public static void main(String[] args) {

        // ** mảng là kiểu đối tượng ==> giá trị lưu trữ ở HEAP **
        // khai báo mảng chứa các phần tử KDL nguyên thủy, đối tượng

        // khai báo mảng 1 chiều
        int[] digits = new int[3]; // digits là KDL đối tượng, digits thuộc class là [I --> digits.getClass()
        int[] numbers = {2, 5, 8};
        int[] elements = new int[]{1, 4, 6, 8}; // thừa khi khai báo, dùng return trực tiếp 1 mảng ở method thì dùng cách này

        System.out.println("digits class --> " + digits.getClass().getSimpleName());

        String[] words = {"hello", "xin chao", "siuuu"};
        System.out.println("words class --> " + words.getClass().getSimpleName());

        modify(words);
        System.out.println("words --> " + Arrays.toString(words));


        // khai báo mảng 2(thường sử dụng), n chiều(hạn chế sử dụng)
        // mảng 1 chiều: mỗi phần tử là 1 giá trị đơn(nguyên thủy, đối tượng)

        System.out.println("\n=========== Mảng nhiều chiều ==============");
        // mảng 2 chiều: mỗi phần tử là 1 mảng 1 chiều
        // ví dụ: ma trận(rows, columns) --> 3rows*4colums
        // 1 2 3 4
        // 2 6 2 3
        // 4 7 7 1
        int[][] empty = new int[3][4];
        int[][] matrix = {
                {1, 2, 3, 4}, // matrix[0]
                {2, 6, 2, 3}, // matrix[1]
                {4, 7, 7, 1}  // matrix[2]
        };

        System.out.println("matrix[0] --> " + Arrays.toString(matrix[0]));
        System.out.println("matrix[1] --> " + Arrays.toString(matrix[1]));
        System.out.println("matrix[2] --> " + Arrays.toString(matrix[2]));

        // matrix.length: số phần tử của mảng --> số dòng
        // matrix[rowI].length: số phần tử của dòng thứ i
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
                System.out.print(matrix[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }

        for (int rowIndex = 0; rowIndex < empty.length; rowIndex++) {
            for (int colIndex = 0; colIndex < empty[rowIndex].length; colIndex++) {
                System.out.print(empty[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }

    }

    private static void modify(String[] elements) {
        elements[1] = null;
    }
}
