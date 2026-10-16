package view;

import java.util.concurrent.Callable;
import java.util.function.*;

public class Ex02LambdaSyntax {

    public static void main(String[] args) {

        // Khi code cho 1 lambda (đúng) --> suy ra được công thức của "HÀM TRỪU TƯỢNG" của KDL trả về functional interface

        Runnable runnable = () -> {};

        Supplier supplier = () -> "Cristiano Ronaldo"; // () -> T
        Callable callable = () -> "Messi";             // () -> T

        Function<Integer, String> function = (Integer i) -> "Neymar " + i; // T -> R
        System.out.println("1. APPLY 15 -->  " + function.apply(15));

        UnaryOperator<String> unaryOperator = (String i) -> "Iron Man"; // T -> T
        System.out.println("2. UnaryOperator --> " + unaryOperator.apply("27")); // String -> String

        // 1. Consumer<T>: T -> void (Nhận vào 1 tham số, thực thi hành động và không trả về gì)
        Consumer<String> consumer = (String name) -> System.out.println("3. Consumer --> Hello " + name);
        consumer.accept("Cristiano Ronaldo");

        // 2. BiConsumer<T, U>: (T, U) -> void (Nhận vào 2 tham số, không trả về gì)
        BiConsumer<String, Integer> biConsumer = (String player, Integer number) ->
                System.out.println("4. BiConsumer --> Player: " + player + ", Number: " + number);
        biConsumer.accept("Messi", 10);

        // 3. Predicate<T>: T -> boolean (Nhận vào 1 tham số, kiểm tra điều kiện và trả về true/false)
        Predicate<Integer> predicate = (Integer age) -> age >= 18;
        System.out.println("5. Predicate --> Is adult? " + predicate.test(20));

        // 4. BiPredicate<T, U>: (T, U) -> boolean (Nhận vào 2 tham số, trả về true/false)
        BiPredicate<String, String> biPredicate = (String s1, String s2) -> s1.equals(s2);
        System.out.println("6. BiPredicate --> Are they equal? " + biPredicate.test("Java", "Java"));

        // 5. BiFunction<T, U, R>: (T, U) -> R (Nhận vào 2 tham số khác nhau, trả về kết quả kiểu R)
        BiFunction<Integer, Integer, Integer> biFunction = (Integer a, Integer b) -> a + b;
        System.out.println("7. BiFunction --> Sum = " + biFunction.apply(10, 20));

        // 6. BinaryOperator<T>: (T, T) -> T (Nhận vào 2 tham số cùng kiểu T, trả về kết quả cùng kiểu T)
        BinaryOperator<Integer> binaryOperator = (Integer a, Integer b) -> a * b;
        System.out.println("8. BinaryOperator --> Multiply = " + binaryOperator.apply(5, 6));

        // Predicate<T>     --> T      -> boolean  --> signature, descriptor
        // Consumer<T>      --> T      -> void
        // Comparator<T>    --> (T, T) -> int
        // Comparable<T>    --> T      -> int
        // Function<T, R>   --> T      -> R
        // UnaryOperator<T> --> T      -> T
        // Supplier<T>      --> ()     -> T
        // Callable<T>      --> () throws Exception -> T
        // Runnable         --> ()     -> void

    }

}
