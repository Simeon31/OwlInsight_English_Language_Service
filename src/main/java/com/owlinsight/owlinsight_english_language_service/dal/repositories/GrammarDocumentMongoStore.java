package com.owlinsight.owlinsight_english_language_service.dal.repositories;

import com.owlinsight.owlinsight_english_language_service.dal.documents.GrammarDocumentMongoRepository;
import com.owlinsight.owlinsight_english_language_service.dal.documents.GrammarDocumentRepository;
import com.owlinsight.owlinsight_english_language_service.dal.interfaces.GrammarDocumentStore;
import com.owlinsight.owlinsight_english_language_service.domain.models.GrammarDocument;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GrammarDocumentMongoStore implements GrammarDocumentStore {
    private final GrammarDocumentMongoRepository repository;

    public GrammarDocumentMongoStore(GrammarDocumentMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public GrammarDocument save(GrammarDocument document) {
        GrammarDocumentRepository saved = repository.save(toDocument(document));
        return toModel(saved);
    }

    @Override
    public Optional<GrammarDocument> findById(String id) {
        return repository.findById(id).map(this::toModel);
    }

    @Override
    public List<GrammarDocument> findAll() {
        return repository.findAll().stream().map(this::toModel).toList();
    }

    private GrammarDocumentRepository toDocument(GrammarDocument model) {
        return new GrammarDocumentRepository(
                model.getId() == null ? null : model.getId().toString(),
                model.getAuthors(), model.getTitle(), model.getContent(),
                model.getStandardForm(), model.getDocumentType(), model.getAnalyzedAt());
    }

    private GrammarDocument toModel(GrammarDocumentRepository document) {
        return new GrammarDocument(
                document.getId() == null ? null : UUID.fromString(document.getId()),
                document.getAuthors(), document.getTitle(), document.getContent(),
                document.getStandardForm(), document.getDocumentType(), document.getAnalyzedAt());
    }
}
