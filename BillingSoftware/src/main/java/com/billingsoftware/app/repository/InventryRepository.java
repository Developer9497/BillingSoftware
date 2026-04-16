package com.billingsoftware.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.entity.Inventry;

import java.util.List;

@Repository
public interface InventryRepository extends JpaRepository<Inventry, Long> {
    // custom finder to fetch all records by shopId
    List<Inventry> findByShopId(Long shopId);
}
