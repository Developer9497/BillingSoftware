package com.restaurant.app.Restaurant.backend.repository;

import com.restaurant.app.Restaurant.backend.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByProductId(Long productId);
}
