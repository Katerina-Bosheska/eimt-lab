package mk.finki.labs.eimtlab.articlemanagement.port;

import mk.finki.labs.eimtlab.articlemanagement.application.ArticleService;
import mk.finki.labs.eimtlab.articlemanagement.application.form.CommentForm;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/comments/post")
    public CommentId postComment(){
        AuthorId authorId = new AuthorId("authorOfComment");
        ArticleId articleId = new ArticleId("articleId");
        CommentForm commentForm = new CommentForm(authorId, "authorName", "cool post");
        return articleService.postComment(commentForm, articleId);
    }

    @GetMapping("/comments")
    public List<Comment> getArticleComments(){
        return articleService.getArticleComments(new ArticleId("articleId"));
    }
}
