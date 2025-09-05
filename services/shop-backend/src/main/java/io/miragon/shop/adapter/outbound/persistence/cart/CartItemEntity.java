package io.miragon.shop.adapter.outbound.persistence.cart;

import jakarta.persistence.*;
import java.util.UUID;

@Entity(name = "cart_items")
public class CartItemEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private CartEntity cart;

    @Column(name = "article_id", nullable = false)
    private UUID articleId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_per_item", nullable = false)
    private Double pricePerItem;

    protected CartItemEntity() {}

    public CartItemEntity(UUID id, CartEntity cart, UUID articleId, Integer quantity, Double pricePerItem) {
        this.id = id;
        this.cart = cart;
        this.articleId = articleId;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public CartEntity getCart() { return cart; }
    public void setCart(CartEntity cart) { this.cart = cart; }

    public UUID getArticleId() { return articleId; }
    public void setArticleId(UUID articleId) { this.articleId = articleId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPricePerItem() { return pricePerItem; }
    public void setPricePerItem(Double pricePerItem) { this.pricePerItem = pricePerItem; }
}
