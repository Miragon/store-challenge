package io.miragon.shop.domain.article;

import io.miragon.shop.domain.shared.ValueObject;

public class ArticleName extends ValueObject<String> {
    public ArticleName(String value) {
        super(value);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Article name cannot be blank");
        }
    }
}
