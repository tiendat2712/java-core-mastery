package generic.class_interface;

public class Cr7GenericClassInterface {

    public static void main(String[] args) {

        var sequences = new Cr7CustomList<String>();

        sequences.add("a");
        sequences.add("b");
        sequences.add("c");
        sequences.add("d");
        sequences.add("e");
        sequences.add("t");
        sequences.add("a");
        sequences.add("b");
        sequences.add("c");
        sequences.add("d");
        sequences.add("e");
        sequences.add("t");

        System.out.println("size --> " + sequences.size());
        System.out.println("capacity --> " + sequences.capacity());

        sequences.forEach(i -> System.out.println(i), i -> i.compareTo("c") < 0);

    }

}
