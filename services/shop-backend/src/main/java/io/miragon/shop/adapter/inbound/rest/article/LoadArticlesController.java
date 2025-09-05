package io.miragon.shop.adapter.inbound.rest.article;

import io.miragon.shop.application.port.inbound.ArticleQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class LoadArticlesController {

    private static final Logger log = LoggerFactory.getLogger(LoadArticlesController.class);

    private final ArticleQuery query;

    public LoadArticlesController(ArticleQuery query) {
        this.query = query;
    }

    @GetMapping
    public List<ArticleDto> loadArticles() {
        log.info("Retrieving all articles");
        var articles = query.loadAll();
        return articles.stream().map(ArticleDto::fromDomain).toList();
    }
}
