package mk.finki.labs.eimtlab.articlemanagement.domain.repository;

import mk.finki.labs.eimtlab.articlemanagement.domain.model.Article;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.Comment;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.CommentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, CommentId> {

    List<Comment> findAllByArticle(Article article);
}
