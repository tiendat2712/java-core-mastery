package bean;

import enums.Category;

import java.math.BigDecimal;

/** Mutable data bean. Business validation belongs to the assignment implementation. */
public class Product {
    private String id;
    private String name;
    private Category category;
    private BigDecimal listPrice;
    private boolean active;

    public Product() {
    }

    public Product(String id, String name, Category category, BigDecimal listPrice, boolean active) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.listPrice = listPrice;
        this.active = active;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name=" + name + ", category=" + category
                + ", listPrice=" + listPrice + ", active=" + active + "}";
    }
}
