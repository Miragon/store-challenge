package io.miragon.shop.domain.article;

import io.miragon.shop.domain.shared.ValueObject;

import java.util.UUID;

public class ArticleId extends ValueObject<UUID> {
    public ArticleId() { super(UUID.randomUUID()); }
    public ArticleId(UUID value) { super(value); }
    public ArticleId(String uuid) { super(UUID.fromString(uuid)); }
}
