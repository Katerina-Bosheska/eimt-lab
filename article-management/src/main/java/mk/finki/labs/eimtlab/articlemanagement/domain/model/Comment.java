package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import lombok.Getter;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Comment extends AbstractEntity<CommentId> {

    @Embedded
    @AttributeOverride(name="id", column = @Column(name="author_id",nullable = false))
    private AuthorId author;
    @ManyToOne
    private Article article;

    private String text;

    private Date postedOn;

    @SuppressWarnings("unused")
    private Comment(){}

    public Comment(AuthorId author, String text, Date postedOn) {
        this.author = author;
        this.text = text;
        this.postedOn = postedOn;
    }

    public Comment(CommentId id, AuthorId author, String text, Date postedOn) {
        super(id);
        this.author = author;
        this.text = text;
        this.postedOn = postedOn;
    }
}
