package com.owlinsight.owlinsight_english_language_service.dal.documents;
import com.owlinsight.owlinsight_english_language_service.domain.enums.IssueType;
import com.owlinsight.owlinsight_english_language_service.domain.enums.Severity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import javax.print.DocFlavor;
import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("suggestion")
public class SuggestionRepository {
    @MongoId
    private String suggestionId;
    @Field
    private IssueType issueType;
    @Field
    private Severity severity;
    @Field
    private int startOffset;
    @Field
    private int endOffset;
    @Field
    private String suggestedText;
    @Field
    private String explanation;
    @Field
    private String userAction; // E.g. Accept, decline recommendation
    @Field
    private Instant createdAt;
}
