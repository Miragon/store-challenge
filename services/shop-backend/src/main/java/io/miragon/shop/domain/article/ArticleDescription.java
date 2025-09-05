package io.miragon.shop.domain.article;

import io.miragon.shop.domain.shared.ValueObject;

public class ArticleDescription extends ValueObject<String> {
    public ArticleDescription(String value) {
        super(value);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Article description cannot be blank");
        }
    }
}
