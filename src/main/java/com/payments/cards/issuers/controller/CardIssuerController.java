package com.payments.cards.issuers.controller;

import com.payments.cards.issuers.model.CardIssuer;
import com.payments.cards.issuers.service.CardIssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/card-issuers")
public class CardIssuerController {

    @Autowired
    private final CardIssuerService service;

    public CardIssuerController(CardIssuerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CardIssuer> getAllIssuers() {
        return service.getAllIssuers();
    }

    @GetMapping("/{id}")
    public CardIssuer getIssuerById(@PathVariable String id) {
        return service.getIssuerById(id);
    }

    @PostMapping
    public CardIssuer createIssuer(@RequestBody CardIssuer issuer) {
        return service.createIssuer(issuer);
    }

    @PutMapping("/{id}")
    public CardIssuer updateIssuer(@PathVariable String id, @RequestBody CardIssuer issuer) {
        return service.updateIssuer(id, issuer);
    }

    @DeleteMapping("/{id}")
    public void deleteIssuer(@PathVariable String id) {
        service.deleteIssuer(id);
    }
}
