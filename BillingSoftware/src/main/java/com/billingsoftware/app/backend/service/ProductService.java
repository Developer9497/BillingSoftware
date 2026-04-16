package com.billingsoftware.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingsoftware.app.backend.entity.Party;
import com.billingsoftware.app.backend.entity.Product;
import com.billingsoftware.app.backend.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Create or Update product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> search(String name) {
        return productRepository.searchByName(name);
    }

    // Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
