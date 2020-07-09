package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ArticleId extends DomainObjectId {

    private ArticleId(){
        super(DomainObjectId.randomId(ArticleId.class).toString());
    }

    @JsonCreator
    public ArticleId(String articleId){
        super(articleId);
    }
}
