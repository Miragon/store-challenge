package io.miragon.shop.application.port.outbound;

import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.order.OrderId;
import io.miragon.shop.domain.shared.UserId;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    Order loadById(OrderId orderId);
    List<Order> loadById(UserId userId);
}
