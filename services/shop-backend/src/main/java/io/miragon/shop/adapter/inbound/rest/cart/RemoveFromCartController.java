package io.miragon.shop.adapter.inbound.rest.cart;

import io.miragon.shop.application.port.inbound.RemoveFromCartUseCase;
import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static io.miragon.shop.adapter.inbound.security.SecurityConfig.USER_ID;

@RestController
@RequestMapping("/api/cart")
public class RemoveFromCartController {

    private static final Logger log = LoggerFactory.getLogger(RemoveFromCartController.class);

    private final RemoveFromCartUseCase removeFromCartUseCase;

    public RemoveFromCartController(RemoveFromCartUseCase removeFromCartUseCase) {
        this.removeFromCartUseCase = removeFromCartUseCase;
    }

    @DeleteMapping("/items/{articleId}")
    public ResponseEntity<CartDto> removeFromCart(
            @PathVariable UUID articleId
    ) {
        var userId = new UserId(USER_ID);
        var articleIdValue = new ArticleId(articleId);
        log.info("Removing item from cart - User: {}, Article: {}", userId, articleIdValue);
        var cart = removeFromCartUseCase.removeFromCart(userId, articleIdValue);
        return ResponseEntity.ok(CartDto.fromDomain(cart));
    }
}
