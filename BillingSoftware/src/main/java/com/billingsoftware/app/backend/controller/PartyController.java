package com.billingsoftware.app.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billingsoftware.app.backend.entity.Party;
import com.billingsoftware.app.backend.entity.PartyDetails;
import com.billingsoftware.app.backend.service.PartyService;

@RestController
@RequestMapping("/api/party")
@CrossOrigin(origins = "*")
public class PartyController {

    private final PartyService service;

    public PartyController(PartyService service) {
        this.service = service;
    }

    // ----------------------------------------
    // SAVE NEW PARTY
    // ----------------------------------------
    @PostMapping
    public Party save(@RequestBody Party party) {
        return service.save(party);
    }

    // ----------------------------------------
    // UPDATE PARTY
    // ----------------------------------------
    @PutMapping("/{id}")
    public Party update(@PathVariable Long id, @RequestBody Party party) {
        return service.update(id, party);
    }

    // ----------------------------------------
    // SEARCH PARTY BY NAME
    // Angular uses this while typing
    // ----------------------------------------
    @GetMapping("/search")
    public List<Party> search(@RequestParam String name) {
        return service.search(name);
    }

    // ----------------------------------------
    // GET BY ID
    // ----------------------------------------
    @GetMapping("/{id}")
    public Party getById(@PathVariable Long id) {
        return service.getById(id);
    }
}