package view.inheritance.iinterface;

public class StaticInterfaceeDemo {

        public static void main(String[] args) {

            Shape circle = new Circle(5);

            // ❌ KHÔNG gọi qua object
            // circle.isValidArea(10);

            // ✅ Gọi qua interface
            boolean ok = Shape.isValidArea(10);
            System.out.println(ok);

            // ✅ Static helper gắn với abstraction
            Shape.printInfo(circle);

            // ✅ Factory method
            Shape rect = Shape.rectangle(4, 5);
            Shape.printInfo(rect);
        }

}
