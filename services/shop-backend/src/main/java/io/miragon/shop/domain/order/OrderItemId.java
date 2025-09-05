package io.miragon.shop.domain.order;

import io.miragon.shop.domain.shared.ValueObject;

import java.util.UUID;

public class OrderItemId extends ValueObject<UUID> {
    public OrderItemId() { super(UUID.randomUUID()); }
    public OrderItemId(UUID value) { super(value); }
}
