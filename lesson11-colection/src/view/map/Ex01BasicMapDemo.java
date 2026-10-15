package view.map;

import java.util.*;

public class Ex01BasicMapDemo {

    public static void main(String[] args) {

//        Map<Integer, String> ex = new HashMap<>(); // Key: Integer, Value: String
//        var ex = new HashMap<>();                  // Key: Object, Value: Object


        /*
		 Map: put(K, V)
		 --> ngoài việc lưu trữ giá trị của K, V vào memory, còn hashing giá trị của K theo hàm
		 hashcode(công thức, trả về 1 dãy số) và lưu hashing value này vào memory
		 --> khi tìm kiếm 1 phần tử theo K, hashing key ra hashing value --> tìm theo hashing
		 value --> hỗ trợ tìm kiếm luôn luôn là O(1) khi search theo K


		 HashMap: ko đảm bảo thứ tự đúng như lúc put vào
		 LinkedHashMap: đảm bảo duy trì đúng thứ tự các phần tử đưa vào
		 TreeMap: hỗ trợ 'tự động' sort theo K, yêu cầu <K extends Comparable<?>
		        : nếu K ko phải là extends Comparable<?> thì nó sẽ báo lỗi lúc runtime, casting ...
		        : có thể sử dụng comparator để sort
		        --> k hỗ trợ sort by value

		        --> muốn sort by value --> tự code hàm sort(dùng loại map bất kỳ) --> sort by key, value ...

		 */

        // Sort By Key --> ASC | DESC by properties

//        var vehicles = new HashMap<Integer, String>();
//        var vehicles = new TreeMap<Integer, String>(); // Auto ASC

        /* var vehicles = new TreeMap<Integer, String>(new Comparator<Integer>() { // DECS
            @Override
            public int compare(Integer k1, Integer k2) {
                if (k1 == null && k2 != null) { // Null Last
                    return 1;
                }
                if (k2 == null) {
                    return -1;
                }
                return k2.compareTo(k1);
            }
        }); */

        var vehicles = new TreeMap<Integer, String>(Comparator.nullsLast(Comparator.reverseOrder()));

        vehicles.put(74, "Quang Tri");
        vehicles.put(73, "Quang Binh");
        vehicles.put(75, "Hue");
        vehicles.put(92, "Quang Nam");
        vehicles.put(50, "Ho Chi Minh");
        vehicles.put(null, "Việt Nam");

        vehicles.put(73, "Quang Binh Updated"); // override value if duplicate key
        vehicles.putIfAbsent(92, "Thăng Bình - Quang Nam");

        String value = vehicles.get(73); // O(1)

        System.out.println("Key 73's value --> " + value);
        System.out.println("Key 90's value --> " + vehicles.getOrDefault(90, "Not Found"));

        System.out.println("Vehicles size --> " + vehicles.size());

        printf("1. map --> ", vehicles);

    }

    // Map<K, V> --> mỗi phần từ là 1 entry<k, v> --> k là ko đc phép trùng nhau
    // các entry chắc chắn là khác nhau
    private static void printf(String prefix, Map<Integer, String> map) {
        System.out.println(prefix + " {");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry: entries) {
            System.out.println("    " + entry.getKey() + " --> " + entry.getValue());
        }
        System.out.println("}\n");
    }

}
