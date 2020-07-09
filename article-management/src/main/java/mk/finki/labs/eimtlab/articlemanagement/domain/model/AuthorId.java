package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class AuthorId extends DomainObjectId {

    private AuthorId(){
        super(DomainObjectId.randomId(AuthorId.class).toString());
    }

    @JsonCreator
    public AuthorId(String id) {
        super(id);
    }
}