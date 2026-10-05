package view.inheritance.cclass;

import java.math.BigDecimal;

public class TextBook extends Book {

    private BookStatus status;
    private Integer discount;

    public TextBook() {}

    public TextBook(String id, String name, BigDecimal salePrice, String publisher, BookStatus status, Integer discount) {
        super(id, name, salePrice, publisher);
        this.status = status;
        this.discount = discount;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "TextBook{" + super.toString() +
                "status=" + status +
                ", discount=" + discount + " %" +
                '}';
    }
}
