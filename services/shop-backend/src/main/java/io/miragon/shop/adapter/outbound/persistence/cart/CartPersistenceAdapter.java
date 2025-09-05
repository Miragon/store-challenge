package io.miragon.shop.adapter.outbound.persistence.cart;

import io.miragon.shop.application.port.outbound.CartRepository;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.shared.UserId;
import org.springframework.stereotype.Component;

@Component
public class CartPersistenceAdapter implements CartRepository {

    private final CartJpaRepository cartJpaRepository;

    public CartPersistenceAdapter(CartJpaRepository cartJpaRepository) {
        this.cartJpaRepository = cartJpaRepository;
    }

    @Override
    public Cart loadCart(UserId userId) {
        var entity = cartJpaRepository.findByUserId(userId.getValue());
        return entity != null ? CartMapper.toDomain(entity) : new Cart(userId, java.util.List.of());
    }

    @Override
    public void storeCart(Cart cart) {
        var entity = CartMapper.toEntity(cart);
        cartJpaRepository.save(entity);
    }

    @Override
    public void deleteCart(UserId userId) {
        cartJpaRepository.deleteById(userId.getValue());
    }
}
