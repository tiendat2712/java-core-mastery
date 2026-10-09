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

    // Hàm phụ trợ kiểm tra số (hỗ trợ số nguyên, có thể mở rộng số thực)
    private static boolean isNumber(String s) {
        return s != null && s.matches("-?\\d+");
    }

    // Hàm phụ trợ kiểm tra chuỗi special (không phân biệt hoa/thường)
    private static boolean isSpecial(String s) {
        return s != null && s.equalsIgnoreCase("special");
    }

    public static void main(String[] args) {
        String[] sequences = { "-2", "-6", "10", null, "4", "41", "8", null, "special", "a", "c", "b", "xx" };

        // ==========================================
        // 1. SẮP XẾP TĂNG DẦN
        // ==========================================
        Arrays.sort(sequences, (i1, i2) -> {
            // Xử lý null (null luôn ở cuối trong tăng dần)
            if (i1 == null && i2 == null) return 0;
            if (i1 == null) return 1;
            if (i2 == null) return -1;

            boolean spec1 = isSpecial(i1);
            boolean spec2 = isSpecial(i2);
            boolean num1 = isNumber(i1);
            boolean num2 = isNumber(i2);

            // "Special" ưu tiên đứng đầu tiên
            if (spec1 && !spec2) return -1;
            if (!spec1 && spec2) return 1;
            if (spec1 && spec2) return 0;

            // Số đứng trước chuỗi chữ cái thường
            if (num1 && !num2) return -1;
            if (!num1 && num2) return 1;

            // Cả hai đều là số
            if (num1 && num2) {
                int n1 = Integer.parseInt(i1);
                int n2 = Integer.parseInt(i2);
                // Số âm đứng trước số dương
                if (n1 < 0 && n2 >= 0) return -1;
                if (n1 >= 0 && n2 < 0) return 1;
                // Cùng âm hoặc cùng dương: tăng dần theo giá trị số
                return Integer.compare(n1, n2);
            }

            // Cả hai đều là chuỗi chữ cái thường: sắp xếp theo bảng chữ cái (Alphabet)
            return i1.compareTo(i2);
        });

        System.out.println("Tăng dần: " + Arrays.toString(sequences));


        // ==========================================
        // 2. SẮP XẾP GIẢM DẦN
        // ==========================================
        // Khởi tạo lại mảng mẫu
        String[] sequencesDesc = { "-2", "-6", "10", null, "4", "41", "8", null, "special", "a", "c", "b", "xx" };

        Arrays.sort(sequencesDesc, (i1, i2) -> {
            // Xử lý null (null luôn ở đầu trong giảm dần theo ví dụ đề bài)
            if (i1 == null && i2 == null) return 0;
            if (i1 == null) return -1;
            if (i2 == null) return 1;

            boolean spec1 = isSpecial(i1);
            boolean spec2 = isSpecial(i2);
            boolean num1 = isNumber(i1);
            boolean num2 = isNumber(i2);

            // "Special" đứng cuối cùng trong giảm dần
            if (spec1 && !spec2) return 1;
            if (!spec1 && spec2) return -1;
            if (spec1 && spec2) return 0;

            // Chuỗi chữ cái đứng trước số trong giảm dần
            if (!num1 && num2) return -1;
            if (num1 && !num2) return 1;

            // Cả hai đều là chuỗi chữ cái thường: giảm dần (Z -> A)
            if (!num1 && !num2) {
                return i2.compareTo(i1);
            }

            // Cả hai đều là số: số dương lớn trước, sau đó đến số âm lớn dần (vd: 10, 8, 4, -2, -6)
            int n1 = Integer.parseInt(i1);
            int n2 = Integer.parseInt(i2);

            // Số dương ưu tiên đứng trước số âm trong chiều giảm dần
            if (n1 >= 0 && n2 < 0) return -1;
            if (n1 < 0 && n2 >= 0) return 1;

            // Cùng dương hoặc cùng âm: giảm dần theo giá trị (số lớn hơn đứng trước)
            return Integer.compare(n2, n1);
        });

        System.out.println("Giảm dần: " + Arrays.toString(sequencesDesc));
    }

}
