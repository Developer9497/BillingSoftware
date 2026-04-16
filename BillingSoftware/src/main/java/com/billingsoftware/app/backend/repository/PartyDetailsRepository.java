package com.billingsoftware.app.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.backend.entity.Party;
import com.billingsoftware.app.backend.entity.PartyDetails;
@Repository
public interface PartyDetailsRepository extends JpaRepository<Party, Long> {
	@Query("SELECT p FROM Party p WHERE LOWER(p.partyName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<PartyDetails> searchByName(String name);
}
