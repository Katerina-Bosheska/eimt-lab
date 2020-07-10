package mk.finki.labs.eimtlab.articlemanagement.application.form;

import com.sun.istack.NotNull;
import lombok.Getter;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.Article;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.AuthorId;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Date;

@Getter
public class CommentForm implements Serializable {

    @NonNull
    private AuthorId authorId;

    private String authorName;

    @NonNull
    private String text;

    private Date postedOn;

    public CommentForm(AuthorId authorId, String authorName, String text){
        this.authorId = authorId;
        this.authorName = authorName;
        this.text = text;
        this.postedOn = new Date();
    }
}
