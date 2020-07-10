package mk.finki.labs.eimtlab.articlemanagement.application;

import lombok.Getter;
import mk.finki.labs.eimtlab.articlemanagement.application.form.CommentForm;
import mk.finki.labs.eimtlab.articlemanagement.domain.event.CommentPosted;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.Article;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.ArticleId;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.Comment;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.CommentId;
import mk.finki.labs.eimtlab.articlemanagement.domain.repository.ArticleRepository;
import mk.finki.labs.eimtlab.articlemanagement.domain.repository.CommentRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final CommentRepository commentRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public ArticleService(ArticleRepository articleRepository,
                          CommentRepository commentRepository,
                          ApplicationEventPublisher applicationEventPublisher){
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public CommentId postComment(@NonNull CommentForm commentForm, @NonNull ArticleId articleId){

        // na koja statija se postira komentarot
        Optional<Article> opt = articleRepository.findById(articleId);
        Article article = opt.get();

        Comment comment = new Comment(commentForm.getAuthorId(), article, commentForm.getAuthorName(), commentForm.getText(), commentForm.getPostedOn());

        Comment newComment = commentRepository.save(comment);

        applicationEventPublisher.publishEvent(
                new CommentPosted(newComment.id(),
                        article.getAuthorId(),
                        newComment.getAuthorId(),
                        newComment.getAuthorName(),
                        articleId,
                        article.getTitle(),
                        newComment.getPostedOn(),
                        "commented on your article",
                        newComment.getPostedOn().toInstant()));

        return newComment.id();
    }

    public List<Comment> getArticleComments(@NonNull ArticleId articleId){
        Optional<Article> opt = articleRepository.findById(articleId);
        Article article = opt.get();
        return commentRepository.findAllByArticle(article);
    }

}
