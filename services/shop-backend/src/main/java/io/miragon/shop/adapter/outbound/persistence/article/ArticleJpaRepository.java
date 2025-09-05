package io.miragon.shop.adapter.outbound.persistence.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, UUID> {
    List<ArticleEntity> findAllByIdIn(List<UUID> ids);
}
