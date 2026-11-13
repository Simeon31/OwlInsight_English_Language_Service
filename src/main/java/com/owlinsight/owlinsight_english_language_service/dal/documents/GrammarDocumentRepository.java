package com.owlinsight.owlinsight_english_language_service.dal.documents;

import com.owlinsight.owlinsight_english_language_service.domain.enums.DocumentType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("english-documentary")
public class GrammarDocumentRepository {
    @MongoId
    private String id;
    @Field
    private String authors;
    @Field
    private String title;
    @Field
    private String content;
    @Field
    private String standardForm; // E.g. British, American English
    @Field
    private DocumentType documentType;
    @Field
    private Instant analyzedAt;
}
