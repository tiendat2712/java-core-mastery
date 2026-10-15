package view.map;

import static utils.CollectionUtil.*;

import java.util.*;

public class Ex02MapSortingDemo {

    /*

	 List<T> --> null,
	             T1(1,a,z),
	             T2(2,b,k),
	             null
	             --> nullsFirst, nullsLast ok

	 List<T> --> null,
	             T1(null,a,z),
	             T2(2,b,k),
	             null
	             --> nullsFirst, nullsLast ok

	 */

    public static void main(String[] args) {

        var vehicles = new HashMap<Integer, String>();

        // Map<K, V> --> Từng phần tử của nó --> Entry<K, V>

        vehicles.put(74, "a");
        vehicles.put(73, "b");
        vehicles.put(75, "c");
        vehicles.put(92, "d");
        vehicles.put(50, "e");
        vehicles.put(null, "f");

        generate("1. vehicles map --> ", vehicles);

        Map<Integer, String> sortedMap = sort(
                vehicles,
                Comparator.comparing(
                        e -> e.getValue(),
                        Comparator.reverseOrder()
                )
        );
        generate("2. sorted vehicles map, Descending by VALUE --> ", sortedMap);

        vehicles.put(12, null);
        vehicles.put(11, null);

        /* ok --> code hơi dài
		generate("3. Vehicles (sorted by value ascending, null first) -->",
				 sort(vehicles, new Comparator<>() {
					 @Override
					public int compare(Entry<Integer, String> e1, Entry<Integer, String> e2) {
						 String v1 = e1.getValue();
						 String v2 = e2.getValue();
						 if (v1 == null) {
							 return -1;
						 }
						 if (v2 == null) {
							 return 1;
						 }
						 return v1.compareTo(v2);
					}
				})); */

        sortedMap = sort(
                vehicles,
                Comparator.comparing(
                        e -> e.getValue(),
                        Comparator.nullsFirst(Comparator.naturalOrder()) //(String a, String b) -> a.compareTo(b)
                )
        );

        generate("3. sorted vehicles map, Ascending by VALUE, Null First --> ", sortedMap);

    }

    private static Map<Integer, String> sort(Map<Integer, String> maps,
                                             Comparator<Map.Entry<Integer, String>> comparator) {
        // B1. convert Map --> Set (but not support sorting) --> List
        List<Map.Entry<Integer, String>> elements = new ArrayList<>(maps.entrySet());

        // B2. List<Entry<K, V>> --> sort entries by value 'V' in list
        elements.sort(comparator);

        // B3. create newMap, tranfer sorted list to newMap
        var sortedMap = new LinkedHashMap<Integer, String>();

        // B4. Return newMap
        for(Map.Entry<Integer, String> element : elements) {
            sortedMap.put(element.getKey(), element.getValue());
        }

        return sortedMap;
    }

}
