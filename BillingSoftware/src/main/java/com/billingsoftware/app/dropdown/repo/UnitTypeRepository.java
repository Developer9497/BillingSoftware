package com.billingsoftware.app.dropdown.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingsoftware.app.dropdown.entity.UnitTypeEntity;


@Repository
public interface UnitTypeRepository extends JpaRepository<UnitTypeEntity, Long> {
}