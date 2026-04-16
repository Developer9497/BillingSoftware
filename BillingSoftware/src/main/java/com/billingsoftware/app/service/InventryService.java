package com.billingsoftware.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.billingsoftware.app.entity.Inventry;
import com.billingsoftware.app.repository.InventryRepository;

@Service
public class InventryService {

    private final InventryRepository inventryRepository;

    public InventryService(InventryRepository inventryRepository) {
        this.inventryRepository = inventryRepository;
    }

    public Inventry saveInventry(Inventry inventry, Long shopId) {
        inventry.setShopId(shopId); // enforce logged-in shopId
        return inventryRepository.save(inventry);
    }

    public List<Inventry> getInventryByShopId(Long shopId) {
        return inventryRepository.findByShopId(shopId);
    }

    public Optional<Inventry> getInventryByIdAndShop(Long id, Long shopId) {
        return inventryRepository.findById(id)
                .filter(inv -> inv.getShopId().equals(shopId));
    }

    public Inventry updateInventry(Long id, Inventry updatedInventry, Long shopId) {
        return inventryRepository.findById(id).map(inventry -> {
            if (!inventry.getShopId().equals(shopId)) {
                throw new RuntimeException("Unauthorized: Cannot update other shop's inventory");
            }
            inventry.setLastUpdateDate(updatedInventry.getLastUpdateDate());
            inventry.setItem(updatedInventry.getItem());
            inventry.setType(updatedInventry.getType());
            inventry.setStock(updatedInventry.getStock());
            inventry.setTotal(updatedInventry.getTotal());
            inventry.setMrpPrice(updatedInventry.getMrpPrice());
            return inventryRepository.save(inventry);
        }).orElseThrow(() -> new RuntimeException("Inventry not found with id " + id));
    }
    // ✅ Create multiple inventory items
    public List<Inventry> createInventryList(List<Inventry> inventryList, Long shopId) {
        List<Inventry> updatedList = inventryList.stream()
                .peek(item -> item.setShopId(shopId))  // enforce logged-in shop
                .collect(Collectors.toList());
        return inventryRepository.saveAll(updatedList);
    }
    public void deleteInventry(Long id, Long shopId) {
        inventryRepository.findById(id).ifPresent(inventry -> {
            if (!inventry.getShopId().equals(shopId)) {
                throw new RuntimeException("Unauthorized: Cannot delete other shop's inventory");
            }
            inventryRepository.deleteById(id);
        });
    }
}
