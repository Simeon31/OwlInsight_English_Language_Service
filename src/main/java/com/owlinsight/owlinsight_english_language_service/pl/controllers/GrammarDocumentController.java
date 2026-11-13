package com.owlinsight.owlinsight_english_language_service.pl.controllers;

import com.owlinsight.owlinsight_english_language_service.bll.services.GrammarDocumentService;
import com.owlinsight.owlinsight_english_language_service.domain.models.GrammarDocument;
import com.owlinsight.owlinsight_english_language_service.pl.dtos.GrammarDocumentRequest;
import com.owlinsight.owlinsight_english_language_service.pl.dtos.GrammarDocumentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grammar-documents")
public class GrammarDocumentController {
    private final GrammarDocumentService service;

    public GrammarDocumentController(GrammarDocumentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrammarDocumentResponse save(@RequestBody GrammarDocumentRequest request) {
        GrammarDocument document = new GrammarDocument(
                null, request.authors(), request.title(), request.content(),
                request.standardForm(), request.documentType(), null);
        return GrammarDocumentResponse.from(service.save(document));
    }

    @GetMapping("/{id}")
    public GrammarDocumentResponse findById(@PathVariable String id) {
        return GrammarDocumentResponse.from(service.findById(id));
    }

    @GetMapping
    public List<GrammarDocumentResponse> findAll() {
        return service.findAll().stream().map(GrammarDocumentResponse::from).toList();
    }
}
