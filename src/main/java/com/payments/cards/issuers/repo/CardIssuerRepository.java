package com.payments.cards.issuers.repo;

import com.payments.cards.issuers.model.CardIssuer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CardIssuerRepository extends MongoRepository<CardIssuer, String> {}
