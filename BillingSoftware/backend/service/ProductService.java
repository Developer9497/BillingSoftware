//package com.restaurant.app.Restaurant.backend.service;
//
//import com.restaurant.app.Restaurant.backend.entity.Batch;
//import com.restaurant.app.Restaurant.backend.entity.Product;
//import com.restaurant.app.Restaurant.backend.repository.BatchRepository;
//import com.restaurant.app.Restaurant.backend.repository.ProductRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    private final ProductRepository productRepo;
//    private final BatchRepository batchRepo;
//
//    public ProductService(ProductRepository productRepo, BatchRepository batchRepo) {
//        this.productRepo = productRepo;
//        this.batchRepo = batchRepo;
//    }
//
//    public List<Product> searchProducts(String q) {
//        return productRepo.searchByName(q);
//    }
//    public List<Product> getList() {
//        return productRepo.findAll();
//    }
//
//    public Product getProduct(Long id) {
//        return productRepo.findById(id).orElse(null);
//    }
//
//    public List<Batch> getBatchesForProduct(Long productId) {
//        return batchRepo.findByProductId(productId);
//    }
//
//    @Transactional
//    public Batch addBatch(Long productId, Batch batchPayload) {
//    	Integer currentStock = batchPayload.getCurrentStock();
//    	Integer stock = batchPayload.getProduct().getStock();
//        Product p = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
//        Batch b = new Batch();
//        b.setProduct(p);
//        b.setBatch(batchPayload.getBatch());
//        b.setExpiry(batchPayload.getExpiry());
//        b.setMrp(batchPayload.getMrp());
//        b.setTrRate(batchPayload.getTrRate());
//        b.setPurchaseRate(batchPayload.getPurchaseRate());
//        b.setSaleRate(batchPayload.getSaleRate());
//        b.setCurrentStock(batchPayload.getCurrentStock() != null ? batchPayload.getCurrentStock() : (batchPayload.getProduct().getStock() == null ? 0 : batchPayload.getProduct().getStock()));
//        b.setSupplier(batchPayload.getSupplier());
//        Batch saved = batchRepo.save(b);
//
//        // optional: update product stock sum
//        int total = productRepo.findById(productId).map(prod -> {
//            int sum = getBatchesForProduct(productId).stream().mapToInt(bt -> bt.getCurrentStock() == null ? 0 : bt.getCurrentStock()).sum();
//            prod.setStock(sum);
//            productRepo.save(prod);
//            return sum;
//        }).orElse(0);
//        return saved;
//    }
// // In ProductService.java
//    public List<Product> addMultipleProducts(List<Product> products) {
//        // Optional: Add validation or business logic here (e.g., check for duplicates)
//        return productRepo.saveAll(products);  // Saves all in a single transaction
//    }
//}
