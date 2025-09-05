package io.miragon.shop.domain.article;

import io.miragon.shop.domain.shared.Price;

public class Article {
    private final ArticleId id;
    private final ArticleName name;
    private final ArticleDescription description;
    private final Price price;

    public Article(ArticleId id, ArticleName name, ArticleDescription description, Price price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ArticleId getId() { return id; }
    public ArticleName getName() { return name; }
    public ArticleDescription getDescription() { return description; }
    public Price getPrice() { return price; }
}
