package com.billingsoftware.app.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.backend.entity.Party;
import com.billingsoftware.app.backend.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
   // List<Product> searchByName(String name);
 @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT(:name, '%'))")
  List<Product> searchByName(String name);
}

