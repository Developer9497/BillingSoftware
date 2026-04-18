package com.billingsoftware.app.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.backend.entity.Party;
import com.billingsoftware.app.backend.entity.PartyDetails;
@Repository
public interface PartyRepo extends JpaRepository<Party, Long> {
    Optional<Party> findByGstNo(String gstNo);
    
    @Query("SELECT p FROM Party p WHERE LOWER(p.partyName) LIKE LOWER(CONCAT(:name, '%'))")
    List<Party> searchByName(String name);
}

