package view.sorting;

import functional.Compare_String;

import static utils.ArrayUtils.*;

public class Ex02BubbleSort_String {

    public static void main(String[] args) {

        /*

        Sorting with [non]-null values:
           + null first/last
              ~ null first --> null < non-null
              ~ null last --> null > non-null
           + acsending/ descending

         */

        String[] elements = {"dafn", "favj", "siuuu", "goat", "cdnhh", "h16", null, null, null, "b22", "a812h", "84284", null};

        sortString(
                (a, b) -> {
                    if (a == null) {
                        return -1;
                    }
                    if (b == null && a != null) {
                        return 1;
                    }
                    return a.compareTo(b);
                }
                , elements);
        generate("1. String sort asc && Null First --> ", elements);

        sortString(
                (a, b) -> {
                    if (a == null && b != null) {
                        return 1;
                    }
                    if (b == null) {
                        return -1;
                    }
                    return b.compareTo(a);
                }
                , elements);
        generate("1. String sort desc && Null Last --> ", elements);


    }

    // String implements CharSequence, Comparable<String>, ...
    // Comparable<T> --> int compareTo(T t);           --> a.compareTo(b)
    // Object        --> boolean equals(Object o);     --> a.equals(b   )

    private static void sortString(Compare_String compareString, String... elements) {
        for(int i = 0; i < elements.length - 1; i++) {
            for(int j = 0; j < elements.length - i - 1; j++) {
                if(compareString.compare(elements[j], elements[j + 1] ) > 0) {
                    swap(elements, j, j + 1);
                }
            }
        }
    }

}
