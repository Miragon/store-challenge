package io.miragon.shop.domain.cart;

import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.shared.Price;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final Logger log = LoggerFactory.getLogger(Cart.class);

    private final UserId userId;
    private final List<CartItem> items;

    public Cart(UserId userId, List<CartItem> items) {
        this.userId = userId;
        this.items = new ArrayList<>(items);
    }

    public Cart addItem(Article article) {
        List<CartItem> newItems = new ArrayList<>(items);
        CartItem newItem = CartItem.fromArticle(article, userId);
        newItems.add(newItem);
        return new Cart(userId, newItems);
    }

    public Cart removeItem(ArticleId articleId) {
        CartItem existing = items.stream().filter(i -> i.getArticleId().equals(articleId)).findFirst().orElse(null);
        if (existing == null) {
            log.info("No item with id {} is on the cart. Remaining cart unchanged", articleId);
            return this;
        }
        List<CartItem> newItems = new ArrayList<>(items);
        newItems.remove(existing);
        return new Cart(userId, newItems);
    }

    public Price totalPrice() {
        double sum = items.stream().mapToDouble(i -> i.totalPrice().getValue()).sum();
        return new Price(sum);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public UserId getUserId() {
        return userId;
    }

    public List<CartItem> getItems() {
        return List.copyOf(items);
    }
}
