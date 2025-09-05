package io.miragon.shop.adapter.inbound.rest.cart;

import io.miragon.shop.domain.cart.Cart;

import java.util.List;

public class CartDto {
    private List<CartItemDto> items;
    private Double totalPrice;

    public CartDto() {}

    public CartDto(List<CartItemDto> items, Double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public static CartDto fromDomain(Cart cart) {
        return new CartDto(
                cart.getItems().stream().map(CartItemDto::fromDomain).toList(),
                cart.totalPrice().getValue()
        );
    }

    public List<CartItemDto> getItems() { return items; }
    public Double getTotalPrice() { return totalPrice; }

    public void setItems(List<CartItemDto> items) { this.items = items; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}
