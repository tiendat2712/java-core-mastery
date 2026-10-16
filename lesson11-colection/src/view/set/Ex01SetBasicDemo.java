package view.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static utils.CollectionUtil.*;

public class Ex01SetBasicDemo {

    public static void main(String[] args) {
        // Set<T>
        // HashSet --> ko đảm bảo đúng thứ tự các phần tử đưa vào
        // LinkedHashSet --> đảm bảo đúng thứ tự các phần tử đưa vào
        // TreeSet --> tự động sắp xếp các phần tử
        ///        --> yêu cầu: T phải là con của Comparable<T>

        var numbers = new HashSet<Integer>();

        numbers.add(35);
        numbers.add(72);
        numbers.add(46);
        numbers.add(58);
        numbers.add(15);

        // add một phần tử T mới vào set
        // kiểm tra xem
        // 1. newValue có hashcode trùng với hashcode của phần tử nào trong SET chưa
        // 2. newValue có equals với phần tử nào trong SET chưa

        // nếu vừa equals vừa có hashcode trùng --> newValue đã tồn tại trong SET --> k thêm mới
        // ngược lại --> newValue chưa tồn tại trong SET --> thêm thành công
        numbers.add(46);

		/*

		    Set<E>
			  private Map<E, Object> map;

			set.add(e)

			map.put(e, PRESENT);

			--> add 1 phần tử vào set, đưa phần tử đó vào entry

			add(e) --> put(e, PRESENT)

			--> add thành công khi put key, PRESENT
			thành công

		 */

        generate("1. Numbers", numbers);
    }

}