package view.sorting;

import bean.Item;
import functional.Compare_Item;
import model.DataModel;
import utils.ArrayUtils;

import static utils.ArrayUtils.generate;
import static utils.ArrayUtils.swap;

public class Ex05InsertionSort_Item {

    public static void main(String[] args) {

        Item[] items = DataModel.mockItems_NullValues();
        insertionSort((a, b) -> {
            if (a == null) {
                return -1;
            }
            if (b == null) {
                return 1;
            }
            return a.compareTo(b);
        }, items);
        generate("1. Insertion sort ascending by ID + Null First", items);

    }

    private static void insertionSort(Compare_Item compareItem, Item... items) {
        for (int i = 1; i < items.length; i++) {
            for(int j = 0; j < i; j++) {
                if(compareItem.compareTo(items[j], items[i]) > 0) {
                    swap(items, j, i);
                }
            }
        }
    }

}
