package io.miragon.shop.domain.shared;

public class Quantity extends ValueObject<Integer> {
    public Quantity(Integer value) {
        super(value);
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }
}
