package view.inheritance.cclass;

import java.math.BigDecimal;

public class Book {

    private String id;
    private String name;
    private BigDecimal salePrice;
    private String publisher;

    public Book() {
    }

    public Book(String id, String name, BigDecimal salePrice, String publisher) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salePrice=" + salePrice +
                ", publisher='" + publisher + '\'' +
                ", ";
    }
}
