package io.miragon.shop.application.service.article;

import io.miragon.shop.application.port.inbound.ImportArticleUseCase;
import io.miragon.shop.application.port.outbound.ArticleRepository;
import io.miragon.shop.domain.article.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImportArticleService implements ImportArticleUseCase {

    private static final Logger log = LoggerFactory.getLogger(ImportArticleService.class);

    private final ArticleRepository articleRepository;

    public ImportArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void importArticle(Article article) {
        articleRepository.save(article);
        log.info("Imported article {} with name '{}' and price {}", article.getId(), article.getName(), article.getPrice());
    }
}
