package datastructure.object.custom;

public class Ex03ObjectFunctionPassing {

    /*

	 Primitive Data Type:
	 	+ Dùng KDL có sẵn của JAVA: int, double, char

	 Object Data Type
	    + Dùng KDL có sẵn của JAVA: Integer, String, LocalDate
	    + Tự tạo ra KDL đối tượng: Item, Employee


	 1. Khai báo 1 số nguyên --> dùng int hay Integer, vì sao ?
	    -> dùng cái gì thì phụ thuộc vào trường hợp mình mong muốn
	    -> cái quan trọng của KDL là giúp mình lưu trữ data
	    + int: thông tin cần lưu trữ bắt buộc luôn luôn có giá trị
	    + Integer: thông tin ko bắt buộc, có thể có hoặc ko (default value = null)

	 2. Khai báo 1 chuỗi     --> sử dụng String varName = "... "    ==> Hoặc hỏi với các KDL đối tượng 'có sẵn' còn lại trong Java !!
	               hay là    -->         String varName = new String("...") ?
	    + -------> dùng String varName = "..."; -> vì nó lưu trữ giá trị ở vùng nhớ constant pool ở ô nhớ HEAP
	                                            -> nếu có giá trị trùng lặp thì gán lại địa chỉ ô nhớ của giá trị đã có trước đó
	                                            -> giúp tối ưu performance và memory
	 */

    public static void main(String[] args) {

        Item i3 = new Item(3, "C", 33d);
        System.out.println("i3 before ---> "+ i3);

        modify(i3);
        System.out.println("i3 after ---> "+ i3); // call memory in HEAP

    }

    // Item item = i3
    // --> hai ô nhớ (i3, item) ở STACK khác nhau nhưng cùng trỏ đến 1 địa chỉ ở HEAP
    // STACK: "ô nhớ"
    // HEAP: "địa chỉ"
    private static void modify(Item item) {
//        thay đổi giá trị ở HEAP
//        item.price = item.price + item.price * 0.5; // HEAP
//        Item i4 = new Item(4, "C", 33d); // STACK --> no things change in sout
//        item = i4;
        item.price = 99;
        Item i4 = new Item(4, "D", 44d);
        i4 = item;
        i4.price = 88;
        i4 = new Item();
        item.price = 77;
        item = i4;
    }
}
