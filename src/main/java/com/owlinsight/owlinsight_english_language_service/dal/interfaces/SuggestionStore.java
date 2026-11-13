package com.owlinsight.owlinsight_english_language_service.dal.interfaces;

import com.owlinsight.owlinsight_english_language_service.domain.models.Suggestion;

import java.util.List;
import java.util.Optional;

public interface SuggestionStore {
    Suggestion save(Suggestion suggestion);

    Optional<Suggestion> findById(String id);

    List<Suggestion> findAll();
}
