package bean;

import java.math.BigDecimal;

/** Mutable data bean. unitPrice stores the purchase price, not the current catalog price. */
public class OrderLine {
    private String productId;
    private int quantity;
    private BigDecimal unitPrice;

    public OrderLine() {
    }

    public OrderLine(String productId, int quantity, BigDecimal unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderLine{productId=" + productId + ", quantity=" + quantity
                + ", unitPrice=" + unitPrice + "}";
    }
}
