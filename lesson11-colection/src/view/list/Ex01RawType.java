package view.list;

import java.util.ArrayList;
import java.util.List;

public class Ex01RawType {

    public static void main(String[] args) {

		/*

		 Nếu gọi, sử dụng class/interface có tham số là generic type

		 --> Phải truyền giá trị cho tham số đó: là 1 KDL đối tượng

		 --> Nếu mình ko truyền KDL vào --> mặc định Object --> raw type

		 Raw Types
		 --> dễ bị lỗi casting exception lúc runtime --> ko mong muốn

		 JDK 1.5: auto boxing, auto unboxing
		        : generic type 1.7(enhancement)

		 */

        @SuppressWarnings("rawtypes")
        List listA = new ArrayList(); // mục đích --> danh sách các số nguyên
        List listB = new ArrayList(); // mục đích --> danh sách các chuỗi

        listA.add(1); // add(Object a);
        listA.add(2);
        listA.add("3");
        listA.add("bon");

        // duyệt và in ra
        for (Object element: listA) {
            System.out.println(Integer.parseInt(element.toString()) * 2);
        }

    }

}
