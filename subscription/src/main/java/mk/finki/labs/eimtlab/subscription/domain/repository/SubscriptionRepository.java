package mk.finki.labs.eimtlab.subscription.domain.repository;

import mk.finki.labs.eimtlab.subscription.domain.model.Subscription;
import mk.finki.labs.eimtlab.subscription.domain.model.SubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {
}
