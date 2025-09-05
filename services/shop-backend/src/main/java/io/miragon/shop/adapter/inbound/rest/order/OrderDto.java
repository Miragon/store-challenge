package io.miragon.shop.adapter.inbound.rest.order;

import io.miragon.shop.domain.order.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderDto {
    private UUID id;
    private String userId;
    private List<OrderItemDto> items;
    private String status;
    private LocalDateTime orderDate;
    private Double totalAmount;

    public OrderDto() {}

    public OrderDto(UUID id, String userId, List<OrderItemDto> items, String status, LocalDateTime orderDate, Double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.status = status;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public static OrderDto fromDomain(Order order) {
        return new OrderDto(
                order.getId().getValue(),
                order.getUserId().getValue(),
                order.getItems().stream().map(OrderItemDto::fromDomain).toList(),
                order.getStatus().name(),
                order.getOrderDate(),
                order.getTotalAmount().getValue()
        );
    }

    public UUID getId() { return id; }
    public String getUserId() { return userId; }
    public List<OrderItemDto> getItems() { return items; }
    public String getStatus() { return status; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public Double getTotalAmount() { return totalAmount; }

    public void setId(UUID id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setItems(List<OrderItemDto> items) { this.items = items; }
    public void setStatus(String status) { this.status = status; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
}
