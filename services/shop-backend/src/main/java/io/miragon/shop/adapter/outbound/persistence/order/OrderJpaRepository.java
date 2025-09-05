package io.miragon.shop.adapter.outbound.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findByUserId(String userId);
}
