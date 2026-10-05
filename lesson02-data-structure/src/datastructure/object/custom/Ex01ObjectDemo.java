package datastructure.object.custom;

public class Ex01ObjectDemo {

    // running:
     // debugging: break point

    public static void main(String[] args) {

        // khai báo và khới tạo giá trị cho biến KDL nguyên thủy
        int a = 12;
        char b = '?';

        a = 17;

        System.out.println("a ---> "+ a);
        System.out.println("b ---> "+ b);

        System.out.println();

        /*
           khai báo và khới tạo giá trị cho biến KDL đối tượng
           new Item()
            --> gọi hàm khởi tạo mặc định của class(KDL) Item
            --> mặc định 1 class nó sẽ có hàm khởi tạo mặc định
            --> default constructor
                + tạo ra 1 ô nhớ trên vùng nhớ heap
                + có đầy đủ thông tin tất cả các thuộc tính của class chứa nó
         */

        Item i1 = new Item(); // --> H1 --> giá trị mặc định của i1 là null
        i1.id = 2;
        i1.name = "Omo Matic";
        i1.price = 10000d;

        System.out.println("i1 1st ---> "+ i1);
        System.out.println("i1 address 1st ---> "+ i1.hashCode());

        System.out.println(" ----------------- ------------------ ");
        // tạo ô nhớ mới và gán địa chỉ của ô nhớ mới cho i1
        i1 = new Item(); // --> H2  --> i1 sẽ trỏ đến ô nhớ H2
        i1.name = "Xabi Alonso";

        System.out.println("i1 2nd ---> "+ i1);
        System.out.println("i1 address 2nd ---> "+ System.identityHashCode(i1));
        System.out.println(" ----------------- ------------------ ");

        // b1: Gọi hàm khởi tạo rỗng để khởi tạo ô nhớ ở HEAP
        Item i2 = new Item();

        // b2: Gán giá trị cho các thuộc tính của ô nhớ
        i2.id = 2;
        i2.name = "Segio Ramos";
        i2.price = 36000d;
        System.out.println("i2 1st ---> "+ i2);

        // =!: Khởi tạo ô nhớ và gán giá trị trực tiếp cho ô nhớ đó
        Item i3 = new Item(3, "Dang Phuong Nam", 36d);

        System.out.println("i3 1st ---> "+ i3);

        // Java có class gọi là cha của tất cả các KDL đối tượng ---> Object
        // Object class sẽ có 1 số hàm
        // toString, hashcode, equals, ....

        // in biến KDL đối tượng
        // mặc định gọi hàm toString có sẵn trong KDL của biến đó
        // in i1 ----> i1.toString()




    }
}
