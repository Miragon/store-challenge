package io.miragon.shop.adapter.outbound.persistence.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity(name = "order_items")
public class OrderItemEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @Column(name = "article_id", nullable = false)
    private UUID articleId;

    @Column(name = "article_name", nullable = false)
    private String articleName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_per_item", nullable = false)
    private Double pricePerItem;

    protected OrderItemEntity() {}

    public OrderItemEntity(UUID id, UUID orderId, UUID articleId, String articleName, Integer quantity, Double pricePerItem) {
        this.id = id;
        this.orderId = orderId;
        this.articleId = articleId;
        this.articleName = articleName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getOrderId() { return orderId; }
    public void setOrderId(UUID orderId) { this.orderId = orderId; }

    public UUID getArticleId() { return articleId; }
    public void setArticleId(UUID articleId) { this.articleId = articleId; }

    public String getArticleName() { return articleName; }
    public void setArticleName(String articleName) { this.articleName = articleName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPricePerItem() { return pricePerItem; }
    public void setPricePerItem(Double pricePerItem) { this.pricePerItem = pricePerItem; }
}
