package io.miragon.shop.application.port.outbound;

import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleId;

import java.util.List;

public interface ArticleRepository {
    List<Article> loadAll();
    List<Article> loadByIds(List<ArticleId> articleIds);
    void save(Article article);
    Article findById(ArticleId articleId);
}
