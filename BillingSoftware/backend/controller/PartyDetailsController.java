//package com.restaurant.app.Restaurant.backend.controller;
//
//import com.restaurant.app.Restaurant.backend.entity.PartyDetails;
//import com.restaurant.app.Restaurant.backend.service.PartyDetailsService;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/party")
//@CrossOrigin(origins = "*")
//public class PartyDetailsController {
//
//    private final PartyDetailsService service;
//
//    public PartyDetailsController(PartyDetailsService service) {
//        this.service = service;
//    }
//
//    // ----------------------------------------
//    // SAVE NEW PARTY
//    // ----------------------------------------
//    @PostMapping
//    public PartyDetails save(@RequestBody PartyDetails party) {
//        return service.save(party);
//    }
//
//    // ----------------------------------------
//    // UPDATE PARTY
//    // ----------------------------------------
//    @PutMapping("/{id}")
//    public PartyDetails update(@PathVariable Long id, @RequestBody PartyDetails party) {
//        return service.update(id, party);
//    }
//
//    // ----------------------------------------
//    // SEARCH PARTY BY NAME
//    // Angular uses this while typing
//    // ----------------------------------------
//    @GetMapping("/search")
//    public List<PartyDetails> search(@RequestParam String name) {
//        return service.search(name);
//    }
//
//    // ----------------------------------------
//    // GET BY ID
//    // ----------------------------------------
//    @GetMapping("/{id}")
//    public PartyDetails getById(@PathVariable Long id) {
//        return service.getById(id);
//    }
//}