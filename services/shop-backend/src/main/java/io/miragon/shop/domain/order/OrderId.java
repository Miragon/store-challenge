package io.miragon.shop.domain.order;

import io.miragon.shop.domain.shared.ValueObject;

import java.util.UUID;

public class OrderId extends ValueObject<UUID> {
    public OrderId() { super(UUID.randomUUID()); }
    public OrderId(UUID value) { super(value); }
}
