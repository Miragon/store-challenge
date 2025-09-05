package io.miragon.shop.adapter.inbound.rest.cart;

import io.miragon.shop.domain.cart.CartItem;

import java.util.UUID;

public class CartItemDto {
    private UUID articleId;
    private Integer quantity;
    private Double pricePerItem;
    private Double totalPrice;

    public CartItemDto() {}

    public CartItemDto(UUID articleId, Integer quantity, Double pricePerItem, Double totalPrice) {
        this.articleId = articleId;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
        this.totalPrice = totalPrice;
    }

    public static CartItemDto fromDomain(CartItem cartItem) {
        return new CartItemDto(
                cartItem.getArticleId().getValue(),
                cartItem.getQuantity().getValue(),
                cartItem.getPricePerItem().getValue(),
                cartItem.totalPrice().getValue()
        );
    }

    public UUID getArticleId() { return articleId; }
    public Integer getQuantity() { return quantity; }
    public Double getPricePerItem() { return pricePerItem; }
    public Double getTotalPrice() { return totalPrice; }

    public void setArticleId(UUID articleId) { this.articleId = articleId; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPricePerItem(Double pricePerItem) { this.pricePerItem = pricePerItem; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}
