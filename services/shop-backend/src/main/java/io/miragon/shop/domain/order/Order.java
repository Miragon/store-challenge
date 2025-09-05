package io.miragon.shop.domain.order;

import io.miragon.shop.domain.article.Article;
import io.miragon.shop.domain.cart.Cart;
import io.miragon.shop.domain.cart.CartItem;
import io.miragon.shop.domain.shared.Price;
import io.miragon.shop.domain.shared.UserId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {
    private final OrderId id;
    private final UserId userId;
    private final List<OrderItem> items;
    private final OrderStatus status;
    private final LocalDateTime orderDate;
    private final Price totalAmount;

    public Order(OrderId id, UserId userId, List<OrderItem> items, OrderStatus status, LocalDateTime orderDate, Price totalAmount) {
        this.id = id != null ? id : new OrderId();
        this.userId = Objects.requireNonNull(userId);
        this.items = List.copyOf(items);
        this.status = Objects.requireNonNull(status);
        this.orderDate = Objects.requireNonNull(orderDate);
        this.totalAmount = Objects.requireNonNull(totalAmount);
    }

    public static Order place(Cart cart, List<Article> articles) {
        if (cart.isEmpty()) throw new IllegalArgumentException("Cannot create order from empty cart");
        List<OrderItem> orderItems = cart.getItems().stream().map(ci -> createOrderItem(ci, articles)).toList();
        double total = orderItems.stream().mapToDouble(oi -> oi.getPricePerItem().getValue() * oi.getQuantity().getValue()).sum();
        return new Order(
                new OrderId(),
                cart.getUserId(),
                orderItems,
                OrderStatus.PLACED,
                LocalDateTime.now(),
                new Price(total)
        );
    }

    private static OrderItem createOrderItem(CartItem cartItem, List<Article> articles) {
        var article = articles.stream().filter(a -> a.getId().equals(cartItem.getArticleId())).findFirst().orElse(null);
        if (article == null) {
            throw new IllegalArgumentException("There is no article for cart-item " + cartItem.getArticleId());
        }
        return new OrderItem(
                new OrderItemId(),
                cartItem.getArticleId(),
                article.getName(),
                cartItem.getQuantity(),
                article.getPrice()
        );
    }

    public OrderId getId() { return id; }
    public UserId getUserId() { return userId; }
    public List<OrderItem> getItems() { return items; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public Price getTotalAmount() { return totalAmount; }
}
