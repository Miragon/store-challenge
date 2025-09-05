package io.miragon.shop.application.service.cart;

import io.miragon.shop.application.port.inbound.RemoveFromCartUseCase;
import io.miragon.shop.application.port.outbound.CartRepository;
import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RemoveFromCartService implements RemoveFromCartUseCase {

    private static final Logger log = LoggerFactory.getLogger(RemoveFromCartService.class);

    private final CartRepository cartRepository;

    public RemoveFromCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart removeFromCart(UserId userId, ArticleId articleId) {
        Cart cart = cartRepository.loadCart(userId);
        Cart updatedCart = cart.removeItem(articleId);
        cartRepository.storeCart(updatedCart);
        log.info("Removed article {} from cart of user {}: {}", articleId, userId, updatedCart);
        return updatedCart;
    }
}
