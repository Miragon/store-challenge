package io.miragon.shop.adapter.inbound.rest.order;

import io.miragon.shop.application.port.inbound.OrderQuery;
import io.miragon.shop.domain.order.OrderId;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static io.miragon.shop.adapter.inbound.security.SecurityConfig.USER_ID;

@RestController
@RequestMapping("/api/orders")
public class GetOrderController {

    private static final Logger log = LoggerFactory.getLogger(GetOrderController.class);

    private final OrderQuery query;

    public GetOrderController(OrderQuery query) {
        this.query = query;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(
            @PathVariable UUID orderId
    ) {
        var userId = new UserId(USER_ID);
        var orderIdValue = new OrderId(orderId);
        log.info("Getting order: {} for user: {}", orderIdValue, userId);
        var order = query.getOrderById(orderIdValue);
        return ResponseEntity.ok(OrderDto.fromDomain(order));
    }
}
