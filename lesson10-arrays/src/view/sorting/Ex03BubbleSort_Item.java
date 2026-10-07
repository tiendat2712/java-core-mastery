package view.sorting;

import bean.Item;
import functional.Compare_Item;
import model.DataModel;
import static utils.ArrayUtils.*;

public class Ex03BubbleSort_Item {

    public static void main(String[] args) {

        Item[] result = sortItem(
                (a, b) -> {
                    // Null First
                    if (a == null) {
                        return -1;
                    }
                    if (b == null) {
                        return 1;
                    }
                    return b.compareTo(a);
                }
                , DataModel.mockItems_NullValues()
        );
        generate("1. Items list sort by ID ascending --> ", result);


    }

    private static Item[] sortItem(Compare_Item compareItem, Item... items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length - 1 - i; j++) {
                if (compareItem.compareTo(items[j], items[j + 1]) > 0) {
                    swap(items, j, j + 1);
                }
            }
        }
        return items;
    }

}


