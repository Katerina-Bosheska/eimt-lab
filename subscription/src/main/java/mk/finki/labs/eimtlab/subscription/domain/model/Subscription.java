package mk.finki.labs.eimtlab.subscription.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription extends AbstractEntity<SubscriptionId> {

    @AttributeOverride(name="id", column = @Column(name="user_id",nullable = false))
    private UserId userId;
//    @AttributeOverride(name="id", column = @Column(name="plan_id",nullable = false))
//    private PlanId planId;

    @ManyToOne
    private Plan plan;

    private Date validFrom;

    private boolean valid;

    private Subscription(){}

    public Subscription(UserId userId, Plan plan, Date validFrom, boolean valid) {
        super(DomainObjectId.randomId(SubscriptionId.class));
        this.userId = userId;
        this.plan = plan;
        this.validFrom = validFrom;
        this.valid = valid;
    }

    public Subscription(SubscriptionId id, UserId userId, Plan plan, Date validFrom, boolean valid) {
        super(id);
        this.userId = userId;
        this.plan = plan;
        this.validFrom = validFrom;
        this.valid = valid;
    }

    public void removeSubscription(){
        this.valid = false;
    }

    public void addSubscription(Plan plan, Date validFrom){
        this.plan = plan;
        this.valid = true;
        this.validFrom = validFrom;
    }
}
