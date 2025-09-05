package io.miragon.shop.application.service.cart;

import io.miragon.shop.application.port.inbound.CartQuery;
import io.miragon.shop.application.port.outbound.CartRepository;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.shared.UserId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetCartByUserService implements CartQuery {

    private final CartRepository cartRepository;

    public GetCartByUserService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCart(UserId userId) {
        return cartRepository.loadCart(userId);
    }
}
