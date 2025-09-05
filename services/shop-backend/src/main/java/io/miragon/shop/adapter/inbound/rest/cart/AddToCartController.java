package io.miragon.shop.adapter.inbound.rest.cart;

import io.miragon.shop.application.port.inbound.AddToCartUseCase;
import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static io.miragon.shop.adapter.inbound.security.SecurityConfig.USER_ID;

@RestController
@RequestMapping("/api/cart")
public class AddToCartController {

    private static final Logger log = LoggerFactory.getLogger(AddToCartController.class);

    private final AddToCartUseCase addToCartUseCase;

    public AddToCartController(AddToCartUseCase addToCartUseCase) {
        this.addToCartUseCase = addToCartUseCase;
    }

    @PostMapping("/items")
    public ResponseEntity<CartDto> addToCart(
            @RequestBody AddToCartRequest request
    ) {
        var userId = new UserId(USER_ID);
        var articleId = new ArticleId(request.getArticleId());
        log.debug("Received request to add item {} to cart of {}", articleId, userId);
        var cart = addToCartUseCase.addToCart(userId, articleId);
        return ResponseEntity.ok(CartDto.fromDomain(cart));
    }

    public static class AddToCartRequest {
        private UUID articleId;
        public AddToCartRequest() {}
        public AddToCartRequest(UUID articleId) { this.articleId = articleId; }
        public UUID getArticleId() { return articleId; }
        public void setArticleId(UUID articleId) { this.articleId = articleId; }
    }
}
