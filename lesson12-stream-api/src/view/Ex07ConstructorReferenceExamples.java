package view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex07ConstructorReferenceExamples {

    public static void main(String[] args) {



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
