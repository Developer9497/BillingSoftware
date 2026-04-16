package com.billingsoftware.app.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billingsoftware.app.backend.entity.Party;
import com.billingsoftware.app.backend.entity.PartyDetails;
import com.billingsoftware.app.backend.repository.PartyDetailsRepository;
import com.billingsoftware.app.backend.repository.PartyRepo;
@Service
public class PartyService {

    private final PartyRepo repo;

    public PartyService(PartyRepo repo) {
        this.repo = repo;
    }
//
    // Save new party
    public Party save(Party party) {
        return repo.save(party);
    }

    // Update existing party
    public Party update(Long id, Party newData) {

    	Party existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Party not found with ID: " + id));

       
        existing.setPartyName(newData.getPartyName());
        existing.setAddressLine1(newData.getAddressLine1());
        existing.setAddressLine2(newData.getAddressLine2());
        existing.setTelephone(newData.getTelephone());
        existing.setFaxNumber(newData.getFaxNumber());
        existing.setMobile(newData.getMobile());
        existing.setEmail(newData.getEmail());
        existing.setContactPerson(newData.getContactPerson());
        existing.setDlRegNo(newData.getDlRegNo());
        existing.setVatTin(newData.getVatTin());
        existing.setPanNo(newData.getPanNo());
        existing.setGstNo(newData.getGstNo());
      
        return repo.save(existing);
    }

    // Search by party name auto-suggest
    public List<Party> search(String name) {
        return repo.searchByName(name);
    }

    // Get single party by ID
    public Party getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Party not found"));
    }
}
