package io.miragon.shop.domain.order;

import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.article.ArticleName;
import io.miragon.shop.domain.shared.Price;
import io.miragon.shop.domain.shared.Quantity;

public class OrderItem {
    private final OrderItemId id;
    private final ArticleId articleId;
    private final ArticleName articleName;
    private final Quantity quantity;
    private final Price pricePerItem;

    public OrderItem(OrderItemId id, ArticleId articleId, ArticleName articleName, Quantity quantity, Price pricePerItem) {
        this.id = id;
        this.articleId = articleId;
        this.articleName = articleName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public Price totalPrice() { return new Price(pricePerItem.getValue() * quantity.getValue()); }

    public OrderItemId getId() { return id; }
    public ArticleId getArticleId() { return articleId; }
    public ArticleName getArticleName() { return articleName; }
    public Quantity getQuantity() { return quantity; }
    public Price getPricePerItem() { return pricePerItem; }
}
