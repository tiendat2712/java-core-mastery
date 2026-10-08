package view;

import java.util.Arrays;

public class Ex04Sorting {

    /*
        Bài 4: Cho mảng string có n phần tử (2 < n < 100). Mảng cho phép chứa các phần tử là
        số âm, số dương, chuỗi “special” và các chuỗi kí tự khác. Viết chương trình sắp xếp
        mảng string.
        Biết rằng. Khi chạy chương trình mảng sẽ sắp xếp theo thứ tự như sau
        Tăng dần: Special => số âm tăng dần => số dương tăng dần => chuỗi tăng dần

        -------------------------------------------------------------------------------------------

        ** Giảm dần: Giảm dần các chuỗi trong mảng => số dương giảm dần => số âm giảm dần
        => Special
        VD: String[] strings = {“-2”, “-6”, “10”, null, “4”, “8”, null, “Special”, “a”, “c”,
        “b”, “xx”}
        ** Tăng dần: Special, -6, -2, 4, 8, 10, a, b, c, xx, null, null
        Giảm dần: null, null, xx, c, b, a, 10, 8, 4, -2, -6, Special
     */

    public static void main(String[] args) {
        String[] sequences =
                { "-2", "-6", "10", null, "4", "41",
                        "8", null, "special", "a", "c", "b", "xx" };


        Arrays.sort(sequences, (i1, i2) -> {
            if(i1.matches("-?\\d+(\\.\\d+)?") && i2.matches("-?\\d+(\\.\\d+)?")) {
                Integer num1 = Integer.parseInt(i1);
                Integer num2 = Integer.parseInt(i2);
                if(num1 > 0 && num2 > 0) {
                    return num1.compareTo(num2);
                }
            }

            if(i1 == "special") {
                return -1;
            }
            if(i2 == "special") {
                return 1;
            }
            return 1;
        });

    }

}
