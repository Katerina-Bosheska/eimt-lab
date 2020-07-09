package mk.finki.labs.eimtlab.subscription.domain.repository;

import mk.finki.labs.eimtlab.subscription.domain.model.Plan;
import mk.finki.labs.eimtlab.subscription.domain.model.PlanId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, PlanId> {
}
