package com.owlinsight.owlinsight_english_language_service.dal.documents;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GrammarDocumentMongoRepository
        extends MongoRepository<GrammarDocumentRepository, String> {
}
