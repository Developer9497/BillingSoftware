package com.billingsoftware.app.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billingsoftware.app.backend.entity.PurchaseBill;
import com.billingsoftware.app.backend.service.PurchaseBillService;

@RestController
@RequestMapping("/bills")
public class PurchaseBillController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseBillController.class);

    private final PurchaseBillService billService;

    public PurchaseBillController(PurchaseBillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<PurchaseBill> createBill(@RequestBody PurchaseBill purchaseBill) {
        logger.info("Received request to add bill");
        return ResponseEntity.ok(billService.createBill(purchaseBill));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseBill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseBill> getBill(@PathVariable Long id) {
        return billService.getBillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
