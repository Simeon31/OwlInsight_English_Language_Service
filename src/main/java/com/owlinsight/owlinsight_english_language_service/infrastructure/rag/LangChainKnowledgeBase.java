package com.owlinsight.owlinsight_english_language_service.infrastructure.rag;

import com.owlinsight.owlinsight_english_language_service.bll.interfaces.KnowledgeBase;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class LangChainKnowledgeBase implements KnowledgeBase {
    private final EmbeddingModel embeddingModel;
    private final EmbeddingStore<TextSegment> store;

    public LangChainKnowledgeBase(EmbeddingModel embeddingModel, EmbeddingStore<TextSegment> store) {
        this.embeddingModel = embeddingModel;
        this.store = store;
    }

    @Override
    public void ingestGrammarReference() {
        Document document = FileSystemDocumentLoader.loadDocument(
                Path.of("src/main/resources/docs/Cambridge_Grammar.pdf"),
                new ApachePdfBoxDocumentParser());
        DocumentSplitter splitter = DocumentSplitters.recursive(350, 150);
        EmbeddingStoreIngestor.builder()
                .documentSplitter(splitter)
                .embeddingModel(embeddingModel)
                .embeddingStore(store)
                .build()
                .ingest(document);
    }

    @Bean
    public ContentRetriever contentRetriever() {
        return EmbeddingStoreContentRetriever.builder()
                .embeddingModel(embeddingModel)
                .embeddingStore(store)
                .maxResults(4)
                .minScore(0.7)
                .build();
    }
}
