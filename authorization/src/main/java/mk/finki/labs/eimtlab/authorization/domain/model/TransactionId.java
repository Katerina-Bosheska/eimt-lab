package mk.finki.labs.eimtlab.authorization.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionId extends DomainObjectId {

    private TransactionId(){
        super(DomainObjectId.randomId(TransactionId.class).toString());
    }

    @JsonCreator
    public TransactionId(String id) {
        super(id);
    }
}