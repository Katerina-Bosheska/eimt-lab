package mk.finki.labs.eimtlab.sharedkernel.domain.base;

import mk.finki.labs.eimtlab.sharedkernel.infrastructure.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
