//package com.restaurant.app.Restaurant.backend.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.restaurant.app.Restaurant.backend.entity.PartyDetails;
//
//public interface PartyDetailsRepository extends JpaRepository<PartyDetails, Long> {
//	@Query("SELECT p FROM PartyDetails p WHERE LOWER(p.partyName) LIKE LOWER(CONCAT('%', :name, '%'))")
//    List<PartyDetails> searchByName(String name);
//}
