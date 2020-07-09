package mk.finki.labs.eimtlab.subscription.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class PlanId extends DomainObjectId {

    private PlanId(){
        super(DomainObjectId.randomId(PlanId.class).toString());
    }

    @JsonCreator
    public PlanId(String id) {
        super(id);
    }
}
