package com.owlinsight.owlinsight_english_language_service.pl.dtos;

import com.owlinsight.owlinsight_english_language_service.domain.enums.DocumentType;

public record GrammarDocumentRequest(
        String authors,
        String title,
        String content,
        String standardForm,
        DocumentType documentType) {
}
