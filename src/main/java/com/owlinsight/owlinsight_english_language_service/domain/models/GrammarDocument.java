package com.owlinsight.owlinsight_english_language_service.domain.models;

import com.owlinsight.owlinsight_english_language_service.domain.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrammarDocument {
    private UUID id;
    private String authors;
    private String title;
    private String content;
    private String standardForm; // E.g. British, American English
    private DocumentType documentType;
    private Instant analyzedAt;
}
