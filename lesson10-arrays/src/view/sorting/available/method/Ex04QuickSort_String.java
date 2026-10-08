package view.sorting.available.method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import static utils.ArrayUtils.*;

public class Ex04QuickSort_String {

    public static void main(String[] args) {

        String[] sequences = {"A1", "Z7", "K8", "E9", "B2"};

        Arrays.sort(sequences);
        generate("1. Sort sequences asc --> ", sequences);

        Arrays.sort(sequences, (i1, i2) -> i2.compareTo(i1));
        generate("2. Sort sequences desc --> ", sequences);

        String[] sequencesWithNullValues = {"A1", "Z7", "K8", "E9", "B2", null, null};

        // string -> string
        // Function<T, R> = s -> s;
        // Function<T, R> = Function.identity();

        Arrays.sort(sequencesWithNullValues,
                Comparator.nullsFirst(
                        Comparator.comparing(Function.identity(), Comparator.reverseOrder())
                ));
        generate("3. Sort sequences desc, Null First --> ", sequences);

    }

}
