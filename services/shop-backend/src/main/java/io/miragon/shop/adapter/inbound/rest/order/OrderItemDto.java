package io.miragon.shop.adapter.inbound.rest.order;

import io.miragon.shop.domain.order.OrderItem;

import java.util.UUID;

public class OrderItemDto {
    private UUID articleId;
    private String articleName;
    private Integer quantity;
    private Double pricePerItem;
    private Double totalPrice;

    public OrderItemDto() {}

    public OrderItemDto(UUID articleId, String articleName, Integer quantity, Double pricePerItem, Double totalPrice) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
        this.totalPrice = totalPrice;
    }

    public static OrderItemDto fromDomain(OrderItem orderItem) {
        return new OrderItemDto(
                orderItem.getArticleId().getValue(),
                orderItem.getArticleName().getValue(),
                orderItem.getQuantity().getValue(),
                orderItem.getPricePerItem().getValue(),
                orderItem.totalPrice().getValue()
        );
    }

    public UUID getArticleId() { return articleId; }
    public String getArticleName() { return articleName; }
    public Integer getQuantity() { return quantity; }
    public Double getPricePerItem() { return pricePerItem; }
    public Double getTotalPrice() { return totalPrice; }

    public void setArticleId(UUID articleId) { this.articleId = articleId; }
    public void setArticleName(String articleName) { this.articleName = articleName; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPricePerItem(Double pricePerItem) { this.pricePerItem = pricePerItem; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}
