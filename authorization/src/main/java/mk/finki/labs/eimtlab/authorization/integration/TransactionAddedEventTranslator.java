package mk.finki.labs.eimtlab.authorization.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainEvent;
import mk.finki.labs.eimtlab.sharedkernel.infrastructure.eventlog.RemoteEventTranslator;
import mk.finki.labs.eimtlab.sharedkernel.infrastructure.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class TransactionAddedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    TransactionAddedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent remoteEvent) {
        return remoteEvent.domainEventClassName().equals("mk.finki.labs.eimtlab.authorization.integration.TransactionAddedEvent");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, TransactionAddedEvent.class));
    }
}
