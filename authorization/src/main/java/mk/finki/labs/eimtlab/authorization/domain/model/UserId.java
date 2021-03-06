package mk.finki.labs.eimtlab.authorization.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {

    private UserId(){
        super(DomainObjectId.randomId(UserId.class).toString());
    }

    @JsonCreator
    public UserId(String id) {
        super(id);
    }
}
