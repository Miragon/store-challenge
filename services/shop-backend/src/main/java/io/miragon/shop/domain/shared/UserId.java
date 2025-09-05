package io.miragon.shop.domain.shared;

public class UserId extends ValueObject<String> {
    public UserId(String value) {
        super(value);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserId cannot be blank");
        }
    }
}
