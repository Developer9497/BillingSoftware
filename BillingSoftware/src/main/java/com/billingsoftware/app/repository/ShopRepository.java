package com.billingsoftware.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.entity.Shop;
import com.billingsoftware.app.entity.User;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
	List<Shop> findByShopId(Long shopId);

}
