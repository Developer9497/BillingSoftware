package com.billingsoftware.app.backend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.billingsoftware.app.backend.entity.Batch;
import com.billingsoftware.app.backend.entity.Product;
import com.billingsoftware.app.backend.repository.BatchRepo;
import com.billingsoftware.app.backend.repository.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BatchService {

    private static final Logger logger = LoggerFactory.getLogger(BatchService.class);

    private final BatchRepo batchRepo;
    private final ProductRepo productRepo;

    public BatchService(BatchRepo batchRepo, ProductRepo productRepo) {
        this.batchRepo = batchRepo;
        this.productRepo = productRepo;
    }

    public Batch addBatch(Long productId, Batch batch) {
        logger.info("Adding batch for productId: {}, Batch: {}", productId, batch);

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> {
                    logger.error("Product not found with id: {}", productId);
                    return new RuntimeException("Product not found");
                });

        batch.setProduct(product);
        Batch saved = batchRepo.save(batch);

        logger.info("Batch saved successfully: {}", saved);
        return saved;
    }

    public Batch updateBatch(Long id, Batch batch) {
        logger.info("Updating batch with id: {}", id);

        Batch existing = batchRepo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Batch not found with id: {}", id);
                    return new RuntimeException("Batch not found");
                });

        existing.setBatch(batch.getBatch());
        existing.setExpiry(batch.getExpiry());
        existing.setMrp(batch.getMrp());
        existing.setTrRate(batch.getTrRate());
        existing.setPurchaseRate(batch.getPurchaseRate());
        existing.setSaleRate(batch.getSaleRate());
        existing.setCurrentStock(batch.getCurrentStock());
        existing.setSupplier(batch.getSupplier());

        Batch updated = batchRepo.save(existing);

        logger.info("Batch updated successfully: {}", updated);
        return updated;
    }

    public void deleteBatch(Long id) {
        logger.warn("Deleting batch with id: {}", id);
        batchRepo.deleteById(id);
    }

    public Batch getBatch(Long id) {
        logger.info("Fetching batch with id: {}", id);

        return batchRepo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Batch not found with id: {}", id);
                    return new RuntimeException("Batch not found");
                });
    }

    public List<Batch> getAllBatches() {
        logger.info("Fetching all batches");
        return batchRepo.findAll();
    }

    public List<Batch> getBatchesByProduct(Long productId) {
        logger.info("Fetching batches for productId: {}", productId);
        return batchRepo.findByProductId(productId);
    }
}
