package io.miragon.shop.adapter.inbound.rest.order;

import io.miragon.shop.application.port.inbound.PlaceOrderUseCase;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.miragon.shop.adapter.inbound.security.SecurityConfig.USER_ID;

@RestController
@RequestMapping("/api/orders")
public class CompleteOrderController {

    private static final Logger log = LoggerFactory.getLogger(CompleteOrderController.class);

    private final PlaceOrderUseCase completeOrderUseCase;

    public CompleteOrderController(PlaceOrderUseCase completeOrderUseCase) {
        this.completeOrderUseCase = completeOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<OrderDto> completeOrder() {
        var userId = new UserId(USER_ID);
        log.info("Completing order for user: {}", userId);
        var order = completeOrderUseCase.placeOrder(userId);
        return ResponseEntity.ok(OrderDto.fromDomain(order));
    }
}
