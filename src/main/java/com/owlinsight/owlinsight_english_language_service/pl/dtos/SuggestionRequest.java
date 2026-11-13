package com.owlinsight.owlinsight_english_language_service.pl.dtos;

import com.owlinsight.owlinsight_english_language_service.domain.enums.IssueType;
import com.owlinsight.owlinsight_english_language_service.domain.enums.Severity;

public record SuggestionRequest(
        IssueType issueType,
        Severity severity,
        int startOffset,
        int endOffset,
        String suggestedText,
        String explanation,
        String userAction) {
}
