package io.miragon.shop.application.service.order;

import io.miragon.shop.application.port.inbound.OrdersQuery;
import io.miragon.shop.application.port.outbound.OrderRepository;
import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.shared.UserId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GetOrdersService implements OrdersQuery {

    private final OrderRepository orderRepository;

    public GetOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders(UserId userId) {
        return orderRepository.loadById(userId);
    }
}
