package io.miragon.shop.adapter.inbound.rest.order;

import io.miragon.shop.application.port.inbound.OrdersQuery;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.miragon.shop.adapter.inbound.security.SecurityConfig.USER_ID;

@RestController
@RequestMapping("/api/orders")
public class GetOrdersController {

    private static final Logger log = LoggerFactory.getLogger(GetOrdersController.class);

    private final OrdersQuery getOrdersByUserQuery;

    public GetOrdersController(OrdersQuery getOrdersByUserQuery) {
        this.getOrdersByUserQuery = getOrdersByUserQuery;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrdersByUser() {
        var userId = new UserId(USER_ID);
        log.info("Getting orders for user: {}", userId);
        var orders = getOrdersByUserQuery.getOrders(userId);
        return ResponseEntity.ok(orders.stream().map(OrderDto::fromDomain).toList());
    }
}
