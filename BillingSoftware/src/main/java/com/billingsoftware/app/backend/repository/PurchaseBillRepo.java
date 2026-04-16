package com.billingsoftware.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.backend.entity.PurchaseBill;
@Repository
public interface PurchaseBillRepo extends JpaRepository<PurchaseBill, Long> {}

