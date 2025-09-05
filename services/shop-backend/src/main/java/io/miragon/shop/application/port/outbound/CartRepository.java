package io.miragon.shop.application.port.outbound;

import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.shared.UserId;

public interface CartRepository {
    Cart loadCart(UserId userId);
    void storeCart(Cart cart);
    void deleteCart(UserId userId);
}
