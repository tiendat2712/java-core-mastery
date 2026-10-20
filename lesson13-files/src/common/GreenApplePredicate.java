package common;

import bean.Apple;

import java.util.function.Predicate;

public class GreenApplePredicate implements Predicate<Apple>{

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    };

}