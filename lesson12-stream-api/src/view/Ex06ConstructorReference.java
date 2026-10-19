package view;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Supplier;

public class Ex06ConstructorReference {

    public static void main(String[] args) {

        /*
		1. Implementation class
		 2. Anonymous class
		 3. Anonymous function(lambda)
		 4. Method/Constructor Reference
		    4.1 Method Reference(static/non-static)
		    --> Chỉ cần có lambda vs danh sách tham số, body, return_type bất kỳ
		    --> đều có thể chuyển sang method reference(static/non-static)
		    Cách gọi: TenClass::tenHam

		    4.2 Constructor Reference
		    --> Có lambda, danh sách tham số bất kỳ và body gọi đến hàm khởi tạo
		    --> của class nào return type chính là KDL của class đó
		    Cách gọi: TenClass::new
		 */

        var vehicles = mockVehicles();

        var sortedValue = sort(vehicles,
                Comparator.comparing(Map.Entry::getValue),
                new Supplier<LinkedHashMap<Integer, String>>() {
                    @Override
                    public LinkedHashMap<Integer, String> get() {
                        return new LinkedHashMap<>();
                    }
                });

        sortedValue.forEach((k, v) -> System.out.println(k + " --> " + v));

        System.out.println();

        /* var sortedValue1 = sort(vehicles,
                Comparator.comparing(i -> i.getValue()),
                    () -> new LinkedHashMap<>()); */

        var sortedValue1 = sort(vehicles,
                Comparator.comparing(Map.Entry::getValue), // trả về KDL Function
                LinkedHashMap::new); // trả về KDL Supplier

        sortedValue1.forEach((k, v) -> System.out.println(k + " --> " + v));

    }

    private static Map<Integer, String> mockVehicles() {
        // dynamic hash map
        return new HashMap<>() {
            private static final long serialVersionUID = 1L;
            {
                put(92, "A Quảng Nam");
                put(43, "Z Đà Nẵng");
                put(75, "K Thừa Thiên Huế");
//                put(null, "B Việt Nam");
                put(74, "F Quảng Trị");
                put(73, "C Quảng Bình");
                put(73, "Z Quảng Bình");
                put(11, "Cao Bằng");
            }
        };
    }

    private static <T extends Map<Integer, String>> Map<Integer, String> sort(
            Map<Integer, String> map,
            Comparator<Map.Entry<Integer, String>> comparator,
            Supplier<T> supplier) {
        // map -> list
        List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        entries.sort(comparator);

        // có thể dùng bất kỳ lớp thực thi nào của Map: HashMap, TreeMap, LinkedHashMap
        Map<Integer, String> sortedMap = supplier.get();
        for (Map.Entry<Integer, String> entry: entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
