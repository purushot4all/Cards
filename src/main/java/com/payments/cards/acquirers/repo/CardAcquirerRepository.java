package com.payments.cards.acquirers.repo;

import com.payments.cards.acquirers.model.CardAcquirer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CardAcquirerRepository extends MongoRepository<CardAcquirer, String> {}
