package com.payments.cards.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.payments.cards.issuers.repo", "com.payments.cards.acquirers.repo"},
        mongoTemplateRef = "primaryMongoTemplate")

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    @Primary
    public MongoTemplate primaryMongoTemplate() {
        return new MongoTemplate(
                MongoClients.create(
                        MongoClientSettings.builder()
                                .applyConnectionString(new ConnectionString(mongoUri))
                                .build()
                ),
                database
        );
    }
}
