package io.miragon.shop.application.service.order;

import io.miragon.shop.application.port.inbound.OrderQuery;
import io.miragon.shop.application.port.outbound.OrderRepository;
import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.order.OrderId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetOrderByIdService implements OrderQuery {

    private final OrderRepository orderRepository;

    public GetOrderByIdService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderById(OrderId orderId) {
        Order order = orderRepository.loadById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found: " + orderId);
        }
        return order;
    }
}
