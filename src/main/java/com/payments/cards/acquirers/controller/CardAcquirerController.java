package com.payments.cards.acquirers.controller;

import com.payments.cards.acquirers.model.CardAcquirer;
import com.payments.cards.acquirers.service.CardAcquirerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/card-acquirers")
public class CardAcquirerController {

    @Autowired
    private final CardAcquirerService service;

    public CardAcquirerController(CardAcquirerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CardAcquirer> getAllAcquirers() {
        return service.getAllAcquirers();
    }

    @GetMapping("/{id}")
    public CardAcquirer getAcquirerById(@PathVariable String id) {
        return service.getAcquirerById(id);
    }

    @PostMapping
    public CardAcquirer createAcquirer(@RequestBody CardAcquirer acquirer) {
        return service.createAcquirer(acquirer);
    }

    @PutMapping("/{id}")
    public CardAcquirer updateAcquirer(@PathVariable String id, @RequestBody CardAcquirer acquirer) {
        return service.updateAcquirer(id, acquirer);
    }

    @DeleteMapping("/{id}")
    public void deleteAcquirer(@PathVariable String id) {
        service.deleteAcquirer(id);
    }
}
