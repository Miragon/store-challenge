package io.miragon.shop.adapter.outbound.persistence.cart;

import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.cart.CartItem;
import io.miragon.shop.domain.cart.CartItemId;
import io.miragon.shop.domain.shared.Price;
import io.miragon.shop.domain.shared.Quantity;
import io.miragon.shop.domain.shared.UserId;

import java.util.List;
import java.util.stream.Collectors;

public final class CartMapper {
    private CartMapper() {}

    public static Cart toDomain(CartEntity e) {
        return new Cart(
                new UserId(e.getUserId()),
                e.getItems().stream().map(CartMapper::toDomain).collect(Collectors.toList())
        );
    }

    public static CartEntity toEntity(Cart cart) {
        var cartEntity = new CartEntity(cart.getUserId().getValue());
        var itemEntities = cart.getItems().stream().map(i -> toEntity(i, cartEntity)).collect(Collectors.toList());
        cartEntity.getItems().addAll(itemEntities);
        return cartEntity;
    }

    public static CartItem toDomain(CartItemEntity e) {
        return new CartItem(
                new CartItemId(e.getId()),
                new UserId(e.getCart().getUserId()),
                new ArticleId(e.getArticleId()),
                new Quantity(e.getQuantity()),
                new Price(e.getPricePerItem())
        );
    }

    public static CartItemEntity toEntity(CartItem item, CartEntity cartEntity) {
        return new CartItemEntity(
                item.getId().getValue(),
                cartEntity,
                item.getArticleId().getValue(),
                item.getQuantity().getValue(),
                item.getPricePerItem().getValue()
        );
    }
}
