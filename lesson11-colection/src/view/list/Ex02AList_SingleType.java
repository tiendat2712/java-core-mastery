package view.list;


import java.util.ArrayList;
import java.util.List;

public class Ex02AList_SingleType {

    public static void main(String[] args) {

//        var sequences = new ArrayList<String>(); // JDK 1.10

        List<String> sequences = new ArrayList<>();

        sequences.add("123");
        sequences.add("world");
        sequences.add("test");
        sequences.add("kaka");

        System.out.println("Sequences size --> " + sequences.size());
        printf("2. Sequences printf", sequences, " ");

        1:15:00
    }

    private static void printf(String prefix, List<String> sequences, String delimiter) {
        System.out.print("\n" + prefix + " -->" + delimiter);
        for (int i = 0; i < sequences.size(); i++) {
            System.out.print(sequences.get(i) + delimiter);
        }
    }

}
