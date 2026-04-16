//package com.restaurant.app.Restaurant.backend.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.restaurant.app.Restaurant.backend.entity.PurchaseInvoice;
//import com.restaurant.app.Restaurant.backend.entity.PurchaseInvoiceItem;
//import com.restaurant.app.Restaurant.backend.service.PurchaseInvoiceService;
//
//@RestController
//@RequestMapping("/api/purchase-invoices")
//public class PurchaseInvoiceController {
//
//    @Autowired
//    private PurchaseInvoiceService purchaseInvoiceService;
//
//    // Existing endpoints (unchanged)
//    // CREATE: Add a new purchase invoice
//    @PostMapping
//    public ResponseEntity<PurchaseInvoice> createPurchaseInvoice(@RequestBody PurchaseInvoice purchaseInvoice) {
//        try {
//            PurchaseInvoice created = purchaseInvoiceService.createPurchaseInvoice(purchaseInvoice);
//            return new ResponseEntity<>(created, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    // READ: Get all purchase invoices
//    @GetMapping
//    public ResponseEntity<List<PurchaseInvoice>> getAllPurchaseInvoices() {
//        List<PurchaseInvoice> invoices = purchaseInvoiceService.getAllPurchaseInvoices();
//        return new ResponseEntity<>(invoices, HttpStatus.OK);
//    }
//
//    // READ: Get a purchase invoice by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<PurchaseInvoice> getPurchaseInvoiceById(@PathVariable Long id) {
//        Optional<PurchaseInvoice> invoice = purchaseInvoiceService.getPurchaseInvoiceById(id);
//        if (invoice.isPresent()) {
//            return new ResponseEntity<>(invoice.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // UPDATE: Update an existing purchase invoice
//    @PutMapping("/{id}")
//    public ResponseEntity<PurchaseInvoice> updatePurchaseInvoice(@PathVariable Long id, @RequestBody PurchaseInvoice updatedPurchaseInvoice) {
//        try {
//            PurchaseInvoice updated = purchaseInvoiceService.updatePurchaseInvoice(id, updatedPurchaseInvoice);
//            return new ResponseEntity<>(updated, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    // DELETE: Delete a purchase invoice by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePurchaseInvoice(@PathVariable Long id) {
//        try {
//            purchaseInvoiceService.deletePurchaseInvoice(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Additional: CRUD for PurchaseInvoiceItem (as sub-resources)
//    // CREATE: Add an item to a specific invoice
//    @PostMapping("/{invoiceId}/items")
//    public ResponseEntity<PurchaseInvoiceItem> createPurchaseInvoiceItem(@PathVariable Long invoiceId, @RequestBody PurchaseInvoiceItem item) {
//        // Ensure the item is linked to the invoice
//        Optional<PurchaseInvoice> invoice = purchaseInvoiceService.getPurchaseInvoiceById(invoiceId);
//        if (invoice.isPresent()) {
//            item.setPurchaseInvoice(invoice.get());
//            PurchaseInvoiceItem created = purchaseInvoiceService.createPurchaseInvoiceItem(item);
//            return new ResponseEntity<>(created, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // READ: Get items for a specific invoice (you can expand this)
//    @GetMapping("/{invoiceId}/items")
//    public ResponseEntity<List<PurchaseInvoiceItem>> getItemsByInvoiceId(@PathVariable Long invoiceId) {
//        Optional<PurchaseInvoice> invoice = purchaseInvoiceService.getPurchaseInvoiceById(invoiceId);
//        if (invoice.isPresent()) {
//            return new ResponseEntity<>(invoice.get().getItems(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // UPDATE/DELETE for items can be added similarly if needed
//
//    // New endpoint: Add multiple purchase invoices at once
//    @PostMapping("/bulk")
//    public ResponseEntity<List<PurchaseInvoice>> addMultiplePurchaseInvoices(@RequestBody List<PurchaseInvoice> invoices) {
//        try {
//            List<PurchaseInvoice> savedInvoices = purchaseInvoiceService.addMultiplePurchaseInvoices(invoices);
//            return new ResponseEntity<>(savedInvoices, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//}