package io.miragon.shop.adapter.inbound.rest.cart;

import io.miragon.shop.application.port.inbound.CartQuery;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.miragon.shop.adapter.inbound.security.SecurityConfig.USER_ID;

@RestController
@RequestMapping("/api/cart")
public class GetCartController {

    private static final Logger log = LoggerFactory.getLogger(GetCartController.class);

    private final CartQuery query;

    public GetCartController(CartQuery query) {
        this.query = query;
    }

    @GetMapping
    public ResponseEntity<CartDto> getCart() {
        var userId = new UserId(USER_ID);
        log.info("Getting cart for user: {}", userId);
        var cart = query.getCart(userId);
        return ResponseEntity.ok(CartDto.fromDomain(cart));
    }
}
