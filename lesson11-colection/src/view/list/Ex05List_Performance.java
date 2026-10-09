package view.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex05List_Performance {

    private static int COUNT = 50000;

    public static void main(String[] args) {

        List<String> alist = new ArrayList<>();
        List<String> llist = new LinkedList<>();

        // Add [to the end]
        // Expected: AL ~ LL
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.add("element # " + i);
        }
        System.out.println("Add [to the end] " + COUNT + " elements: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.add("element # " + i);
        }
        System.out.println("Add [to the end] " + COUNT + " elements: LinkedList took "
                + (System.currentTimeMillis() - start) + "ms");

        System.out.println();

        // AL: size = 100_000
        // LL: size = 100_000

        // Add at index: 0, n/2
        // index 0 : expected: LL > AL
        int posToBeAdded = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.add(posToBeAdded, "element # " + i);
        }
        System.out.println("Add at index " + posToBeAdded + ": " + COUNT + " elements: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.add(posToBeAdded, "element # " + i);
        }
        System.out.println("Add at index " + posToBeAdded + ": " + COUNT + " elements: LinkedList took "
                + (System.currentTimeMillis() - start) + "ms");

        System.out.println();

        // AL: size = 200.000
        // LL: size = 200.000

        // index n/2: expected: AL >~ LL

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.add(alist.size() / 2, "element # " + i);
        }
        System.out.println("Add at index n/2: " + COUNT + " elements: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.add(llist.size() / 2, "element # " + i);
        }
        System.out.println("Add at index n/2: " + COUNT + " elements: LinkedList took "
                + (System.currentTimeMillis() - start) + "ms");

        System.out.println();

        // Get: AL > LL
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.get(i);
        }
        System.out.println("Get element: ArrayList took " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.get(i);
        }
        System.out.println("Get element: LinkedList took " + (System.currentTimeMillis() - start) + "ms");

        System.out.println();

        // Set: AL > LL
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.set(i, "modified element # " + i);
        }
        System.out.println("Update element: ArrayList took " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.set(i, "modified element # " + i);
        }
        System.out.println("Update element: LinkedList took " + (System.currentTimeMillis() - start) + "ms");

        System.out.println();

        // Remove at index 0
        // Expected: LL > AL
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.remove(0);
        }
        System.out.println("Remove element at index 0: ArrayList took " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.remove(0);
        }
        System.out.println("Remove element at index 0: LinkedList took " + (System.currentTimeMillis() - start) + "ms");

    }
}