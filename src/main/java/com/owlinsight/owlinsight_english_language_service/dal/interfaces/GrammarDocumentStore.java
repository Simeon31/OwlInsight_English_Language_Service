package com.owlinsight.owlinsight_english_language_service.dal.interfaces;

import com.owlinsight.owlinsight_english_language_service.domain.models.GrammarDocument;

import java.util.List;
import java.util.Optional;

public interface GrammarDocumentStore {
    GrammarDocument save(GrammarDocument document);

    Optional<GrammarDocument> findById(String id);

    List<GrammarDocument> findAll();
}
