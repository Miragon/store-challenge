package io.miragon.shop.adapter.outbound.persistence.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJpaRepository extends JpaRepository<CartEntity, String> {
    CartEntity findByUserId(String userId);
}
