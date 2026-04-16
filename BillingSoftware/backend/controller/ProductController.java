//package com.restaurant.app.Restaurant.backend.controller;
//
//import com.restaurant.app.Restaurant.backend.entity.Batch;
//import com.restaurant.app.Restaurant.backend.entity.Product;
//import com.restaurant.app.Restaurant.backend.service.ProductService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/products")
//@CrossOrigin(origins = "*")
//public class ProductController {
//
//    private final ProductService srv;
//
//    public ProductController(ProductService srv) { this.srv = srv; }
//
//    // Existing endpoints (unchanged)
//    @GetMapping("/search")
//    public List<Product> search(@RequestParam("query") String q) {
//        return srv.searchProducts(q == null ? "" : q);
//    }
//
//    @GetMapping("/{id}/batches")
//    public List<Batch> getBatches(@PathVariable Long id) {
//        return srv.getBatchesForProduct(id);
//    }
//
//    @PostMapping("/{id}/batches")
//    public Batch addBatch(@PathVariable Long id, @RequestBody Batch payload) {
//        return srv.addBatch(id, payload);
//    }
//
//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable Long id) {
//        return srv.getProduct(id);
//    }
//    @GetMapping("/")
//    public List<Product> getListProduct() {
//        return srv.getList();
//    }
//
//    // New endpoint: Add multiple products at once
//    @PostMapping("/bulk")
//    public ResponseEntity<List<Product>> addMultipleProducts(@RequestBody List<Product> products) {
//        try {
//        	System.out.println(products.toString());
//            List<Product> savedProducts = srv.addMultipleProducts(products);
//            return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//}