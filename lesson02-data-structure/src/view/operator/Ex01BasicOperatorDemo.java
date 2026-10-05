package view.operator;

public class Ex01BasicOperatorDemo {

    public static void main(String[] args) {

        // ==============================
        // 1. Toán tử số học (Arithmetic)
        // ==============================
        int a = 10;
        int b = 3;

        System.out.println("=== Arithmetic Operators ===");
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3 (chia nguyên)
        System.out.println("a % b = " + (a % b)); // 1

        System.out.println();
        // ==============================
        // 2. Toán tử tăng / giảm (Unary)
        // ==============================
        int x = 5;

        // int a1 = x++: --> hậu tố: sử dụng giá trị hiện tại 'cho biểu thức' rồi mới tăng/giảm ++ -- sau
        // int a2 = ++x: --> tiền tố: ++ -- vào giá trị hiện tại rồi mới thực hiện 'biểu thức'
        // 'biểu thức' --> =, >, <, ==

        int d = a++;
        int e = ++b;
        System.out.println("a --> " + a); // a = 11
        System.out.println("b --> " + b); // b = 4
        System.out.println("d --> " + d); // d = 10
        System.out.println("e --> " + e); // e = 4



        System.out.println("\n=== Unary Operators ===");
        System.out.println("x++ = " + (x++)); // 5 (in trước rồi mới tăng)
        System.out.println("After x++ => x = " + x); // 6
        System.out.println("++x = " + (++x)); // 7 (tăng trước rồi in)
        System.out.println("x-- = " + (x--)); // 7
        System.out.println("--x = " + (--x)); // 5
        System.out.println("!true = " + (!true)); // false

        // ==============================
        // 3. Toán tử gán (Assignment)
        // ==============================
        int c = 10;
        // VT = VP --> Nếu VP là một biểu thức tính toán thì thực hiện xong VP trước rồi được KQ gán cho VT

        System.out.println("\n=== Assignment Operators ===");
        c += 5;  // c = c + 5
        System.out.println("c += 5 => " + c);

        c -= 3;
        System.out.println("c -= 3 => " + c);

        c *= 2;
        System.out.println("c *= 2 => " + c);

        c /= 4;
        System.out.println("c /= 4 => " + c);

        c %= 3;
        System.out.println("c %= 3 => " + c);

        // ==============================
        // 4. Toán tử so sánh (Relational)
        // ==============================
        int m = 10;
        int n = 20;

        System.out.println("\n=== Relational Operators ===");
        System.out.println("m == n : " + (m == n));
        System.out.println("m != n : " + (m != n));
        System.out.println("m > n  : " + (m > n));
        System.out.println("m < n  : " + (m < n));
        System.out.println("m >= n : " + (m >= n));
        System.out.println("m <= n : " + (m <= n));

        // ==============================
        // 5. Toán tử logic (Logical)
        // ==============================
        boolean p = true;
        boolean q = false;

        System.out.println("\n=== Logical Operators ===");
        System.out.println("p && q = " + (p && q)); // false
        System.out.println("p || q = " + (p || q)); // true
        System.out.println("!p     = " + (!p));     // false

        // ==============================
        // 6. Toán tử điều kiện (Ternary)
        // ==============================
        int age = 20;
        String result = (age >= 18) ? "Adult" : "Child";

        System.out.println("\n=== Ternary Operator ===");
        System.out.println("Age = " + age + " => " + result);

        // ==============================
        // 7. Toán tử bit (Bitwise)
        // ==============================
        int bitA = 5;  // 0101
        int bitB = 3;  // 0011

        System.out.println("\n=== Bitwise Operators ===");
        System.out.println("bitA & bitB = " + (bitA & bitB)); // 1
        System.out.println("bitA | bitB = " + (bitA | bitB)); // 7
        System.out.println("bitA ^ bitB = " + (bitA ^ bitB)); // 6
        System.out.println("~bitA       = " + (~bitA));
        System.out.println("bitA << 1   = " + (bitA << 1));  // 10
        System.out.println("bitA >> 1   = " + (bitA >> 1));  // 2

        // ==============================
        // 8. instanceof
        // ==============================
        String str = "Hello Java";

        System.out.println("\n=== instanceof Operator ===");
        System.out.println("str instanceof String = " + (str instanceof String));
        System.out.println("str instanceof Object = " + (str instanceof Object));

        // ==============================
        // 9. Toán tử nối chuỗi (+)
        // ==============================
        System.out.println("\n=== String Concatenation ===");
        System.out.println("Hello" + " " + "World");
        System.out.println("Sum = " + (a + b));
    }
}
