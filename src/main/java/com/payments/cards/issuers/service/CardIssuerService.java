package com.payments.cards.issuers.service;

import com.mongodb.MongoClientSettings;
import com.payments.cards.issuers.model.CardIssuer;
import com.payments.cards.issuers.repo.CardIssuerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardIssuerService {
    private final CardIssuerRepository repository;

    public CardIssuerService(CardIssuerRepository repository) {
        this.repository = repository;
    }

    public List<CardIssuer> getAllIssuers() {
        return repository.findAll();
    }

    public CardIssuer getIssuerById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Issuer not found"));
    }

    public CardIssuer createIssuer(CardIssuer issuer) {
        return repository.save(issuer);
    }

    public CardIssuer updateIssuer(String id, CardIssuer issuer) {
        CardIssuer existingIssuer = getIssuerById(id);
        existingIssuer.setName(issuer.getName());
        existingIssuer.setIssuingBank(issuer.getIssuingBank());
        existingIssuer.setCountry(issuer.getCountry());
        existingIssuer.setContactInfo(issuer.getContactInfo());
        return repository.save(existingIssuer);
    }

    public void deleteIssuer(String id) {
        repository.deleteById(id);
    }
}
