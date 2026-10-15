package view.list;

import java.util.ArrayList;
import java.util.List;

import static utils.CollectionUtil.*;

public class Ex04AList_AddRemoveRetainAll {

    public static void main(String[] args) {

        List<String> listA = List.of("a", "b", "c", "d");   
        List<String> listB = List.of("c", "d", "e", "f","g","h"); // immutable list => fix size

        var resultOfAddAll = new ArrayList<String>(listA);
        resultOfAddAll.addAll(listB);
        generateString("1. List of Add all method", resultOfAddAll);

        var resultOfRemoveAll = new ArrayList<String>(listA);
        resultOfRemoveAll.removeAll(listB);
        generateString("2. List of Remove all method", resultOfRemoveAll);

        var resultOfRetainAll = new ArrayList<String>(listA);
        resultOfRetainAll.retainAll(listB);
        generateString("3. List of Retain all method", resultOfRetainAll);

    }

}
