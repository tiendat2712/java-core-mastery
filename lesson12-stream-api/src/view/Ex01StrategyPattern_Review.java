package view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import bean.Apple;
import common.GreenApplePredicate;
import model.DataModel;

import static utils.CollectionUtils.*;

public class Ex01StrategyPattern_Review {

    public static void main(String[] args) {
        var inventory = DataModel.getApples();

        // filter all green apples in inventory

        // Cách 1: Implementation class
        var greenApples = filterApples(inventory, new GreenApplePredicate());
        generate("1. Green Apples(use implementation class)", greenApples);

        // Cách 2: Anonymous class
        greenApples = filterApples(inventory, new Predicate<Apple>() {

            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
        generate("2. Green Apples(use anonymous class)", greenApples);

		/*
		 Cách 3: Anonymous function = Lambda expression
		 Là đoạn code override hàm trừu tượng bên trong functional interface
		 nhưng mà ko có tên hàm
		 cấu trúc:
		 (danh sách tham số của hàm trừu tượng) -> {
			    body, override hàm trừu tượng
		 }

		 Lưu ý:
		 + tham số của lambda --> ko yêu cầu phải điền KDL
		 + nếu chỉ có 1 tham số --> có thể bỏ luôn (...) trước dấu ->
		 + nếu body chỉ có 1 dòng --> bỏ luôn {}, bỏ luôn ;
		   . nếu return type !void --> bỏ luôn chữ return
		*/
        greenApples = filterApples(inventory, (Apple apple) -> {
            return "green".equals(apple.getColor());
        });
        generate("3. Green Apples(use anonymous function)", greenApples);


        // filter all red apples and weight heavier than 150g
        var redAndHeavyApples = filterApples(inventory, i -> "red".equals(i.getColor()) && i.getWeight() > 400);
        var redAndHeavyApples1 = filterApples(inventory, i -> "red".equals(i.getColor()) && i.getWeight() > 400);
        generate("4. Red and Heavy Apples > 400", redAndHeavyApples);
        generate("4. Red and Heavy Apples > 400 -- 'method reference'", redAndHeavyApples1);

        // filter all apples from viet nam
        var applesFromVietNam = filterApples(inventory, i -> "VietNam".equalsIgnoreCase(i.getCountry()));
        var applesFromVietNam1 = filterApples(inventory, Ex01StrategyPattern_Review::isVietNam);
        generate("5. Filter all apples from viet nam", applesFromVietNam);



        // Lambda là gì ?

        // Lambda(anonymous function) là cách viết ngắn gọn để tạo ra giá trị/đối tượng
        // cho biến KDl functional interface

        // Dùng lambda chỗ nào ?

        // Chỗ nào cần khởi tạo function interface -> dùng lambda cho code ngắn gọn thay vì
        // phải dùng ** anonymous class | implementation class **

        // Vì sao lambda chỉ khởi tạo dc cho function interface thôi, interface bình thường dc ko ?

        // không, vì lambda(**hàm ko tên**) override hàm trừu tượng trong interface ko có tên
        // nếu interface có nhiều hơn 1 hàm trừu tượng, nếu các hàm trừu tượng đó có cùng số lượng tham số, KD
        // lúc override sẽ ko biết đang override cho hàm nào

        // Predicate<T>
        // boolean test(T t);
        // boolean isTrue(T t);

        // Predicate<Apple> pre = (apple) -> true;

        // Functional interface là gì ?

        // Là interface chỉ có 1 abstract method

        // Dùng FI chỗ nào

        // Thường dùng khi các đoạn code có dạng strategy pattern
    }


	/*

	 var vnApples = filter(inventory, apple ->
			"vietnam".equalsIgnoreCase(apple.getCountry())
		);

	 */

    private static boolean isVietNam(Apple apple) {
        return "vietnam".equalsIgnoreCase(apple.getCountry());
    }

    private static boolean isRedAndHeavyApples(Apple apple) {
        return ("red".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 400);
    }


    // công thức chung của các điều kiện: boolean method(Apple apple)
    // thường: tạo ra 1 functional interface chứa hàm trừu tượng trên

    // Java có sẵn: Predicate<T>

    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        var result = new ArrayList<Apple>();

        for (var apple: inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}