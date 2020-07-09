package mk.finki.labs.eimtlab.sharedkernel.infrastructure.eventlog;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RemoteEventTranslator {

    boolean supports(StoredDomainEvent storedDomainEvent);

    Optional<DomainEvent> translate(StoredDomainEvent remoteEvent);
}
