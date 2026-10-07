package utils;

import java.util.Arrays;

public class ArrayUtils {

    private ArrayUtils(){
    }

    public static void generate(String prefix, int... elements) {
        System.out.println(prefix + Arrays.toString(elements));
        System.out.println();
    }

    public static void generate(String prefix, String... elements) {
        System.out.println(prefix + Arrays.toString(elements));
        System.out.println();
    }

    public static void swap(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public static void swap(String[] elements, int i, int j) {
        String temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

}
