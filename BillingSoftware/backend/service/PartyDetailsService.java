//package com.restaurant.app.Restaurant.backend.service;
//
//import com.restaurant.app.Restaurant.backend.entity.PartyDetails;
//import com.restaurant.app.Restaurant.backend.repository.PartyDetailsRepository;
//
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class PartyDetailsService {
//
//    private final PartyDetailsRepository repo;
//
//    public PartyDetailsService(PartyDetailsRepository repo) {
//        this.repo = repo;
//    }
//
//    // Save new party
//    public PartyDetails save(PartyDetails party) {
//        return repo.save(party);
//    }
//
//    // Update existing party
//    public PartyDetails update(Long id, PartyDetails newData) {
//
//    	PartyDetails existing = repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Party not found with ID: " + id));
//
//        existing.setVouNo(newData.getVouNo());
//        existing.setVouDate(newData.getVouDate());
//        existing.setPartyName(newData.getPartyName());
//        existing.setAddressLine1(newData.getAddressLine1());
//        existing.setAddressLine2(newData.getAddressLine2());
//        existing.setTelephone(newData.getTelephone());
//        existing.setFaxNumber(newData.getFaxNumber());
//        existing.setMobile(newData.getMobile());
//        existing.setEmail(newData.getEmail());
//        existing.setContactPerson(newData.getContactPerson());
//        existing.setDlRegNo(newData.getDlRegNo());
//        existing.setVatTin(newData.getVatTin());
//        existing.setPanNo(newData.getPanNo());
//        existing.setGstNo(newData.getGstNo());
//        existing.setSgstPercent(newData.getSgstPercent());
//        existing.setCgstPercent(newData.getCgstPercent());
//        existing.setBillNo(newData.getBillNo());
//        existing.setTransactionType(newData.getTransactionType());
//        existing.setBillDate(newData.getBillDate());
//        existing.setDueDate(newData.getDueDate());
//        existing.setOutstandingAmount(newData.getOutstandingAmount());
//        existing.setIsDataOk(newData.getIsDataOk());
//
//        return repo.save(existing);
//    }
//
//    // Search by party name auto-suggest
//    public List<PartyDetails> search(String name) {
//        return repo.searchByName(name);
//    }
//
//    // Get single party by ID
//    public PartyDetails getById(Long id) {
//        return repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Party not found"));
//    }
//}
