package view.set;

import bean.Item;

import static utils.CollectionUtil.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;

public class Ex02SetIdeaOfOverlapElements {

    public static void main(String[] args) {

        var items = new LinkedHashSet<Item>();

        items.add(new Item(1, "Item 1", bd(1), 1, LocalDateTime.now()));
        items.add(new Item(2, "Item 2", bd(2), 1, LocalDateTime.now()));
        items.add(new Item(3, "Item 3", bd(3), 1, LocalDateTime.now()));

        // test overlap values (equals by itemID)
        items.add(new Item(2, "Item 2", bd(2), 1, LocalDateTime.now()));
        items.add(new Item(2, "Item 2222", bd(10), 2, LocalDateTime.now()));


        System.out.println("items: size = " + items.size() + "\n");

        generate("1. Set ", items);
    }

    private static BigDecimal bd(Number number) {
        if (number == null) {
            return null;
        }
        return new BigDecimal(number.toString());
    }

}
