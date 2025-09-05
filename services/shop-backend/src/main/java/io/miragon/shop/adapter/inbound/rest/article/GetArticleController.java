package io.miragon.shop.adapter.inbound.rest.article;

import io.miragon.shop.application.port.inbound.ArticleQuery;
import io.miragon.shop.domain.article.ArticleId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
public class GetArticleController {

    private static final Logger log = LoggerFactory.getLogger(GetArticleController.class);

    private final ArticleQuery query;

    public GetArticleController(ArticleQuery query) {
        this.query = query;
    }

    @GetMapping("/{id}")
    public ArticleDto getArticle(@PathVariable UUID id) {
        log.info("Retrieving article with id: {}", id);
        var article = query.load(new ArticleId(id));
        return ArticleDto.fromDomain(article);
    }
}
