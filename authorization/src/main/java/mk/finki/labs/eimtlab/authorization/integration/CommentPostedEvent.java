package mk.finki.labs.eimtlab.authorization.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.finki.labs.eimtlab.authorization.domain.model.AuthorId;
import mk.finki.labs.eimtlab.authorization.domain.model.CommentId;
import mk.finki.labs.eimtlab.authorization.domain.model.ArticleId;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Getter
public class CommentPostedEvent implements DomainEvent {

    @JsonProperty("commentId")
    private final CommentId commentId;

    @JsonProperty
    private final AuthorId articleAuthor;

    @JsonProperty
    private final AuthorId postedById;

    @JsonProperty
    private final String postedByName;

    @JsonProperty
    private final ArticleId articleId;

    @JsonProperty
    private final String articleTitle;

    @JsonProperty
    private final Date postedOn;

    @JsonProperty
    private final String activity;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    public CommentPostedEvent(CommentId commentId, AuthorId articleAuthor, AuthorId postedById, String postedByName, ArticleId articleId, String articleTitle, Date postedOn, String activity, Instant occurredOn) {
        this.commentId = commentId;
        this.articleAuthor = articleAuthor;
        this.postedById = postedById;
        this.postedByName = postedByName;
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.postedOn = postedOn;
        this.activity = activity;
        this.occurredOn = occurredOn;
    }

    @NonNull
    public CommentId commentId(){
        return commentId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
