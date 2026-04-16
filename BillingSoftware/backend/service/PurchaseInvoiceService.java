//package com.restaurant.app.Restaurant.backend.service;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.restaurant.app.Restaurant.backend.entity.PurchaseInvoice;
//import com.restaurant.app.Restaurant.backend.entity.PurchaseInvoiceItem;
//import com.restaurant.app.Restaurant.backend.repository.PurchaseInvoiceItemRepository;
//import com.restaurant.app.Restaurant.backend.repository.PurchaseInvoiceRepository;
//
//@Service
//public class PurchaseInvoiceService {
//
//    @Autowired
//    private PurchaseInvoiceRepository purchaseInvoiceRepository;
//
//    @Autowired
//    private PurchaseInvoiceItemRepository purchaseInvoiceItemRepository;
//
//    // CREATE: Save a new purchase invoice with items
//    @Transactional
//    public PurchaseInvoice createPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
//        // Calculate totals if not provided (example logic)
//        if (purchaseInvoice.getItems() != null) {
//            purchaseInvoice.setTotalItem(purchaseInvoice.getItems().size());
//            purchaseInvoice.setTotalQuantity(purchaseInvoice.getItems().stream().mapToInt(PurchaseInvoiceItem::getQuantity).sum());
//            // Add more calculations for gst, totalAmount, etc., based on rates and taxes
//        }
//        return purchaseInvoiceRepository.save(purchaseInvoice);
//    }
//
//    // READ: Get all purchase invoices
//    public List<PurchaseInvoice> getAllPurchaseInvoices() {
//        return purchaseInvoiceRepository.findAll();
//    }
//
//    // READ: Get purchase invoice by ID
//    public Optional<PurchaseInvoice> getPurchaseInvoiceById(Long id) {
//        return purchaseInvoiceRepository.findById(id);
//    }
//
//    // UPDATE: Update an existing purchase invoice
//    @Transactional
//    public PurchaseInvoice updatePurchaseInvoice(Long id, PurchaseInvoice updatedPurchaseInvoice) {
//        Optional<PurchaseInvoice> existing = purchaseInvoiceRepository.findById(id);
//        if (existing.isPresent()) {
//            PurchaseInvoice purchaseInvoice = existing.get();
//            // Update fields (add logic to copy from updatedPurchaseInvoice)
//            purchaseInvoice.setGstNo(updatedPurchaseInvoice.getGstNo());
//            // ... update other fields
//            return purchaseInvoiceRepository.save(purchaseInvoice);
//        }
//        throw new RuntimeException("Purchase Invoice not found");
//    }
//
//    // DELETE: Delete a purchase invoice (cascades to items due to orphanRemoval)
//    @Transactional
//    public void deletePurchaseInvoice(Long id) {
//        purchaseInvoiceRepository.deleteById(id);
//    }
//
//    // Additional CRUD for PurchaseInvoiceItem if needed separately
//    public PurchaseInvoiceItem createPurchaseInvoiceItem(PurchaseInvoiceItem item) {
//        return purchaseInvoiceItemRepository.save(item);
//    }
//    // Add read, update, delete for PurchaseInvoiceItem similarly
// // In PurchaseInvoiceService.java
//    public List<PurchaseInvoice> addMultiplePurchaseInvoices(List<PurchaseInvoice> invoices) {
//        // Optional: Add validation or business logic here (e.g., calculate totals for each invoice)
//        return purchaseInvoiceRepository.saveAll(invoices);  // Saves all in a single transaction
//    }
////	public List<PurchaseInvoice> addMultiplePurchaseInvoices(List<PurchaseInvoice> invoices) {
////		return	purchaseInvoiceItemRepository.saveAll(invoices);
////		
////	}
//}