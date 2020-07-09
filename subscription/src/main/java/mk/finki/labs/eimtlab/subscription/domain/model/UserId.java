package mk.finki.labs.eimtlab.subscription.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {

    public UserId(){
        super(DomainObjectId.randomId(UserId.class).toString());
    }

    public UserId(String id) {
        super(id);
    }
}
