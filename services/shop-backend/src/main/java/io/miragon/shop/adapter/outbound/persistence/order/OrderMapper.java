package io.miragon.shop.adapter.outbound.persistence.order;

import io.miragon.shop.domain.article.ArticleId;
import io.miragon.shop.domain.article.ArticleName;
import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.order.OrderId;
import io.miragon.shop.domain.order.OrderItem;
import io.miragon.shop.domain.order.OrderItemId;
import io.miragon.shop.domain.shared.Price;
import io.miragon.shop.domain.shared.Quantity;
import io.miragon.shop.domain.shared.UserId;

import java.util.List;
import java.util.stream.Collectors;

public final class OrderMapper {
    private OrderMapper() {}

    public static Order toDomain(OrderEntity e) {
        return new Order(
                new OrderId(e.getId()),
                new UserId(e.getUserId()),
                e.getItems().stream().map(OrderMapper::toDomain).collect(Collectors.toList()),
                e.getStatus(),
                e.getOrderDate(),
                new Price(e.getTotalAmount())
        );
    }

    public static OrderItem toDomain(OrderItemEntity e) {
        return new OrderItem(
                new OrderItemId(e.getId()),
                new ArticleId(e.getArticleId()),
                new ArticleName(e.getArticleName()),
                new Quantity(e.getQuantity()),
                new Price(e.getPricePerItem())
        );
    }

    public static OrderEntity toEntity(Order order) {
        List<OrderItemEntity> items = order.getItems().stream()
                .map(it -> new OrderItemEntity(
                        it.getId().getValue(),
                        order.getId().getValue(),
                        it.getArticleId().getValue(),
                        it.getArticleName().getValue(),
                        it.getQuantity().getValue(),
                        it.getPricePerItem().getValue()
                ))
                .collect(Collectors.toList());
        return new OrderEntity(
                order.getId().getValue(),
                order.getUserId().getValue(),
                order.getStatus(),
                order.getOrderDate(),
                order.getTotalAmount().getValue(),
                items
        );
    }
}
