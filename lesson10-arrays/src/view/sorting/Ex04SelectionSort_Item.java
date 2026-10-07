package view.sorting;

import bean.Item;
import functional.Compare_Item;
import model.DataModel;

import static utils.ArrayUtils.*;

public class Ex04SelectionSort_Item {

    public static void main(String[] args) {

        Item[] items = DataModel.mockItems_NullValues();
        selectionSort((a, b) -> {
            if (a == null) {
                return -1;
            }
            if (b == null) {
                return 1;
            }
            return a.compareTo(b);
        }, items);
        generate("1. Selection sort ascending by ID + Null First", items);

    }

    // multi swap
    private static void selectionSort(Compare_Item compareItem, Item... items) {
        for (int i = items.length - 1; i > 0; i-- ) {
            for ( int j = 0; j < i; j++) {
                if(compareItem.compareTo(items[j], items[i]) > 0) {
                    swap(items, j, i);
                }
            }
        }
    }

    // min, max j's indexz
    private static void selectionSort2(Compare_Item compareItem, Item... items) {
        if (items == null || items.length <= 1) {
            return;
        }

        for (int i = items.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (compareItem.compareTo(items[j], items[maxIndex]) > 0) {
                    maxIndex = j; // Cập nhật lại vị trí tìm thấy phần tử lớn hơn
                }
            }

            // Swap 1 lần duy nhất sau khi tìm được Max
            if (maxIndex != i) {
                swap(items, maxIndex, i);
            }
        }
    }

}
