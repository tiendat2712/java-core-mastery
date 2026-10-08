package view.sorting.available.method;

import bean.Item;
import model.DataModel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import static utils.ArrayUtils.*;

public class Ex03QuickSort_Item_SimpleCases {

    /**
     Với những trường hợp đơn giản như
     + sắp xếp tăng dần giảm dần theo 1 hoặc nhiều thuộc tính
     + null first, last cho elements
     --> Áp dụng sort có sẵn ngắn gọn hơn như bên dưới
     --> Arrays.sort(elements, Comparator.comparing(....))

     Với những trường hợp
     + sắp xếp điều kiện if else phức tạp theo logic
     + null first, last cho thuộc tính của elements
     --> Arrays.sort(elements, (t1, t2) -> ...)
     */

    public static void main(String[] args) {

        Item[] items = DataModel.mockItems();

        // Arrays.sort(items, (c1, c2) -> c1.getPrice().compareTo(c2.getPrice()));


        // Function<T, R> function = (T t1) -> t1.getAttr(); --> lambda expression
        // Function<T, R> function = T::getAttr;           --> method reference (cách viết ngắn gọn của lambda)

        // Function<Item, BigDecimal> keyExtractor = item -> item.getPrice();
        // Function<Item, BigDecimal> keyExtractor = Item::getPrice;

        // sort ascending by price
        Arrays.sort(items, (i1, i2 ) -> {
            return i1.getPrice().compareTo(i2.getPrice());
        });

        Function<Item, BigDecimal> keyExtractor = new Function<Item, BigDecimal>() {

            @Override
            public BigDecimal apply(Item item) {
                return item.getPrice();
            }
        };

        Arrays.sort(items, Comparator.comparing(keyExtractor));
        Arrays.sort(items, Comparator.comparing(d -> d.getPrice())); // --> lambda expression
        Arrays.sort(items, Comparator.comparing(Item::getPrice)); // --> method reference

        generate("1. Sort ascending by price --> ", items);

        System.out.println(" ----------------- --------------- -------------------- \n");

        Item[] items2 = DataModel.mockItems_NullValues();

        Arrays.sort(items2,
                Comparator.nullsLast(
                        Comparator.comparing(Item::getStoreId) // storeId[asc]
                        .thenComparing(Item::getCreatedAt, Comparator.reverseOrder())
                ));
        generate("2. Sort items by storeId[asc], by createdAt[desc] --> ", items2);

        // sorting with Collator --> more advanced

    }

}
