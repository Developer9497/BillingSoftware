package com.billingsoftware.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.entity.RestaurantTable;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    // Fetch all tables for a specific shop
    List<RestaurantTable> findByShop_ShopId(Long shopId);

    // Optional: fetch a table by its ID **and** shop ID
    // Useful for security checks
    Optional<RestaurantTable> findByTableIdAndShop_ShopId(Long tableId, Long shopId);
}
