package com.billingsoftware.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.billingsoftware.app.entity.RestaurantTable;
import com.billingsoftware.app.service.RestaurantTableService;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class RestaurantTableController {

    private final RestaurantTableService tableService;

    public RestaurantTableController(RestaurantTableService tableService) {
        this.tableService = tableService;
    }

    // Dummy method to simulate logged-in shop
    private Long getLoggedInShopId() {
        // TODO: Replace with actual login/session/JWT logic
        return 1L;
    }

    // Get all tables for logged-in shop
    @GetMapping
    public List<RestaurantTable> getAllTables() {
        Long shopId = getLoggedInShopId();
        return tableService.getAllTables(shopId);
    }

    // Get table by ID for logged-in shop
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTableById(@PathVariable Long id) {
        Long shopId = getLoggedInShopId();
        return tableService.getTableById(id, shopId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create table
    @PostMapping
    public RestaurantTable createTable(@RequestBody RestaurantTable table) {
        Long shopId = getLoggedInShopId();
        return tableService.createTable(table, shopId);
    }

    // Update table
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTable> updateTable(@PathVariable Long id, @RequestBody RestaurantTable tableDetails) {
        Long shopId = getLoggedInShopId();
        try {
            RestaurantTable updatedTable = tableService.updateTable(id, tableDetails, shopId);
            return ResponseEntity.ok(updatedTable);
        } catch (RuntimeException e) {
            return ResponseEntity.status(403).build(); // Forbidden
        }
    }

    // Delete table
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        Long shopId = getLoggedInShopId();
        try {
            tableService.deleteTable(id, shopId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(403).build(); // Forbidden
        }
    }
}
