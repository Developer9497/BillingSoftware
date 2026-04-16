package com.billingsoftware.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.billingsoftware.app.entity.Inventry;
import com.billingsoftware.app.service.InventryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventry")
public class InventryController {

    private final InventryService inventryService;

    public InventryController(InventryService inventryService) {
        this.inventryService = inventryService;
    }

    // Example: assume we get shopId from login/session
    private Long getLoggedInShopId() {
        // TODO: replace with JWT/session logic
        return 1L; // hardcoded for now
    }

    @PostMapping
    public ResponseEntity<Inventry> createInventry(@RequestBody Inventry inventry) {
        Long shopId = getLoggedInShopId();
        return ResponseEntity.ok(inventryService.saveInventry(inventry, shopId));
    }

    @GetMapping
    public ResponseEntity<List<Inventry>> getInventryForShop() {
        Long shopId = getLoggedInShopId();
        return ResponseEntity.ok(inventryService.getInventryByShopId(shopId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventry> getInventryById(@PathVariable Long id) {
        Long shopId = getLoggedInShopId();
        return inventryService.getInventryByIdAndShop(id, shopId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventry> updateInventry(@PathVariable Long id, @RequestBody Inventry inventry) {
        Long shopId = getLoggedInShopId();
        return ResponseEntity.ok(inventryService.updateInventry(id, inventry, shopId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventry(@PathVariable Long id) {
        Long shopId = getLoggedInShopId();
        inventryService.deleteInventry(id, shopId);
        return ResponseEntity.noContent().build();
    }
    

    // ✅ Create multiple inventory items at once
    @PostMapping("/batch")
    public List<Inventry> createInventryList(@RequestBody List<Inventry> inventryList) {
        Long shopId = getLoggedInShopId();
        return inventryService.createInventryList(inventryList, shopId);
    }
}
