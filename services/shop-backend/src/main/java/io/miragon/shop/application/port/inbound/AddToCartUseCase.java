package io.miragon.shop.application.port.inbound;

import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.shared.UserId;

public interface AddToCartUseCase {
    Cart addToCart(UserId userId, ArticleId articleId);
}
