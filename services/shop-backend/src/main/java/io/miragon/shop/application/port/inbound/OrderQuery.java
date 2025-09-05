package io.miragon.shop.application.port.inbound;

import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.order.OrderId;

public interface OrderQuery {
    Order getOrderById(OrderId orderId);
}
