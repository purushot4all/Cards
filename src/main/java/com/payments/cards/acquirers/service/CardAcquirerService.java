package com.payments.cards.acquirers.service;

import com.mongodb.MongoClientSettings;
import com.payments.cards.acquirers.model.CardAcquirer;
import com.payments.cards.acquirers.repo.CardAcquirerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardAcquirerService {
    private final CardAcquirerRepository repository;



    public CardAcquirerService(CardAcquirerRepository repository) {
        this.repository = repository;

    }

    public List<CardAcquirer> getAllAcquirers() {
        return repository.findAll();
    }

    public CardAcquirer getAcquirerById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Acquirer not found"));
    }

    public CardAcquirer createAcquirer(CardAcquirer acquirer) {
        return repository.save(acquirer);
    }

    public CardAcquirer updateAcquirer(String id, CardAcquirer acquirer) {
        CardAcquirer existingAcquirer = getAcquirerById(id);
        existingAcquirer.setName(acquirer.getName());
        existingAcquirer.setCountry(acquirer.getCountry());
        existingAcquirer.setContactInfo(acquirer.getContactInfo());
        return repository.save(existingAcquirer);
    }

    public void deleteAcquirer(String id) {
        repository.deleteById(id);
    }
}
