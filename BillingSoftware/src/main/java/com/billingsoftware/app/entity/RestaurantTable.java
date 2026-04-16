package com.billingsoftware.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurant_tables")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "table_no", nullable = false)
    private int tableNo; // New table number field

    @Column(name = "table_capacity", nullable = false)
    private int capacity;

    @Column(name = "table_status", nullable = false)
    private String status; // Available, Occupied, Reserved, etc.

    // Many tables belong to one shop
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    // --- Constructors ---
    public RestaurantTable() {}

    public RestaurantTable(Long tableId, int tableNo, int capacity, String status, Shop shop) {
        this.tableId = tableId;
        this.tableNo = tableNo;
        this.capacity = capacity;
        this.status = status;
        this.shop = shop;
    }

    // --- Getters & Setters ---
    public Long getTableId() {
        return tableId;
    }
    
    public int getTableNo() {
        return tableNo;
    }
    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
