package com.owlinsight.owlinsight_english_language_service.bll.services;

import com.owlinsight.owlinsight_english_language_service.bll.interfaces.KnowledgeBase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RagService {
    private final KnowledgeBase knowledgeBase;

    public RagService(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public void ingest() {
        knowledgeBase.ingestGrammarReference();
    }

    @Bean
    CommandLineRunner ingestOnStartUp(RagService ragService) {
        return args -> ragService.ingest();
    }
}
