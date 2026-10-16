package model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Apple;
import bean.Dish;
import bean.Item;
import bean.Store;
import common.Category;

public class DataModel {

    private DataModel() {
    }

    public static List<Item> mockItems() {
        Store s1 = new Store(1, "Store 1");
        Store s2 = new Store(2, "Store 2");
        Store s3 = new Store(3, "Store 3");
        Store s4 = new Store(4, "Store 4");
        Store s5 = new Store(5, "Store 5");
        Store s6 = new Store(6, "Store 6"); // chưa bán hàng
        Store s7 = new Store(7, "Store 7"); // chưa bán hàng

        return List.of(
                new Item(101, "Item 101", new BigDecimal("202"), List.of(s1, s2)),
                new Item(102, "Item 102", new BigDecimal("303"), List.of(s1, s2, s3)),
                new Item(103, "Item 103", new BigDecimal("404"), List.of(s1, s4, s5)),
                new Item(104, "Item 104", new BigDecimal("505"), List.of(s1, s2, s7, s4, s5))
        );
    }

    public static Map<Integer, String> mockVehicles() {
        var vehicles = new HashMap<Integer, String>();

        vehicles.put(92, "A Quảng Nam");
        vehicles.put(43, "Z Đà Nẵng");
        vehicles.put(75, "K Thừa Thiên Huế");
        // vehicles.put(null, "B Việt Nam");
        vehicles.put(74, "F Quảng Trị");
        vehicles.put(73, "C Quảng Bình");
        vehicles.put(73, "Z Quảng Bình");
        vehicles.put(11, "Cao Bằng");

        return vehicles;
    }

    public static List<Dish> mockDishes() {
        return List.of(
                new Dish("D01", "Dish D10", 220, Category.FISH),
                new Dish("D02", "Dish E12", 782, Category.MEAT),
                new Dish("D03", "Dish A3", 700, Category.VEGGIE),
                new Dish("D04", "Dish A4", 850, Category.EGG),
                new Dish("D05", "Dish B5", 220, Category.FISH),
                new Dish("D06", "Dish B6", 782, Category.MEAT),
                new Dish("D07", "Dish C7", 111, Category.VEGGIE),
                new Dish("D08", "Dish C8", 1020, Category.EGG),
                new Dish("D09", "Dish D9", 220, Category.FISH),
                new Dish("D10", "Dish D10", 777, Category.MEAT),
                new Dish("D11", "Dish E11", 111, Category.EGG),
                new Dish("D12", "Dish E12", 1500, Category.EGG)
        );
    }

    public static List<Apple> getApples() {
        return List.of(
                new Apple(1, "green", 200d, "Vietnam"),
                new Apple(16, "green", 300d, "Vietnam"),
                new Apple(22, "red", 300d, "Lao"),
                new Apple(4, "yellow", 400d, "Thailand"),
                new Apple(17, "red", 600d, "Vietnam"),
                new Apple(6, "green", 100d, "Thailand")
        );
    }

}