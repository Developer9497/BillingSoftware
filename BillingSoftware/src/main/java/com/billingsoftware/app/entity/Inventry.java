package com.billingsoftware.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Inventry")
public class Inventry {

    public Inventry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Inventry(Long id, Long shopId, LocalDate lastUpdateDate, String item, String type, Integer stock,
			Double total, Double mrpPrice) {
		super();
		this.id = id;
		this.shopId = shopId;
		LastUpdateDate = lastUpdateDate;
		this.item = item;
		this.type = type;
		this.stock = stock;
		this.total = total;
		this.mrpPrice = mrpPrice;
	}

	public LocalDate getLastUpdateDate() {
		return LastUpdateDate;
	}
	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		LastUpdateDate = lastUpdateDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // New field: Shop ID
    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    @Column(name = "last_update_date", nullable = false)
    private LocalDate LastUpdateDate;

    @Column(name = "item")
    private String item;

    @Column(name = "type")
    private String type; // or Integer if it’s numeric

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "total")
    private Double total;

    @Column(name = "mrp_price")
    private Double mrpPrice;  // MRP / Selling Price

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

   
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMrpPrice() {
        return mrpPrice;
    }
    public void setMrpPrice(Double mrpPrice) {
        this.mrpPrice = mrpPrice;
    }
}
