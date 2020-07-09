package mk.finki.labs.eimtlab.articlemanagement.domain.repository;

import mk.finki.labs.eimtlab.articlemanagement.domain.model.Article;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.ArticleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArticleRepository extends JpaRepository<Article, ArticleId> {
}
