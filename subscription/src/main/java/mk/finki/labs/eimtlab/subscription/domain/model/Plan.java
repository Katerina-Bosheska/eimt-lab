package mk.finki.labs.eimtlab.subscription.domain.model;

import lombok.Getter;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;
import mk.finki.labs.eimtlab.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Plan extends AbstractEntity<PlanId> {

    @Enumerated(value = EnumType.STRING)
    private PlanName name;
    @Embedded
    private Money pricePerMonth;

    private Integer articlesPerMonth;

    @OneToMany(mappedBy = "plan")
    private List<Subscription> subscriptions;

    public Plan(){}

    public Plan(PlanName name, Money pricePerMonth, Integer articlesPerMonth, List<Subscription> subscriptions) {
        super(DomainObjectId.randomId(PlanId.class));
        this.name = name;
        this.pricePerMonth = pricePerMonth;
        this.articlesPerMonth = articlesPerMonth;
        this.subscriptions = subscriptions;
    }

    public Plan(PlanId id, PlanName name, Money pricePerMonth, Integer articlesPerMonth, List<Subscription> subscriptions) {
        super(id);
        this.name = name;
        this.pricePerMonth = pricePerMonth;
        this.articlesPerMonth = articlesPerMonth;
        this.subscriptions = subscriptions;
    }
}
