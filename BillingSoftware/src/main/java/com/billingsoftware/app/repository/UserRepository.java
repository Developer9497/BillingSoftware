package com.billingsoftware.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.billingsoftware.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findByShopId(Long shopId);
    List<User> findByShopShopId(Long shopId);
    // Correct way to query by shopId
    @Query("SELECT u FROM User u WHERE u.shop.shopId = :shopId")
    List<User> findByShopId(@Param("shopId") Long shopId);
    // Example other queries
    
    Optional<User> findByUserGmail(String gmail);
}
