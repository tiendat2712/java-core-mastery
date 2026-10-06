package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bean.Item;

public class DataModel {

    private DataModel() {
    }

    public static Item[] mockItems() {
        return new Item[]{
                new Item(11, "Item 11", bd("22"), 1, dt("16/11/2023 15:12:22")),
                new Item(14, "ZItem 14", bd("77"), 1, dt("18/12/2023 16:12:22")),
                new Item(22, "AItem 22", bd("66"), 2, dt("22/08/2023 17:12:22")),
                new Item(21, "KItem 77", bd("18"), 2, dt("05/05/2023 18:12:22")),
                new Item(12, "Item 12", bd("99"), 1, dt("24/12/2023 12:12:22")),
                new Item(55, "Item 55", bd("55"), 5, dt("17/11/2023 11:12:22")),
        };
    }

    public static Item[] mockItems_NullValues() {
        return new Item[]{
                null,
                new Item(11, "Item 11", bd("22"), 1, dt("16/11/2023 15:12:22")),
                new Item(14, "ZItem 14", bd("77"), 1, dt("18/12/2023 16:12:22")),
                null,
                new Item(22, "AItem 22", bd("66"), 2, dt("22/08/2023 17:12:22")),
                new Item(21, null, bd("18"), 2, dt("05/05/2023 18:12:22")),
                new Item(12, "Item 12", bd("99"), 1, dt("24/12/2023 12:12:22")),
                null,
                new Item(55, "Item 55", bd("55"), 5, dt("17/11/2023 11:12:22")),
                null
        };
    }

    public static BigDecimal bd(String value) {
        return new BigDecimal(value);
    }

    public static LocalDateTime dt(String value) {
        return LocalDateTime.parse(value,
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

}