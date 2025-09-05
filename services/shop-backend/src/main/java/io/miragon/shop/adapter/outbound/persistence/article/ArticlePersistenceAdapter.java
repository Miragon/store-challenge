package io.miragon.shop.adapter.outbound.persistence.article;

import io.miragon.shop.application.port.outbound.ArticleRepository;
import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ArticlePersistenceAdapter implements ArticleRepository {

    private final ArticleJpaRepository articleJpaRepository;

    public ArticlePersistenceAdapter(ArticleJpaRepository articleJpaRepository) {
        this.articleJpaRepository = articleJpaRepository;
    }

    @Override
    public List<Article> loadAll() {
        var entities = articleJpaRepository.findAll();
        return entities.stream().map(ArticleMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Article> loadByIds(List<ArticleId> articleIds) {
        var ids = articleIds.stream().map(a -> a.getValue()).collect(Collectors.toList());
        if (ids.isEmpty()) return List.of();
        var entities = articleJpaRepository.findAllByIdIn(ids);
        return entities.stream().map(ArticleMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void save(Article article) {
        articleJpaRepository.save(ArticleMapper.toEntity(article));
    }

    @Override
    public Article findById(ArticleId articleId) {
        return articleJpaRepository.findById(articleId.getValue())
                .map(ArticleMapper::toDomain)
                .orElse(null);
    }
}
