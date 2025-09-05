package io.miragon.shop.domain.cart;

import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.shared.Price;
import io.miragon.shop.domain.shared.Quantity;
import io.miragon.shop.domain.shared.UserId;

public class CartItem {
    private final CartItemId id;
    private final UserId userId;
    private final ArticleId articleId;
    private final Quantity quantity;
    private final Price pricePerItem;

    public CartItem(CartItemId id, UserId userId, ArticleId articleId, Quantity quantity, Price pricePerItem) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public Price totalPrice() { return new Price(pricePerItem.getValue() * quantity.getValue()); }

    public CartItemId getId() { return id; }
    public UserId getUserId() { return userId; }
    public ArticleId getArticleId() { return articleId; }
    public Quantity getQuantity() { return quantity; }
    public Price getPricePerItem() { return pricePerItem; }

    public static CartItem fromArticle(Article article, UserId userId) {
        return new CartItem(new CartItemId(), userId, article.getId(), new Quantity(1), article.getPrice());
    }
}
