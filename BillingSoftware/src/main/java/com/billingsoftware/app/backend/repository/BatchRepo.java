package com.billingsoftware.app.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.backend.entity.Batch;
@Repository
public interface BatchRepo extends JpaRepository<Batch, Long> {
    Optional<Batch> findByProductIdAndBatch(Long productId, String batchName);

	Optional<Batch> findByBatchAndProductId(String batch, Long id);
	
	 List<Batch> findByProductId(Long productId);
}

