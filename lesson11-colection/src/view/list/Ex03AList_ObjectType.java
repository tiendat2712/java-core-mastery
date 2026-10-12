package view.list;

import bean.Item;
import model.DataModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import static utils.CollectionUtil.*;

public class Ex03AList_ObjectType {

    public static void main(String[] args) {

        /*
        Demo methods CRUD with customer object type
           ex: Item, Employee,..

         Khi dùng list.remove(object) thì:
         --> compile: duyệt từng phần tử trong list
            --> kiểm tra nếu phần tử nào 'equals' với object --> xóa
            --> nếu ko có phần tử nào                        --> không xóa

         Nếu KDL của object chưa override hàm equals từ class object --> equals sẽ so sánh theo địa chỉ <hàm equals mặc định của object>

         Thường KDL đổi tượng do mình tạo ra --> override lại hàm equals theo thuộc tính nào đó. <best practice in Java>

         ==> hàm remove hoạt động tương tự hàm boolean list.contains(object)
         */

        var items = DataModel.mockItems();

        // Item itemToBeRemoved = new Item(22, "AItem 22", bd("66"), 2, dt("22/08/2023 17:12:22"));

        // System.out.println("Is contains: " + items.contains(itemToBeRemoved));

        System.out.println("items size before remove: " + items.size());

        // items.remove(itemToBeRemoved);

        System.out.println("items size after remove: " + items.size() + "\n");

        generate("1. Items", items);

        items.removeIf(t -> t.getStoreId() == 1);
        generate("1. Items has been removed where storeId == 1", items);

//        Iterator<Item> iterator = items.iterator();
//        while (iterator.hasNext()) {
//            Item item = iterator.next();
//            if (item.getStoreId() == 1) {
//                iterator.remove();
//            }
//        }
//        generate("1. Items has been removed", items);

        // Xóa những mặt hàng price > 30
        Iterator<Item> iterator = items.iterator();
        while(iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getPrice().compareTo(bd("30")) > 0) {
                iterator.remove();
            }
        }
        generate("1. Items has been removed where price > 30", items);

    }

    public static BigDecimal bd(String value) {
        return new BigDecimal(value);
    }

    public static LocalDateTime dt(String value) {
        return LocalDateTime.parse(value,
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

}
