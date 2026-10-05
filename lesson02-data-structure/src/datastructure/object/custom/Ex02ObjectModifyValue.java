package datastructure.object.custom;

public class Ex02ObjectModifyValue {

    public static void main(String[] args) {

        // garbage collector
        /*
          Trong Java, toán tử gán =
              ---> 100% gán ở STACK <gán ô nhớ, không gán giá trị (object)>
                ---> i1 = i2 ===> cả 2 biến i1, i2 đều trỏ đến cùng 1 ô nhớ ở HEAP
         */

        Item i1 = new Item(1, "A", 11d);
        Item i2 = new Item(2, "B", 22d);

        System.out.println("i1 1st ---> "+ i1.hashCode()); //1791741888
        System.out.println("i2 1st ---> "+ i2.hashCode()); //883049899
        System.out.println(" ------------- -------------- --------------");

        i1 = i2;
        System.out.println("i1 2nd ---> "+ i1.hashCode()); //883049899
        System.out.println("i2 2nd ---> "+ i2.hashCode()); //883049899

        i1.name = "Z";

        System.out.println("i1 ---> "+ i1); // id=?, name=?, price=?
        System.out.println("i2 ---> "+ i2); // id=?, name=?, price=?

    }
}
