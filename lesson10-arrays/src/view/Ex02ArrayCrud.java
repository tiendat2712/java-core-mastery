package view;

import java.util.Arrays;

public class Ex02ArrayCrud {

    public static void main(String[] args) {

        int[] numbers = {2, 9, 3, 17, 7};

        // Create => add element at index = ? -> add(int[] elements, int index, int newValue){};
        // ex: add(numbers, 2, 88) --> numbers{2, 9, 88, 3, 17, 7};
        int[] beAddedArray = add(numbers, 2, 88);
        System.out.println("New adding array --> " + Arrays.toString(beAddedArray));

        // Read -> numbers[i]

        // Update -> numbers[i] = ??

        // Delete => remove element at index = ? -> remove(int[] numbers, int index)
        int[] beRemovedArray = remove(numbers, 2);
        System.out.println("New removing array --> " + Arrays.toString(beRemovedArray));

    }

    private static int[] add(int[] elements, int index, int value) {
        int[] result = new int[elements.length + 1];

        for (int i = 0; i < index; i++) {
            result[i] = elements[i];
        }

        result[index] = value;

        for (int i = index; i < elements.length; i++) {
            result[i + 1] = elements[i];
        }

        return result;
    }

    private static int[] remove(int[] elements, int index) {
        int[] result = new int[elements.length - 1];

        for (int i = 0; i < index; i++) {
            result[i] = elements[i];
        }

        for (int i = index; i < result.length; i++) {
            result[i] = elements[i + 1];
        }

        return result;
    }


}
