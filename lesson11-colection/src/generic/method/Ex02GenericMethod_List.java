package generic.method;

import bean.Item;

import java.util.Collection;
import java.util.List;

public class Ex02GenericMethod_List {

    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        List<Long> longs = List.of(11L, 22L, 33L, 44L, 55L);
        List<Double> doubles = List.of(1.1d, 2.2d, 3.3d, 4.4d, 5.5d);
        List<String> strings = List.of("a", "b", "c", "d", "e");
        List<Object> objects = List.of("a", 1, 2d, 7L);

        // generateObjects("1. Ints", ints);
        // generateObjects("2. Longs", longs);
        // generateObjects("3. Doubles", doubles);
        // generateObjects("4. Strings", strings);
        generateObjects("5. Objects", objects);

        System.out.println("==== Generic Type ====");

        generate("1. Ints", ints);
        generate("2. Longs", longs);
        generate("3. Doubles", doubles);
        // generate("4. Strings", strings);
        // generate("5. Objects", objects);
    }

    // List<Object>  --> KDL List --> tham số truyền vào Object
    // List<Integer> --> KDL List --> tham số truyền vào Integer
    // --> List<Object> và List<Integer> đều là KDL List với tham số truyền vào khác nhau
    // --> chúng ko phải cha con

    // List<Object> có thể là cha của ArrayList<Object>, LinkedList<Object>

    public static void generateObjects(String prefix, List<Object> collection) {
        System.out.println(prefix + " --> ");
        for (Object item: collection) {
            System.out.println("+ " + item);
        }
        System.out.println();
    }

    // <T> cho phép truyền bất kỳ KDL đối tượng nào vào
    // <T extends Number>: T cho phép truyền vào KDL đối tượng là Number hoặc con của Number
    //                   : giới hạn trên
    // --> T extends CharSequence: giới hạn chuỗi
    public static <T extends Number> void generate(String prefix, List<T> collection) {
        System.out.println(prefix + " --> ");
        for (T item: collection) {
            System.out.println("+ " + item);
        }
        System.out.println();
    }

}




