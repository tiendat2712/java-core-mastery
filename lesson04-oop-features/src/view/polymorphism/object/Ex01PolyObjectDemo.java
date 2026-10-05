package view.polymorphism.object;

public class Ex01PolyObjectDemo {

    public static void main(String[] args) {

        System.out.println("--- Shape ---");
        Shape shape = new Shape();
        shape.paint();
        shape.calS();

        System.out.println("\n--- Square ---\n");
        Square square = new Square();
        square.paint();
        square.calS();

        System.out.println("\n--- Rectangle ---\n");
        Rectangle rectangle = new Rectangle();
        rectangle.paint();
        rectangle.calS();

//        square = rectangle; --> error

        // compile: s1, s2 --> kiểu Shape
        // runtime: s1, s2 --> gọi method trong class con

        System.out.println("\n--- Polymorphism with Object ---");
        Shape s1 = new Square();
        s1.paint();
        s1.calS();

        Shape s2 = new Rectangle();
        s2.paint();
        s2.calS();

        s2 = s1;                        // lúc comppile thì s1, s2 đều là kiểu Shape --> gán qua gán về bình thường
        Shape[] shapes = {s1, s2};      // trong trường hợp thực tế là nếu HCN có dài = rộng thì trở thành hình vuông
                                        // --> thể hiện tính đa hình trong đối tượng

        /*
           Câu hỏi:
           1. Parent p = new Child(); // polymorphism with object
              Có thể lấy Child c = new Parent(); được không, vì sao ??

              Không thể, vì một object Parent không đảm bảo có đầy đủ hành vi của Child, nên Java
              không cho phép gán kiểu cha cho biến kiểu con ở compile time, nhằm đảm bảo type safety.

              Child c = new Parent();
              c.childMethod(); // ????
              ❓ Parent có childMethod() không?
              ➡️ Không

              👉 Nếu cho phép thì chương trình sẽ có khả năng crash ở runtime.
              📌 Java chọn fail sớm ở compile time để đảm bảo type safety.

             **) Biến KDL cha có thể nhận giá trị KDL chính nó hoặc KDL con

            2. Tại sao mình không khai báo trực tiếp
		    - Parent p = new Parent();
		    - Child c = new Child();
		    mà phải sử dụng đa hình trong đối tượng:
		    - Parent p1 = new ChildX(); ?
		    - Parent p2 = new ChildY();

		    ------------------ Trả lời: -------------------
		    --> Dễ dáng ép kiểu qua về các biến trong phạm vi KDL cha con
		    --> Hỗ trợ tạo danh sách(mảng) các phần tử trong phạm vi cha con
		        vd:
		        Cho danh sách các hình (vuông, tròn, HCN,..)
		        --> Shape[] shapes = {hình,vuông, tròn, HCN,.........};
		    --> Hỗ trợ hàm có KDL cha -> có thể truyền tham số KDL cha, con
		        vd:

		        main method() {
		           log(rectangle);
		           log(square);
		           .........
		        }

		        // Shape shape = shape || rectangle || square
		        void log(Shape shape) {
		            sout(shape);
		        }
		        --> hỗ trợ factory pattern

         */

    }
}
