package com.billingsoftware.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingsoftware.app.backend.entity.Batch;
import com.billingsoftware.app.backend.entity.Party;
import com.billingsoftware.app.backend.entity.Product;
import com.billingsoftware.app.backend.entity.PurchaseBill;
import com.billingsoftware.app.backend.repository.BatchRepo;
import com.billingsoftware.app.backend.repository.PartyRepo;
import com.billingsoftware.app.backend.repository.ProductRepo;
import com.billingsoftware.app.backend.repository.PurchaseBillRepo;

@Service
public class PurchaseBillService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseBillService.class);
@Autowired
    private final PurchaseBillRepo billRepository;
@Autowired
    private final PartyRepo partyRepository;
@Autowired
    private final ProductRepo productRepository;
@Autowired
    private final BatchRepo batchRepository;

    public PurchaseBillService(PurchaseBillRepo billRepository,
    		PartyRepo partyRepository,
    		ProductRepo productRepository,
    		BatchRepo batchRepository) {

        this.billRepository = billRepository;
        this.partyRepository = partyRepository;
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
    }

    public PurchaseBill createBill(PurchaseBill purchaseBill) {

        logger.info("Starting bill creation...");

        // PARTY
//        Party party = partyRepository.findById(purchaseBill.getParty().getId())
//                .orElseGet(() -> {
//                    logger.warn("Party not found, creating new party...");
//                    logger.warn(purchaseBill.getParty().toString());
//                    return partyRepository.save(purchaseBill.getParty());
//                });
        Long partyId = purchaseBill.getParty().getId();
      //  Long partyId = purchaseBill.getParty().getId();

        Party incomingParty = purchaseBill.getParty();

        Party party = partyRepository.findById(partyId)
            .map(existingParty -> {

                logger.warn("++++++++++++++ Updating existing party fields: " + incomingParty);

                // Update all fields safely
            //    existingParty.setName(incomingParty.getName());
                existingParty.setGstNo(incomingParty.getGstNo());
//                existingParty.setVouNo(incomingParty.getVouNo());
//                existingParty.setVouDate(incomingParty.getVouDate());
                existingParty.setPartyName(incomingParty.getPartyName());
                existingParty.setAddressLine1(incomingParty.getAddressLine1());
                existingParty.setAddressLine2(incomingParty.getAddressLine2());
                existingParty.setTelephone(incomingParty.getTelephone());
                existingParty.setFaxNumber(incomingParty.getFaxNumber());
                existingParty.setMobile(incomingParty.getMobile());
                existingParty.setEmail(incomingParty.getEmail());
                existingParty.setContactPerson(incomingParty.getContactPerson());
                existingParty.setDlRegNo(incomingParty.getDlRegNo());
                existingParty.setVatTin(incomingParty.getVatTin());
                existingParty.setPanNo(incomingParty.getPanNo());
                // existingParty.setId(...)  ❌ NEVER update ID manually

                return existingParty;
            })
            .orElseGet(() -> {

                logger.warn("++++++++++++++ Creating new party: " + incomingParty);

                Party newParty = new Party();

                // Copy all fields
               // newParty.setName(incomingParty.getName());
                newParty.setGstNo(incomingParty.getGstNo());
//                newParty.setVouNo(incomingParty.getVouNo());
//                newParty.setVouDate(incomingParty.getVouDate());
                newParty.setPartyName(incomingParty.getPartyName());
                newParty.setAddressLine1(incomingParty.getAddressLine1());
                newParty.setAddressLine2(incomingParty.getAddressLine2());
                newParty.setTelephone(incomingParty.getTelephone());
                newParty.setFaxNumber(incomingParty.getFaxNumber());
                newParty.setMobile(incomingParty.getMobile());
                newParty.setEmail(incomingParty.getEmail());
                newParty.setContactPerson(incomingParty.getContactPerson());
                newParty.setDlRegNo(incomingParty.getDlRegNo());
                newParty.setVatTin(incomingParty.getVatTin());
                newParty.setPanNo(incomingParty.getPanNo());

                return partyRepository.save(newParty);
            });

        // Attach party back to purchaseBill
    //    purchaseBill.setParty(party);


       



    //    purchaseBill.setParty(party);

        // PRODUCTS & BATCHES
        for (Product prod : purchaseBill.getItems()) {

            Product savedProduct = productRepository.findById(prod.getId())
                    .orElseGet(() -> {
                        logger.warn("Product not found. Creating new product: {}", prod.getName());
                        return productRepository.save(prod);
                    });

            // Save batches
            for (Batch batch : prod.getBatches()) {

                Optional<Batch> existingBatch = batchRepository.findByBatchAndProductId(
                        batch.getBatch(), savedProduct.getId()
                );

                if (existingBatch.isPresent()) {
                    logger.info("Batch exists, updating stock");
                    Batch b = existingBatch.get();
                    b.setCurrentStock(b.getCurrentStock() + batch.getCurrentStock());
                    batchRepository.save(b);
                } else {
                    logger.info("Creating new batch {}", batch.getBatch());
                    batch.setProduct(savedProduct);
                    batchRepository.save(batch);
                }
            }
        }

        logger.info("Saving bill...");
        return billRepository.save(purchaseBill);
    }

    public List<PurchaseBill> getAllBills() {
        return billRepository.findAll();
    }

    public Optional<PurchaseBill> getBillById(Long id) {
        return billRepository.findById(id);
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
}
