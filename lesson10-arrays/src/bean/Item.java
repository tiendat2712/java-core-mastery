package bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Item implements Comparable<Item> {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer storeId;
    private LocalDateTime createdAt;

    public Item() {
    }

    public Item(Integer id, String name, BigDecimal price, Integer storeId, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.storeId = storeId;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", price=" + price + ", storeId=" + storeId + ", createdAt="
                + createdAt + "]\n";
    }

    @Override
    public int compareTo(Item o) {
        // khi gọi hàm Arrays.sort(Item[] items)
        // lúc compile --> gọi hàm compareTo từ Comparable
        // lúc runtime --> gọi hàm compareTo từ Item
        Item i1 = this;
        Item i2 = o;

        // giảm dần theo price
        // return i2.getPrice().compareTo(i1.getPrice());

        // tăng dần theo id;
        return i1.getId().compareTo(i2.getId());
    }
}