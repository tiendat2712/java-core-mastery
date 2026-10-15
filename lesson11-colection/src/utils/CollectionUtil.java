package utils;

import bean.Item;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

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

    public static <K, V> void generate(String prefix, Map<K, V> map) {
        System.out.println(prefix + " {");
        Set<Map.Entry<K, V>> entries = map.entrySet();
        for (Map.Entry<K, V> entry : entries) {
            System.out.println("    " + entry.getKey() + " --> " + entry.getValue());
        }
        System.out.println("}\n");
    }

}
