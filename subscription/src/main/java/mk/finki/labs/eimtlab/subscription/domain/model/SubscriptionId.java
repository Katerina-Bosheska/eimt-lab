package mk.finki.labs.eimtlab.subscription.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class SubscriptionId extends DomainObjectId {

    private SubscriptionId(){
        super(DomainObjectId.randomId(SubscriptionId.class).toString());
    }

    @JsonCreator
    public SubscriptionId(String id) {
        super(id);
    }
}
