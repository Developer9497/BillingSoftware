package com.billingsoftware.app.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.billingsoftware.app.backend.entity.Batch;
import com.billingsoftware.app.backend.service.BatchService;

@RestController
@RequestMapping("/api/batch")
@CrossOrigin("*")
public class BatchController {

    private static final Logger logger = LoggerFactory.getLogger(BatchController.class);

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping("/product/{productId}")
    public Batch addBatch(@PathVariable Long productId, @RequestBody Batch batch) {
        logger.info("Adding new batch for productId: {}, Batch: {}", productId, batch);
        return batchService.addBatch(productId, batch);
    }

    @PutMapping("/{id}")
    public Batch updateBatch(@PathVariable Long id, @RequestBody Batch batch) {
        logger.info("Updating batch with id: {}, Batch: {}", id, batch);
        return batchService.updateBatch(id, batch);
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable Long id) {
        logger.warn("Deleting batch with id: {}", id);
        batchService.deleteBatch(id);
    }

    @GetMapping("/{id}")
    public Batch getBatch(@PathVariable Long id) {
        logger.info("Fetching batch with id: {}", id);
        return batchService.getBatch(id);
    }

    @GetMapping
    public List<Batch> getAllBatches() {
        logger.info("Fetching all batches");
        return batchService.getAllBatches();
    }

    @GetMapping("/product/{productId}")
    public List<Batch> getBatchesByProduct(@PathVariable Long productId) {
        logger.info("Fetching batches for productId: {}", productId);
        return batchService.getBatchesByProduct(productId);
    }
}
