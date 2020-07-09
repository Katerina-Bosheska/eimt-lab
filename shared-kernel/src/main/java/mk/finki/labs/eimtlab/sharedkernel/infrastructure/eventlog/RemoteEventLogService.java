package mk.finki.labs.eimtlab.sharedkernel.infrastructure.eventlog;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.RemoteEventLog;
import org.springframework.stereotype.Service;

@Service
public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
