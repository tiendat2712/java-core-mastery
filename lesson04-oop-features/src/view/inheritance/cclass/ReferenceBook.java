package view.inheritance.cclass;

import java.math.BigDecimal;

public class ReferenceBook extends Book{

    private BigDecimal tax;

    // Khi gọi hàm khởi tạo KDL con
    // Yêu cầu phải gọi đến 1 hàm khởi tạo của cha
    // Mặc định gọi super() --> nên trong KDL cha nên có 1 hàm khởi tạo rỗng

    public ReferenceBook() {}

    // super: đại diện cho đối tượng KDL cha => chỉ trỏ đến được tất cả các hàm ở KDL cha --> super.
    // super(...): gọi hàm khởi tạo của cha
    // this: đại diện cho đối tượng KDL hiện tại => trỏ đến tất cả các hàm ở KDL cha và hiện tại

//    ReferenceBook r1 = new ReferenceBook("b1", "name1", "p1", bd(3));
//    public ReferenceBook(String id, String name, String publisher, BigDecimal tax) {
//        this.setId(id);
//        this.setName(name);
//        this.setPublisher(publisher);
//        this.setTax(tax);
//    }

    public ReferenceBook(String id, String name, BigDecimal salePrice, String publisher, BigDecimal tax) {
        super(id, name, salePrice, publisher);
        this.tax = tax;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "ReferenceBook{" + super.toString() +
                "tax=" + tax +
                '}';
    }
}
