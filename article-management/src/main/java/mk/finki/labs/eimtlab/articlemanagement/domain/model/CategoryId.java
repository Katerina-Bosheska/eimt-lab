package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CategoryId extends DomainObjectId {

    private CategoryId(){
        super(DomainObjectId.randomId(CategoryId.class).toString());
    }

    @JsonCreator
    public CategoryId(String categoryId){
        super(categoryId);
    }
}
