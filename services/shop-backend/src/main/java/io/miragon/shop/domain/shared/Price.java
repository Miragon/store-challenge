package io.miragon.shop.domain.shared;

public class Price extends ValueObject<Double> {
    public Price(Double value) {
        super(value);
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Article price must be greater than zero");
        }
    }
}
