package com.Trello.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Collection;

/*@EnableMongoRepositories(basePackages = "com.Trello.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    protected Collection<String> getMappingBasePackages(){
        return Arrays.asList("com.Trello");
    }
}*/
