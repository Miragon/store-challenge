package io.miragon.shop.domain.cart;

import io.miragon.shop.domain.shared.ValueObject;

import java.util.UUID;

public class CartItemId extends ValueObject<UUID> {
    public CartItemId() { super(UUID.randomUUID()); }
    public CartItemId(UUID value) { super(value); }
}
