package com.owlinsight.owlinsight_english_language_service.domain.models;

import com.owlinsight.owlinsight_english_language_service.domain.enums.IssueType;
import com.owlinsight.owlinsight_english_language_service.domain.enums.Severity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    private UUID suggestionId;
    private IssueType issueType;
    private Severity severity;
    private int startOffset;
    private int endOffset;
    private String suggestedText;
    private String explanation;
    private String userAction; // E.g. Accept, decline recommendation
    private Instant createdAt;
}
