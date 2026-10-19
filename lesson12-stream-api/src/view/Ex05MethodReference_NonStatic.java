package view;

import bean.Apple;
import model.DataModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static utils.CollectionUtils.*;

public class Ex05MethodReference_NonStatic {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>(DataModel.getApples());

        /*
		 Bài tập: Cho danh sách các apples trong inventory
		 1. Lấy danh sách tất cả các id trong inventory
		 2.                          color
		 3.                          weight
		 */

        // (ClassA tenBien) -> tenBien.tenHam();
        // ClassA::tenHam

        // hamB return KDL B

        // tenBien -> ClassA.hamB().hamC(tenBien)
        // ClassA.hamB()::hamC

        var ids = transfer(inventory, apple ->  apple.getId());
        var colors = transfer(inventory, Apple::getColor);
        var weights = transfer(inventory, apple -> apple.getWeight());

        inventory.sort(Comparator.comparing(Apple::getId));

        ids.forEach(id -> System.out.println(id));
        colors.forEach(System.out::println);
        weights.forEach(weight -> System.out.println(weight));

    }

    // E method(Apple apple)
    // apple.getId()
    // apple.getColor()
    // apple.getWeight()
    // T method(Apple apple)
    // R method(T t) --> Function<T, R>

    // Stream#map = transfer()
    private static <T, R> List<R> transfer(List<T> elements, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T element : elements) {
//            result.add(apple.getId());
            result.add(function.apply(element));
        }
        return result;
    }

    private static List<Integer> getIds(List<Apple> apples) {
        var ids = new ArrayList<Integer>();
        for (var apple : apples) {
            ids.add(apple.getId());
        }
        return ids;
    }

    private static List<String> getColors(List<Apple> apples) {
        var colors = new ArrayList<String>();
        for (var apple : apples) {
            colors.add(apple.getColor());
        }
        return colors;
    }

    private static List<Double> getWeight(List<Apple> apples) {
        var weight = new ArrayList<Double>();
        for (Apple apple : apples) {
            weight.add(apple.getWeight());
        }
        return weight;
    }

}
