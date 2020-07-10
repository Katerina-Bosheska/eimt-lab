package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends AbstractEntity<CategoryId> {

    @Column(name="category_name")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;

    @SuppressWarnings("unused")
    private Category(){}

    public Category(String name, List<Article> articles) {
        super(DomainObjectId.randomId(CategoryId.class));
        this.name = name;
        this.articles = articles;
    }

    public Category(String name){
        super(DomainObjectId.randomId(CategoryId.class));
        this.name = name;
        this.articles = new ArrayList<>();
    }

    public Category(CategoryId categoryId, String name){
        super(categoryId);
        this.name = name;
        this.articles = new ArrayList<>();
    }
}
