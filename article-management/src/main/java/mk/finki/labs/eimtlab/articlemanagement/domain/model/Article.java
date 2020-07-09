package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import lombok.Getter;

import lombok.NonNull;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import java.util.Date;

@Entity
@Getter
public class Article extends AbstractEntity<ArticleId> {

    @Embedded
    @AttributeOverride(name="id", column = @Column(name="author_id",nullable = false))
    private AuthorId authorId;

    private String authorName;

    private String title;

    private String text;

    private Date postedOn;

    private Integer likes;

    private boolean premium;

    public Article(@NonNull AuthorId authorId, String authorName, String title, String text, Date postedOn, boolean premium) {
        super(DomainObjectId.randomId(ArticleId.class));
        this.authorId = authorId;
        this.authorName = authorName;
        this.title = title;
        this.text = text;
        this.postedOn = postedOn;
        this.likes = 0;
        this.premium = premium;
    }

    public Article(ArticleId articleId, @NonNull AuthorId authorId, String authorName, String title, String text, Date postedOn, boolean premium) {
        super(articleId);
        this.authorId = authorId;
        this.authorName = authorName;
        this.title = title;
        this.text = text;
        this.postedOn = postedOn;
        this.likes = 0;
        this.premium = premium;
    }

    public Article(){
    }


}
