package bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Item {

    private Integer id;
    private String name;
    private BigDecimal salesPrice;
    private List<Store> stores; // mặt hàng được bán trong danh sách cửa hàng

    public Item() {
    }

    public Item(Integer id, String name, BigDecimal salesPrice, List<Store> stores) {
        this.id = id;
        this.name = name;
        this.salesPrice = salesPrice;
        this.stores = stores;
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

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Item)) {
            return false;
        }

        Item that = (Item)o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", salesPrice=" + salesPrice + ", stores=" + stores + "]";
    }

}