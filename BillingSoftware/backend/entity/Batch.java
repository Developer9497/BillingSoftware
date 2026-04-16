package com.restaurant.app.Restaurant.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "batch")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batch;     // e.g., "BATCH001"
    private String expiry;    // e.g., "2026-05"
    private Double mrp;
    private Double trRate;
    private Double purchaseRate;
    private Double saleRate;
    private Integer currentStock;
    private String supplier;
    @JsonIgnore  // Add this line to break the circular reference
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;  // Reference to the parent Product

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(Long id, String batch, String expiry, Double mrp, Double trRate, Double purchaseRate, Double saleRate,
			Integer currentStock, String supplier, Product product) {
		super();
		this.id = id;
		this.batch = batch;
		this.expiry = expiry;
		this.mrp = mrp;
		this.trRate = trRate;
		this.purchaseRate = purchaseRate;
		this.saleRate = saleRate;
		this.currentStock = currentStock;
		this.supplier = supplier;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getTrRate() {
		return trRate;
	}

	public void setTrRate(Double trRate) {
		this.trRate = trRate;
	}

	public Double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(Double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public Double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(Double saleRate) {
		this.saleRate = saleRate;
	}

	public Integer getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

    // Constructors, getters, setters
}