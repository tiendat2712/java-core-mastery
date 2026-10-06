package view;

import static utils.ArrayUtils.*;

import java.util.Arrays;

public class Ex02ArrayCrud {

    public static void main(String[] args) {

        int[] numbers = {2, 9, 3, 17, 7};

        // Create => add element at index = ? -> add(int[] elements, int index, int newValue){};
        // ex: add(numbers, 2, 88) --> numbers{2, 9, 88, 3, 17, 7};
        generate("1. Numbers after add --> ", add(numbers, 2, 88));

        // Read -> numbers[i]

        // Update -> numbers[i] = ??

        // Delete => remove element at index = ? -> remove(int[] numbers, int index)
        int[] beRemovedArray = remove(numbers, 2);
        generate("2. Numbers after remove --> ", beRemovedArray);

    }

    /**
     * Add element into arrays
     * @param elements
     * @param index
     * @param value
     * @return
     */
    private static int[] add(int[] elements, int index, int value) {
        if (index < 0 || index >= elements.length) {
            System.out.println("ERROR >> Index Of Bound Exception");
            return elements;
        }

        int[] result = new int[elements.length + 1];

        for (int i = 0; i < index; i++) {
            result[i] = elements[i];
        }

        result[index] = value;

        for (int i = index; i < elements.length; i++) {
            result[i + 1] = elements[i];
        }

        /*  " line 42 = line 46 "
            for(int i = target.length - 1; i > index; i--) {
                    target[i] = origin[i - 1];
            }
         */

        return result;
    }

    /**
     * Remove element out of array
     * @param elements
     * @param index
     * @return
     */
    private static int[] remove(int[] elements, int index) {

        if (index < 0 || index >= elements.length) {
            System.out.println("ERROR >> Index Of Bound Exception");
            return elements;
        }

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
