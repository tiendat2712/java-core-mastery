package bean;
//pojo: plain old java object
// Car, Item, Store, Employee : Khai báo KDL cho bài toán
// Spring FrameWork : Lưu trữ những đối tượng của class vào vùng nhớ của nó
//                  : Đối tượng --> bean
// ----------------------------------------------------------------------------------------
// System = Objects
// Object = Attributes + Methods
// Class
// attributes:
//     -->   sẽ được cấp phát, gán giá trị khi tạo ra một đối tượng mới
//     -->   mối đối tượng sẽ lưu trữ các thông tin riêng của các thuộc tính

// oop: mỗi đối tượng sẽ quản lí thông tin của riêng nó
//    --> access modifier: PRIVATE
// -----------------------------------------------------------------------------------------
//thuộc tính
// + static: thuộc phạm vi của class
//         : các đối tượng của class sẽ mang cùng giá trị static
//   gọi   : Class.  or
//                      Object. (không khuyến khích)
// + non-static: thuộc phạm vi của objects
//             : mỗi đối tượng sẽ lưu trữ thông tin thuộc tính riêng

public class Car {
    public static String model; // line 20
    private String id;
    private String color;
    private double salesPrice;

    // default constructor:
    public Car() {
    }

    // constructor with full parameters:
    public Car(String id, String color, double salesPrice) {
        this.id = id;
        this.color = color;
        this.salesPrice = salesPrice;
    }

    //getter, setter
    //         ----> Để các class bên ngoài có thể truy cập, thay đổi giá trị của các thuộc tính private bên trong current class

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    //toString
    @Override
    public String toString() {
        return "Car [id=" + id + ", model=" + model + ", color=" + color + ", salesPrice=" + salesPrice + "]";
    }

}


