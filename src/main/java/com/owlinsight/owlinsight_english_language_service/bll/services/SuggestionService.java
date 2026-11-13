package com.owlinsight.owlinsight_english_language_service.bll.services;

import com.owlinsight.owlinsight_english_language_service.dal.interfaces.SuggestionStore;
import com.owlinsight.owlinsight_english_language_service.domain.models.Suggestion;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class SuggestionService {
    private final SuggestionStore suggestions;

    public SuggestionService(SuggestionStore suggestions) {
        this.suggestions = suggestions;
    }

    public Suggestion save(Suggestion suggestion) {
        if (suggestion.getSuggestionId() == null) {
            suggestion.setSuggestionId(UUID.randomUUID());
        }
        if (suggestion.getCreatedAt() == null) {
            suggestion.setCreatedAt(Instant.now());
        }
        return suggestions.save(suggestion);
    }

    public List<Suggestion> findAll() {
        return suggestions.findAll();
    }
}
