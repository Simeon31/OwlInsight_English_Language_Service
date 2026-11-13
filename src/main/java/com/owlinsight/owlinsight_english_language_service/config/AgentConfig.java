package com.owlinsight.owlinsight_english_language_service.config;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgentConfig {
    @Value("${ollama.base-url:http://localhost:11434}")
    private String baseUrl;

    @Value("${embedding-model.model-name}")
    private String embeddingModel;

    @Bean
    public EmbeddingModel embeddingModel(){
        return OllamaEmbeddingModel.builder()
                .baseUrl(baseUrl)
                .modelName(embeddingModel)
                .build();
    }
}
