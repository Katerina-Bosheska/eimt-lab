package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;

    public Category(){
        this.articles = new ArrayList<>();
    }

    public Category(String name, List<Article> articles) {
        this.name = name;
        this.articles = articles;
    }
}
