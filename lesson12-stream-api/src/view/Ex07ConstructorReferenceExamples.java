package view;

import common.BuFunction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex07ConstructorReferenceExamples {

    public static void main(String[] args) {

        // Dạng 1: constructor reference cho hàm khởi tạo rỗng

        // constructor reference with 0,1,2,3,4...n params

        // có hàm nào, có tham số là Supplier<T>, cần truyền supplier cho bất kì đối tượng nào
        // --> khởi tạo supplier để tạo ra đối tượng cho TestCon
        Supplier<TestCon> supplier = () -> new TestCon();
        System.out.println("supplier --> " + supplier.get());

        Supplier<TestCon> supplier1 = TestCon::new;
        System.out.println("supplier1 --> " + supplier1.get());

        System.out.println("\n");

        // Dạng 2: constructor reference cho hàm khởi tạo có 2 tham số
//        (a1, a2) -> new TestCon(a1, a2); --> BiFunction
        BiFunction<Integer, String, TestCon> biFunction = (a1, a2) -> new TestCon(a1, a2);
        System.out.println("biFunction --> " + biFunction.apply(1, "Test BiFunction interface"));

        BiFunction<Integer, String, TestCon> biFunction1 = TestCon::new;
        // type inference --> dựa vào vế bên trái để xác định gọi hàm constructor nào
        System.out.println("biFunction --> " + biFunction.apply(2, "Test Constructor Reference"));

        System.out.println("\n");

        // Dạng 3: constructor reference cho hàm khởi tạo có 1 tham số
        Function<BigDecimal, TestCon> function = a1 -> new TestCon(a1);
        System.out.println("function --> " + function.apply(BigDecimal.valueOf(100)));

        Function<BigDecimal, TestCon> function1 = TestCon::new;
        System.out.println("function1 --> " + function1.apply(BigDecimal.valueOf(200)));

        System.out.println("\n");

        // Dạng 4: constructor reference cho hàm khởi tạo có 4 tham số
        BuFunction<Integer, String, LocalDate, BigDecimal, TestCon> buFunction
                = (a1, a2, a3, a4) -> new TestCon(a1, a2, a3, a4);
        buFunction = Ex07ConstructorReferenceExamples::test;
        buFunction = TestCon::new;
        System.out.println("buFunction --> " + buFunction.apply(1, "Siuuu", LocalDate.now(), BigDecimal.valueOf(350)));

        BuFunction<Integer, String, LocalDate, BigDecimal, TestCon> buFunction1
                = TestCon::new;
        System.out.println("buFunction1 --> " + buFunction1.apply(2, "Meoooo", LocalDate.now(), BigDecimal.valueOf(300)));

        System.out.println("\n");

        // Supplier(T)         --> ()     -> T
        // Function<T, R>      --> T      -> R
        // BiFunction<T, U, R> --> (T, U) -> R

        // Từ 3 tham số --> phải tự custom Functional Interface
        // ---> chuyển sang dùng static method reference
        Function<TestCon, TestCon> ftc = TestCon::convert;
        System.out.println("ftc --> " + ftc.apply(new TestCon(3, "KKKK", LocalDate.now(), BigDecimal.valueOf(185))));

        System.out.println("\n");

        BiFunction<TestCon, TestCon, TestCon> bfz = TestCon::new;
        System.out.println("bfz --> " + bfz.apply(
                new TestCon(4, "Junior", LocalDate.now(), BigDecimal.valueOf(185)),
                new TestCon(5, "Maderla", LocalDate.now(), BigDecimal.valueOf(124))
        ));






    }

    public static TestCon test(Integer a1, String a2, LocalDate a3, BigDecimal a4) {
        return new TestCon(a1, a2, a3, a4);
    }

    static class TestCon {
        private Integer a1;
        private String a2;
        private LocalDate a3;
        private BigDecimal a4;

        public TestCon() {
        }

        public TestCon(BigDecimal a4) {
            this.a4 = a4;
        }

        public TestCon(Integer a1, String a2) {
            this.a1 = a1;
            this.a2 = a2;
        }

        public TestCon(LocalDate a3, BigDecimal a4) {
            this.a3 = a3;
            this.a4 = a4;
        }

        public TestCon(Integer a1, String a2, LocalDate a3, BigDecimal a4) {
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
            this.a4 = a4;
        }

        public TestCon(TestCon tc1, TestCon tc2) {
            this.a1 = tc1.a1;
            this.a2 = tc1.a2;
            this.a3 = tc2.a3;
            this.a4 = tc2.a4;
        }

        public TestCon(String line) {
            String[] tokens = line.split(", ");
            if (tokens.length == 4) {
                this.a1 = Integer.parseInt(tokens[0]);
                this.a2 = tokens[1];
                this.a3 = LocalDate.parse(tokens[2], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                this.a4 = new BigDecimal(tokens[3]);
            }
        }

        public static TestCon transfer(String line) {
            String[] tokens = line.split(", ");
            TestCon tc = new TestCon();
            if (tokens.length == 4) {
                Integer a1 = Integer.parseInt(tokens[0]);
                String a2 = tokens[1];
                LocalDate a3 = LocalDate.parse(tokens[2], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                BigDecimal a4 = new BigDecimal(tokens[3]);
                tc = new TestCon(a1, a2, a3, a4);
            }
            return tc;
        }

        public static TestCon convert(TestCon source) {
            return new TestCon(source.a1, source.a2, source.a3, source.a4);
        }

        public Integer getA1() {
            return a1;
        }

        public void setA1(Integer a1) {
            this.a1 = a1;
        }

        public String getA2() {
            return a2;
        }

        public void setA2(String a2) {
            this.a2 = a2;
        }

        public LocalDate getA3() {
            return a3;
        }

        public void setA3(LocalDate a3) {
            this.a3 = a3;
        }

        public BigDecimal getA4() {
            return a4;
        }

        public void setA4(BigDecimal a4) {
            this.a4 = a4;
        }

        @Override
        public String toString() {
            return "TestCon [a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + ", a4=" + a4 + "]";
        }

    }

}
