package io.miragon.shop.adapter.outbound.persistence.order;

import io.miragon.shop.domain.order.OrderStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderItemEntity> items = new ArrayList<>();

    protected OrderEntity() {}

    public OrderEntity(UUID id, String userId, OrderStatus status, LocalDateTime orderDate, Double totalAmount, List<OrderItemEntity> items) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.items = items != null ? items : new ArrayList<>();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public List<OrderItemEntity> getItems() { return items; }
    public void setItems(List<OrderItemEntity> items) { this.items = items; }
}
