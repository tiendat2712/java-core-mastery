package functional;

import bean.Item;

@FunctionalInterface
public interface Compare_Item {

    int compareTo(Item i1, Item i2);

}
