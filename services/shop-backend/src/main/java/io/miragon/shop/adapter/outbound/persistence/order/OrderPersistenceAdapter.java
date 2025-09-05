package io.miragon.shop.adapter.outbound.persistence.order;

import io.miragon.shop.application.port.outbound.OrderRepository;
import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.order.OrderId;
import io.miragon.shop.domain.shared.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderPersistenceAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderPersistenceAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = OrderMapper.toEntity(order);
        OrderEntity saved = orderJpaRepository.save(entity);
        return OrderMapper.toDomain(saved);
    }

    @Override
    public Order loadById(OrderId orderId) {
        return orderJpaRepository.findById(orderId.getValue())
                .map(OrderMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Order> loadById(UserId userId) {
        return orderJpaRepository.findByUserId(userId.getValue())
                .stream()
                .map(OrderMapper::toDomain)
                .toList();
    }
}
