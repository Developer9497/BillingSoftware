package com.billingsoftware.app.dropdown.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billingsoftware.app.dropdown.entity.CategoryEntity;
import com.billingsoftware.app.dropdown.entity.FormEntity;
import com.billingsoftware.app.dropdown.entity.PackingEntity;
import com.billingsoftware.app.dropdown.entity.UnitTypeEntity;
import com.billingsoftware.app.dropdown.repo.CategoryRepository;
import com.billingsoftware.app.dropdown.repo.FormRepository;
import com.billingsoftware.app.dropdown.repo.PackingRepository;
import com.billingsoftware.app.dropdown.repo.UnitTypeRepository;

@RestController
@RequestMapping("/api/dropdown")
public class DropDownController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private PackingRepository packingRepository;

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    // ================= CATEGORY =================

    @PostMapping("/category")
    public CategoryEntity saveCategory(@RequestBody CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/category")
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    // ================= FORM =================

    @PostMapping("/form")
    public FormEntity saveForm(@RequestBody FormEntity form) {
        return formRepository.save(form);
    }

    @GetMapping("/form")
    public List<FormEntity> getAllForms() {
        return formRepository.findAll();
    }

    // ================= PACKING =================

    @PostMapping("/packing")
    public PackingEntity savePacking(@RequestBody PackingEntity packing) {
        return packingRepository.save(packing);
    }

    @GetMapping("/packing")
    public List<PackingEntity> getAllPacking() {
        return packingRepository.findAll();
    }

    // ================= UNIT TYPE =================

    @PostMapping("/unit")
    public UnitTypeEntity saveUnit(@RequestBody UnitTypeEntity unit) {
        return unitTypeRepository.save(unit);
    }

    @GetMapping("/unit")
    public List<UnitTypeEntity> getAllUnits() {
        return unitTypeRepository.findAll();
    }
}