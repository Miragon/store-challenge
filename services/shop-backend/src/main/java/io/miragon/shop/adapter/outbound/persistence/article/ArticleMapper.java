package io.miragon.shop.adapter.outbound.persistence.article;

import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleDescription;
import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.article.ArticleName;
import io.miragon.shop.domain.shared.Price;

public final class ArticleMapper {
    private ArticleMapper() {}

    public static Article toDomain(ArticleEntity e) {
        return new Article(
                new ArticleId(e.getId()),
                new ArticleName(e.getName()),
                new ArticleDescription(e.getDescription()),
                new Price(e.getPrice())
        );
    }

    public static ArticleEntity toEntity(Article a) {
        return new ArticleEntity(
                a.getId().getValue(),
                a.getName().getValue(),
                a.getDescription().getValue(),
                a.getPrice().getValue()
        );
    }
}
