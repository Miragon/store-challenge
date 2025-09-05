package io.miragon.shop.application.port.inbound;

import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleId;

import java.util.List;

public interface ArticleQuery {
    Article load(ArticleId id);
    List<Article> loadAll();
}
