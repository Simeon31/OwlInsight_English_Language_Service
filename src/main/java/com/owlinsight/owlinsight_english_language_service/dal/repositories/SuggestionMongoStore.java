package com.owlinsight.owlinsight_english_language_service.dal.repositories;

import com.owlinsight.owlinsight_english_language_service.dal.documents.SuggestionMongoRepository;
import com.owlinsight.owlinsight_english_language_service.dal.documents.SuggestionRepository;
import com.owlinsight.owlinsight_english_language_service.dal.interfaces.SuggestionStore;
import com.owlinsight.owlinsight_english_language_service.domain.models.Suggestion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SuggestionMongoStore implements SuggestionStore {
    private final SuggestionMongoRepository repository;

    public SuggestionMongoStore(SuggestionMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Suggestion save(Suggestion suggestion) {
        return toModel(repository.save(toDocument(suggestion)));
    }

    @Override
    public Optional<Suggestion> findById(String id) {
        return repository.findById(id).map(this::toModel);
    }

    @Override
    public List<Suggestion> findAll() {
        return repository.findAll().stream().map(this::toModel).toList();
    }

    private SuggestionRepository toDocument(Suggestion model) {
        return new SuggestionRepository(
                model.getSuggestionId() == null ? null : model.getSuggestionId().toString(),
                model.getIssueType(), model.getSeverity(), model.getStartOffset(),
                model.getEndOffset(), model.getSuggestedText(), model.getExplanation(),
                model.getUserAction(), model.getCreatedAt());
    }

    private Suggestion toModel(SuggestionRepository document) {
        return new Suggestion(
                document.getSuggestionId() == null ? null : UUID.fromString(document.getSuggestionId()),
                document.getIssueType(), document.getSeverity(), document.getStartOffset(),
                document.getEndOffset(), document.getSuggestedText(), document.getExplanation(),
                document.getUserAction(), document.getCreatedAt());
    }
}
