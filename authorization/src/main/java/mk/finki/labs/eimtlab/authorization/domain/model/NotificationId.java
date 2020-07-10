package mk.finki.labs.eimtlab.authorization.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class NotificationId extends DomainObjectId {

    public NotificationId(){
        super(DomainObjectId.randomId(NotificationId.class).toString());
    }

    public NotificationId(String id) {
        super(id);
    }
}
