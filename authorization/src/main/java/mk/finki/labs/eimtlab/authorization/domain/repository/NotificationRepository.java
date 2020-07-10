package mk.finki.labs.eimtlab.authorization.domain.repository;

import mk.finki.labs.eimtlab.authorization.domain.model.Notification;
import mk.finki.labs.eimtlab.authorization.domain.model.NotificationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, NotificationId> {
}
