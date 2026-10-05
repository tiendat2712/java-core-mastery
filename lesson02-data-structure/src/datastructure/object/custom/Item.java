package datastructure.object.custom;

/**
 * Tạo ra 1 kdl đối tượng
 * KDL tên là: Item
 *
 * Bao gồm 3 thông tin: Item(id, name, price)
 *
 */
public class Item {
    // attributes
    // Khi khởi tạo/gán giá trị cho một biến kiểu Item
    // Thì ô nhớ mà biến đó trỏ đến phải luôn luôn có 3 thông tin của các thuộc tính

    // biến toàn cục
    public int id;
    public String name;
    public double price;

    // method: [access modifier] [static] return_type method_name(parameters) {....}

    // constructor
    // constructor name = class name
    // no return type ----> default return current class type
    public Item() {}

    public Item(int pid, String pname, double pprice) {
        // biến cục bộ

        // this --> đại diện cho thuộc tính
        // trong class sẽ có biến this --> để biết biến/đối tượng nào đang gọi hàm của class đó

//        this.id = id;
//        this.name = name;
//        this.price = price;

        id = pid;
        name = pname;
        price = pprice;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Toán tử = ---> gán giá trị ở STACK

    // định nghĩa lại toString() của class object
    //Item i1, i2 --> KDL Item
    // i1.toString() --> H1 ---> this = i1
    // i2.toString() --> H2 ---> this = i2

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
