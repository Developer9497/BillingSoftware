package com.billingsoftware.app.service;

import org.springframework.stereotype.Service;

import com.billingsoftware.app.entity.RestaurantTable;
import com.billingsoftware.app.repository.RestaurantTableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository tableRepository;

    public RestaurantTableService(RestaurantTableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    // Get all tables for logged-in shop
    public List<RestaurantTable> getAllTables(Long shopId) {
        return tableRepository.findByShop_ShopId(shopId);
    }

    // Get table by ID but only if it belongs to shop
    public Optional<RestaurantTable> getTableById(Long tableId, Long shopId) {
        return tableRepository.findById(tableId)
                .filter(table -> table.getShop().getShopId().equals(shopId));
    }

    // Create table and assign it to logged-in shop
    public RestaurantTable createTable(RestaurantTable table, Long shopId) {
        table.getShop().setShopId(shopId); // enforce logged-in shopId
        return tableRepository.save(table);
    }

    // Update table only if it belongs to logged-in shop
    public RestaurantTable updateTable(Long tableId, RestaurantTable tableDetails, Long shopId) {
        return tableRepository.findById(tableId).map(table -> {
            if (!table.getShop().getShopId().equals(shopId)) {
                throw new RuntimeException("Unauthorized: Cannot update other shop's table");
            }
            table.setCapacity(tableDetails.getCapacity());
            table.setStatus(tableDetails.getStatus());
            return tableRepository.save(table);
        }).orElseThrow(() -> new RuntimeException("Table not found with id " + tableId));
    }

    // Delete table only if it belongs to logged-in shop
    public void deleteTable(Long tableId, Long shopId) {
        tableRepository.findById(tableId).ifPresent(table -> {
            if (!table.getShop().getShopId().equals(shopId)) {
                throw new RuntimeException("Unauthorized: Cannot delete other shop's table");
            }
            tableRepository.deleteById(tableId);
        });
    }
}
