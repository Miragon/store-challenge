package io.miragon.shop.application.service.article;

import io.miragon.shop.application.port.inbound.ArticleQuery;
import io.miragon.shop.application.port.outbound.ArticleRepository;
import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LoadArticlesService implements ArticleQuery {

    private final ArticleRepository repository;

    public LoadArticlesService(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Article> loadAll() {
        return repository.loadAll();
    }

    @Override
    public Article load(ArticleId id) {
        Article article = repository.findById(id);
        if (article == null) {
            throw new IllegalArgumentException("Article with id " + id.getValue() + " not found");
        }
        return article;
    }
}
