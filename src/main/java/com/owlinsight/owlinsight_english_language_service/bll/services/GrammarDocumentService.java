package com.owlinsight.owlinsight_english_language_service.bll.services;

import com.owlinsight.owlinsight_english_language_service.dal.interfaces.GrammarDocumentStore;
import com.owlinsight.owlinsight_english_language_service.domain.models.GrammarDocument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GrammarDocumentService {
    private final GrammarDocumentStore documents;

    public GrammarDocumentService(GrammarDocumentStore documents) {
        this.documents = documents;
    }

    public GrammarDocument save(GrammarDocument document) {
        if (document.getId() == null) {
            document.setId(UUID.randomUUID());
        }
        return documents.save(document);
    }

    public GrammarDocument findById(String id) {
        return documents.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Grammar document not found: " + id));
    }

    public List<GrammarDocument> findAll() {
        return documents.findAll();
    }
}
