//package com.restaurant.app.Restaurant.backend.entity;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "purchase_invoice_item")
////@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//public class PurchaseInvoiceItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "purchase_invoice_id")
////    @JsonManagedReference
////    private PurchaseInvoice purchaseInvoice;  // Links back to the purchase invoice
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "batch_id")
//    private Batch batch;  // Links to the product batch (includes purchase rates, stock, etc.)
//
//    private Integer quantity;  // Quantity of this batch in the purchase invoice
//    private Double rate;       // Purchase rate for this item
//    // Add more fields if needed, e.g., discount, tax per item
//
//    // Constructors, Getters, Setters
//    public PurchaseInvoiceItem() {}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public PurchaseInvoice getPurchaseInvoice() {
//		return purchaseInvoice;
//	}
//
//	public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
//		this.purchaseInvoice = purchaseInvoice;
//	}
//
//	public Batch getBatch() {
//		return batch;
//	}
//
//	public void setBatch(Batch batch) {
//		this.batch = batch;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public Double getRate() {
//		return rate;
//	}
//
//	public void setRate(Double rate) {
//		this.rate = rate;
//	}
//
//	public PurchaseInvoiceItem(Long id, PurchaseInvoice purchaseInvoice, Batch batch, Integer quantity, Double rate) {
//		super();
//		this.id = id;
//		this.purchaseInvoice = purchaseInvoice;
//		this.batch = batch;
//		this.quantity = quantity;
//		this.rate = rate;
//	}
//
//    
//}