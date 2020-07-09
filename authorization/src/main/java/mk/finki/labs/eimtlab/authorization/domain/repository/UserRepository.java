package mk.finki.labs.eimtlab.authorization.domain.repository;

import mk.finki.labs.eimtlab.authorization.domain.model.User;
import mk.finki.labs.eimtlab.authorization.domain.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, UserId> {
}
