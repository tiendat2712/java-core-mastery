package view.map;

import bean.Item;
import bean.Store;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex03MapIdeaOfOverlappingKey {

    public static void main(String[] args) {

        var storeItemsMap = new HashMap<Store, List<Item>>();

        // ----------------------------------------

        storeItemsMap.put(
                new Store(1, "Store 1"),
                List.of(new Item(11, "Item 11", bd(11), 1, LocalDateTime.now()),
                        new Item(12, "Item 12", bd(12), 1, LocalDateTime.now()),
                        new Item(21, "Item 21", bd(21), 2, LocalDateTime.now()),
                        new Item(22, "Item 22", bd(22), 2, LocalDateTime.now())));

        storeItemsMap.put(
                new Store(2, "Store 2"),
                List.of(new Item(21, "Item 21", bd(21), 2, LocalDateTime.now()),
                        new Item(22, "Item 22", bd(22), 2, LocalDateTime.now()),
                        new Item(23, "Item 23", bd(23), 2, LocalDateTime.now())));

        storeItemsMap.put(
                new Store(3, "Store 3"),
                List.of(new Item(31, "Item 31", bd(31), 3, LocalDateTime.now()),
                        new Item(32, "Item 32", bd(32), 3, LocalDateTime.now()),
                        new Item(33, "Item 33", bd(33), 3, LocalDateTime.now()),
                        new Item(34, "Item 34", bd(34), 3, LocalDateTime.now())));

        storeItemsMap.put(
                new Store(4, "Store 4"),
                List.of(new Item(41, "Item 41", bd(41), 4, LocalDateTime.now())));

        // ----------------------------------------

        // khi put 1 entry mới vào map --> map.put(key, value)

        // kiểm tra
        // 1. hashcode của key có trùng với hashcode của keys nào bên trong map chưa
        // 2. key có equals với keys nào trong map chưa

        // nếu vừa trùng cả hashcode vừa equals --> báo key này đã trùng, tồn tại
        // ngược lại --> chưa trùng

        // hashcode(Object) --> mặc định = System.identityHashCode(object) --> địa chỉ ở HEAP của đối tượng
        // equals(Object) --> mặc định so sánh địa chỉ của 2 đối tượng dùng toán tử ==

        // hash = k.hashcode() --> hashcode mặc định là địa chỉ
        // if (p.hash == hash &&((k = p.key) == key || (key != null && key.equals(k))))

        // hashcode --> công thức để hashing giá trị của thuộc tính --> trả về int(dãy số)

        // hashing(abcdef) int = int hashing(ecbdfe)

        // equals

        // sau khi đã override --> 2 đối tượng mà equals thì phải có hashcode giống nhau

        storeItemsMap.put(
                new Store(3, "Store 3"),
                List.of(new Item(91, "Item 91", bd(91), 3, LocalDateTime.now()),
                        new Item(92, "Item 92", bd(92), 3, LocalDateTime.now())));

        storeItemsMap.put(
                new Store(3, "Store 3 ver != name"),
                List.of(new Item(91, "Item 91", bd(91), 3, LocalDateTime.now()),
                        new Item(92, "Item 92", bd(92), 3, LocalDateTime.now())));

        System.out.println("store items map: size = " + storeItemsMap.size());

        printf(storeItemsMap);

    }

    private static void printf(Map<Store, List<Item>> storeItemsMap) {
        storeItemsMap.forEach((k, v) -> {
            var storeName = k.getName();
            var itemIds = new ArrayList<Integer>();
            for(Item item : v) {
                itemIds.add(item.getId());
            }
            System.out.println(storeName + " --> " + itemIds);
        });
    }

    private static BigDecimal bd(Number number) {
        if (number == null) {
            return null;
        }
        return new BigDecimal(number.toString());
    }

}
