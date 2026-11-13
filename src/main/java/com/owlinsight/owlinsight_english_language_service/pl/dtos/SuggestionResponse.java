package com.owlinsight.owlinsight_english_language_service.pl.dtos;

import com.owlinsight.owlinsight_english_language_service.domain.enums.IssueType;
import com.owlinsight.owlinsight_english_language_service.domain.enums.Severity;
import com.owlinsight.owlinsight_english_language_service.domain.models.Suggestion;

import java.time.Instant;
import java.util.UUID;

public record SuggestionResponse(
        UUID suggestionId,
        IssueType issueType,
        Severity severity,
        int startOffset,
        int endOffset,
        String suggestedText,
        String explanation,
        String userAction,
        Instant createdAt) {

    public static SuggestionResponse from(Suggestion suggestion) {
        return new SuggestionResponse(
                suggestion.getSuggestionId(), suggestion.getIssueType(), suggestion.getSeverity(),
                suggestion.getStartOffset(), suggestion.getEndOffset(), suggestion.getSuggestedText(),
                suggestion.getExplanation(), suggestion.getUserAction(), suggestion.getCreatedAt());
    }
}
