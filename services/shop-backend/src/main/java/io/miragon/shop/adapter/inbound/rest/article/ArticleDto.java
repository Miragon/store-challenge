package io.miragon.shop.adapter.inbound.rest.article;

import io.miragon.shop.domain.article.Article;

import java.util.UUID;

public class ArticleDto {
    private UUID id;
    private String name;
    private String description;
    private Double price;

    public ArticleDto() {}

    public ArticleDto(UUID id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static ArticleDto fromDomain(Article article) {
        return new ArticleDto(
                article.getId().getValue(),
                article.getName().getValue(),
                article.getDescription().getValue(),
                article.getPrice().getValue()
        );
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }

    public void setId(UUID id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(Double price) { this.price = price; }
}
