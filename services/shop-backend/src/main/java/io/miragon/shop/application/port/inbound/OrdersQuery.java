package io.miragon.shop.application.port.inbound;

import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.shared.UserId;

import java.util.List;

public interface OrdersQuery {
    List<Order> getOrders(UserId userId);
}
