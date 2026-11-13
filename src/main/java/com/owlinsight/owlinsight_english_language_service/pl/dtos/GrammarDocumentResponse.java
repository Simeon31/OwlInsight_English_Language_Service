package com.owlinsight.owlinsight_english_language_service.pl.dtos;

import com.owlinsight.owlinsight_english_language_service.domain.enums.DocumentType;
import com.owlinsight.owlinsight_english_language_service.domain.models.GrammarDocument;

import java.time.Instant;
import java.util.UUID;

public record GrammarDocumentResponse(
        UUID id,
        String authors,
        String title,
        String content,
        String standardForm,
        DocumentType documentType,
        Instant analyzedAt) {

    public static GrammarDocumentResponse from(GrammarDocument document) {
        return new GrammarDocumentResponse(
                document.getId(), document.getAuthors(), document.getTitle(), document.getContent(),
                document.getStandardForm(), document.getDocumentType(), document.getAnalyzedAt());
    }
}
