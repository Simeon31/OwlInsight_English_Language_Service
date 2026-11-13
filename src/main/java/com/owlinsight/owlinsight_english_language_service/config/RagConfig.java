package com.owlinsight.owlinsight_english_language_service.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.mongodb.MongoDbEmbeddingStore;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RagConfig {
    @Value("${mongodb.uri}")
    private String mongoUri;

    @Value("${mongodb.database:owlinsight}")
    private String databaseName;

    @Value("${mongodb.collection:documents}")
    private String collectionName;

    @Value("${mongodb.vector-index:vector_index}")
    private String vectorIndexName;

    @Bean(destroyMethod = "close")
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public EmbeddingStore<TextSegment> embeddingStore(MongoClient mongoClient) {
        return MongoDbEmbeddingStore.builder()
                .fromClient(mongoClient)
                .databaseName(databaseName)
                .collectionName(collectionName)
                .indexName(vectorIndexName)
                .createIndex(false)
                .build();
    }
}
