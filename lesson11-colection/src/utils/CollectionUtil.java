package utils;

import bean.Item;

import java.util.Collection;

public class CollectionUtil {

    private CollectionUtil(){
    }

    public static void generate(String prefix, Collection<Item> collection) {
        System.out.println(prefix + " --> ");
        for (Item item : collection) {
            System.out.println("+ " + item);
        }
        System.out.println();
    }

    public static void generateString(String prefix, Collection<String> collection) {
        System.out.println(prefix + " --> ");
        for (String item : collection) {
            System.out.println("+ " + item);
        }
        System.out.println();
    }

}
