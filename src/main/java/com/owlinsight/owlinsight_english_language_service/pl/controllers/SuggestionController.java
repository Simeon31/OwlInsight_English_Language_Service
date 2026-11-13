package com.owlinsight.owlinsight_english_language_service.pl.controllers;

import com.owlinsight.owlinsight_english_language_service.bll.services.SuggestionService;
import com.owlinsight.owlinsight_english_language_service.domain.models.Suggestion;
import com.owlinsight.owlinsight_english_language_service.pl.dtos.SuggestionRequest;
import com.owlinsight.owlinsight_english_language_service.pl.dtos.SuggestionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {
    private final SuggestionService service;

    public SuggestionController(SuggestionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuggestionResponse save(@RequestBody SuggestionRequest request) {
        Suggestion suggestion = new Suggestion(
                null, request.issueType(), request.severity(), request.startOffset(),
                request.endOffset(), request.suggestedText(), request.explanation(),
                request.userAction(), null);
        return SuggestionResponse.from(service.save(suggestion));
    }

    @GetMapping
    public List<SuggestionResponse> findAll() {
        return service.findAll().stream().map(SuggestionResponse::from).toList();
    }
}
