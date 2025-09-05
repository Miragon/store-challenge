package io.miragon.shop.application.port.inbound;

import io.miragon.shop.domain.article.Article;

public interface ImportArticleUseCase {
    void importArticle(Article article);
}
