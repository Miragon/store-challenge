package io.miragon.shop.application.service.cart;

import io.miragon.shop.application.port.inbound.AddToCartUseCase;
import io.miragon.shop.application.port.outbound.ArticleRepository;
import io.miragon.shop.application.port.outbound.CartRepository;
import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddToCartService implements AddToCartUseCase {

    private static final Logger log = LoggerFactory.getLogger(AddToCartService.class);

    private final CartRepository cartRepository;
    private final ArticleRepository articleRepository;

    public AddToCartService(CartRepository cartRepository, ArticleRepository articleRepository) {
        this.cartRepository = cartRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public Cart addToCart(UserId userId, ArticleId articleId) {
        Article article = articleRepository.findById(articleId);
        if (article == null) {
            throw new IllegalArgumentException("Article not found: " + articleId);
        }
        Cart cart = cartRepository.loadCart(userId);
        Cart updatedCart = cart.addItem(article);
        cartRepository.storeCart(updatedCart);
        log.info("Added article {} to cart of user {}: {}", articleId, userId, updatedCart);
        return updatedCart;
    }
}
