package bean;

import enums.MemberTier;
import enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

/** Mutable data bean. Business validation belongs to the assignment implementation. */
public class Order {
    private String id;
    private String customerId;
    private LocalDateTime createdAt;
    private LocalDateTime deliveredAt;
    private OrderStatus status;
    private MemberTier tierAtPurchase;
    private List<OrderLine> lines;

    public Order() {
    }

    public Order(String id, String customerId, LocalDateTime createdAt, LocalDateTime deliveredAt,
                 OrderStatus status, MemberTier tierAtPurchase, List<OrderLine> lines) {
        this.id = id;
        this.customerId = customerId;
        this.createdAt = createdAt;
        this.deliveredAt = deliveredAt;
        this.status = status;
        this.tierAtPurchase = tierAtPurchase;
        this.lines = lines;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public MemberTier getTierAtPurchase() {
        return tierAtPurchase;
    }

    public void setTierAtPurchase(MemberTier tierAtPurchase) {
        this.tierAtPurchase = tierAtPurchase;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", customerId=" + customerId + ", createdAt=" + createdAt
                + ", deliveredAt=" + deliveredAt + ", status=" + status
                + ", tierAtPurchase=" + tierAtPurchase + ", lines=" + lines + "}";
    }
}
