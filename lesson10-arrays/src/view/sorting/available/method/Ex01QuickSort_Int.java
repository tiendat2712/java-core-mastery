package view.sorting.available.method;

import common.SortType;

import static utils.ArrayUtils.*;

import java.util.Arrays;

public class Ex01QuickSort_Int {

    public static void main(String[] args) {

        // array --> Arrays.sort
        // ** no support descending sort with primitive type **
        int[] numbers = {1, 24, 23, 5, 12, 12, 14};
        Arrays.sort(numbers);
        generate("1. Sort default --> ", numbers);

        sort(numbers, SortType.DESC);
        generate("2. Sort descending --> ", numbers);

    }

}
