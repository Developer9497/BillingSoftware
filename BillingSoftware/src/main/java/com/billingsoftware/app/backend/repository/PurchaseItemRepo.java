package com.billingsoftware.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.backend.entity.PurchaseItem;
@Repository
public interface PurchaseItemRepo extends JpaRepository<PurchaseItem, Long> {}
