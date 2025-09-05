package io.miragon.shop.application.service.order;

import io.miragon.shop.application.port.inbound.PlaceOrderUseCase;
import io.miragon.shop.application.port.outbound.ArticleRepository;
import io.miragon.shop.application.port.outbound.CartRepository;
import io.miragon.shop.application.port.outbound.OrderRepository;
import io.miragon.shop.domain.order.Order;
import io.miragon.shop.domain.shared.UserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlaceOrderService implements PlaceOrderUseCase {

    private static final Logger log = LoggerFactory.getLogger(PlaceOrderService.class);

    private final OrderRepository orderRepository;
    private final ArticleRepository articleRepository;
    private final CartRepository cartRepository;

    public PlaceOrderService(
            OrderRepository orderRepository,
            ArticleRepository articleRepository,
            CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.articleRepository = articleRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Order placeOrder(UserId userId) {
        var cart = cartRepository.loadCart(userId);
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cannot place order with empty cart");
        }
        var articlesInCart = cart.getItems().stream().map(i -> i.getArticleId()).toList();
        var articles = articleRepository.loadByIds(articlesInCart);
        var order = Order.place(cart, articles);
        orderRepository.save(order);
        cartRepository.deleteCart(userId);
        log.info("Completed order {} for user {} with {} items. Cart cleared.", order.getId(), userId, order.getItems().size());
        return order;
    }
}
