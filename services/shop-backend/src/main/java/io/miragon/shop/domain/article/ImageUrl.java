package io.miragon.shop.domain.article;

import io.miragon.shop.domain.shared.ValueObject;

public class ImageUrl extends ValueObject<String> {
    public ImageUrl(String value) {
        super(value);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Article image URL cannot be blank");
        }
    }
}
