package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import lombok.Getter;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Comment extends AbstractEntity<CommentId> {

    @Embedded
    @AttributeOverride(name="id", column = @Column(name="author_id",nullable = false))
    private AuthorId authorId;
    @ManyToOne
    private Article article;

    private String authorName;

    private String text;

    private Date postedOn;

    @SuppressWarnings("unused")
    private Comment(){}

    public Comment(AuthorId author, Article article, String authorName, String text, Date postedOn) {
        super(DomainObjectId.randomId(CommentId.class));
        this.authorId = author;
        this.article = article;
        this.text = text;
        this.authorName = authorName;
        this.postedOn = postedOn;
    }

    public Comment(CommentId id, AuthorId author, Article article, String authorName, String text, Date postedOn) {
        super(id);
        this.authorId = author;
        this.article = article;
        this.text = text;
        this.authorName = authorName;
        this.postedOn = postedOn;
    }
}
