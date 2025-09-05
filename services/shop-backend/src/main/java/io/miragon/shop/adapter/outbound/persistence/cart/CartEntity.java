package io.miragon.shop.adapter.outbound.persistence.cart;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cart")
public class CartEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CartItemEntity> items = new ArrayList<>();

    protected CartEntity() {}

    public CartEntity(String userId) {
        this.userId = userId;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<CartItemEntity> getItems() { return items; }
    public void setItems(List<CartItemEntity> items) { this.items = items; }
}
