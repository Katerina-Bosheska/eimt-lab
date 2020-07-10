package mk.finki.labs.eimtlab.authorization.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainEvent;
import mk.finki.labs.eimtlab.sharedkernel.infrastructure.eventlog.RemoteEventTranslator;
import mk.finki.labs.eimtlab.sharedkernel.infrastructure.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentPostedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    public CommentPostedEventTranslator(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.finki.labs.eimtlab.articlemanagement.domain.event.CommentPosted");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, CommentPostedEvent.class));
    }
}
