package com.restaurant.app.Restaurant.backend.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_invoice")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PurchaseInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic purchase invoice fields (from your snippet)
    private String gstNo;
    private Double sgstPercent;
    private Double cgstPercent;
    private String billNo;
    private String transactionType;  // e.g., 'Credit'
    private String billDate;         // e.g., '2025-11-17'
    private String dueDate;          // e.g., '2025-11-17'
    private Double outstandingAmount;

    // Totals (calculated or stored)
    private Integer totalItem;
    private Integer totalQuantity;
    private Double gst;
    private Double totalReplace;
    private Double totalFree;
    private Double totalAmount;

    // Relationships
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private PartyDetails party;  // Links to the supplier/party

   
    
    @OneToMany(mappedBy = "purchaseInvoice", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
   // @JsonManagedReference
    private List<PurchaseInvoiceItem> items;  // Multiple products/batches

 }