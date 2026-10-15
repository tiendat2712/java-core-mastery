package generic.class_interface;

public class Cr7GenericClassInterface {

    public static void main(String[] args) {

        System.out.println("========== 1. CONSTRUCTOR ==========");

        var sequences = new Cr7CustomList<String>();

        System.out.println("Initial list:");
        printList(sequences);
        System.out.println("size = " + sequences.size());
        System.out.println("capacity = " + sequences.capacity());

        var customCapacityList = new Cr7CustomList<String>(10);

        System.out.println("\nCustom initial capacity = 10");
        System.out.println("size = " + customCapacityList.size());
        System.out.println("capacity = " + customCapacityList.capacity());


        System.out.println("\n========== 2. ADD(E e) ==========");

        sequences.add("a");
        sequences.add("b");
        sequences.add("c");
        sequences.add("d");
        sequences.add("e");

        printList(sequences);
        System.out.println("size = " + sequences.size());
        System.out.println("capacity = " + sequences.capacity());


        System.out.println("\n========== 3. ADD(INDEX, E) ==========");

        sequences.add(2, "X");

        System.out.println("After add(2, \"X\"):");
        printList(sequences);

        sequences.add(sequences.size(), "Z");

        System.out.println("After add(size, \"Z\"):");
        printList(sequences);


        System.out.println("\n========== 4. GET(INDEX) ==========");

        System.out.println("get(0) = " + sequences.get(0));
        System.out.println("get(2) = " + sequences.get(2));
        System.out.println("get(last) = "
                + sequences.get(sequences.size() - 1));


        System.out.println("\n========== 5. GET OR DEFAULT ==========");

        System.out.println("getOrDefault(0, \"DEFAULT\") = "
                + sequences.getOrDefault(0, "DEFAULT"));

        sequences.add("null-test");

        // Thêm null để demo getOrDefault
        sequences.add(null);

        System.out.println("getOrDefault(last, \"DEFAULT\") = "
                + sequences.getOrDefault(sequences.size() - 1, "DEFAULT"));


        System.out.println("\n========== 6. SET(INDEX, VALUE) ==========");

        sequences.set(0, "A");

        System.out.println("After set(0, \"A\"):");
        printList(sequences);


        System.out.println("\n========== 7. FOR EACH + PREDICATE ==========");

        System.out.println("Print elements lexicographically smaller than \"c\":");

        sequences.forEach(
                value -> System.out.println("Element: " + value),
                value -> value != null && value.compareTo("c") < 0
        );


        System.out.println("\n========== 8. REMOVE(E e) ==========");

        boolean removedByValue = sequences.remove("X");

        System.out.println("remove(\"X\") = " + removedByValue);
        printList(sequences);

        boolean removedMissing = sequences.remove("NOT_EXIST");

        System.out.println("remove(\"NOT_EXIST\") = " + removedMissing);


        System.out.println("\n========== 9. REMOVE(INDEX, E) ==========");

        boolean removedByIndexAndValue = sequences.remove(1, "b");

        System.out.println("remove(1, \"b\") = "
                + removedByIndexAndValue);
        printList(sequences);

        boolean wrongValue = sequences.remove(1, "WRONG");

        System.out.println("remove(1, \"WRONG\") = " + wrongValue);
        printList(sequences);


        System.out.println("\n========== 10. REMOVE IF ==========");

        boolean removedByPredicate =
                sequences.removeIf(value -> value != null
                        && value.compareTo("c") >= 0);

        System.out.println("removeIf(value >= \"c\") = "
                + removedByPredicate);
        printList(sequences);


        System.out.println("\n========== 11. REMOVE NULL ==========");

        boolean removedNull = sequences.remove(null);

        System.out.println("remove(null) = " + removedNull);
        printList(sequences);


        System.out.println("\n========== 12. GROW / CAPACITY ==========");

        var growList = new Cr7CustomList<Integer>();

        System.out.println("Before adding:");
        System.out.println("size = " + growList.size());
        System.out.println("capacity = " + growList.capacity());

        for (int i = 1; i <= 8; i++) {
            growList.add(i);
            System.out.printf(
                    "add(%d) -> size=%d, capacity=%d%n",
                    i,
                    growList.size(),
                    growList.capacity()
            );
        }

        System.out.println("Final growList:");
        printList(growList);


        System.out.println("\n========== 13. FINAL STATE ==========");

        System.out.println("sequences:");
        printList(sequences);
        System.out.println("size = " + sequences.size());
        System.out.println("capacity = " + sequences.capacity());
    }


    // Helper method để in list
    private static <T> void printList(Cr7CustomList<T> list) {
        System.out.print("[ ");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));

            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" ]");
    }

}
