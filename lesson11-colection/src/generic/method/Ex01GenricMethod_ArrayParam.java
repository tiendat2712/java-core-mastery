package generic.method;

import java.util.Arrays;

public class Ex01GenricMethod_ArrayParam {

    public static void main(String[] args) {

        Integer[] ints = {1, 2, 3, 4, 5};
        Long[] longs = {11L, 22L, 33L, 44L, 55L};
        Double[] doubles = {1.1d, 2.2d, 3.3d, 4.4d, 5.5d};
        String[] strings = {"a", "b", "c", "d", "e"};

        generateObjects("1. Ints", ints);
        generateObjects("2. Longs", longs);
        generateObjects("3. Doubles", doubles);
        generateObjects("4. Strings", strings);

        System.out.println("========== With Generic ==========");

        generate("1. Ints", ints);
        generate("2. Longs", longs);
        generate("3. Doubles", doubles);
        generate("4. Strings", strings);

    }

    // Khi có tham số KDL x --> truyền vào KDL x hoặc con của x
    // Object[] là mảng cha của bất kỳ mảng đối tượng nào
    public static void generateObjects(String prefix, Object[] objects) {
        System.out.println(prefix + " --> " + Arrays.toString(objects) + "\n");
    }

    // để khai báo GenericType của 1 hàm --> khai báo trc ReturnType của hàm đó
    // E --> có thể truyền bất kỳ KDL đối tượng nào vào cũng được cả
    public static <E> void generate(String prefix, E[] elements) {
        System.out.println(prefix + " --> " + Arrays.toString(elements) + "\n");
    }

}
