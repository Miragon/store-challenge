package io.miragon.shop.application.port.inbound;

import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.shared.UserId;

public interface RemoveFromCartUseCase {
    Cart removeFromCart(UserId userId, ArticleId articleId);
}
