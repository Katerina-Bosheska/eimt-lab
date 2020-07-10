package mk.finki.labs.eimtlab.articlemanagement;

import lombok.NonNull;
import mk.finki.labs.eimtlab.articlemanagement.domain.model.*;
import mk.finki.labs.eimtlab.articlemanagement.domain.repository.ArticleRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataGenerator {

    private final ArticleRepository articleRepository;

    DataGenerator(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @PostConstruct
    @Transactional
    public void generateData() {
        List<Article> articles = new ArrayList<>();
        AuthorId authorId = new AuthorId("kate1");
        articles.add(new Article(new ArticleId("articleId"), authorId, "authorArticleName", "articleTitle", "articleText", new Date(), false));
        articleRepository.saveAll(articles);
}

}