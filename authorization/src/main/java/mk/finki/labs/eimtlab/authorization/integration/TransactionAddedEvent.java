package mk.finki.labs.eimtlab.authorization.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.finki.labs.eimtlab.authorization.domain.model.TransactionId;
import mk.finki.labs.eimtlab.authorization.domain.model.UserId;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

@Getter
public class TransactionAddedEvent implements DomainEvent {

    @JsonProperty("transactionId")
    private final TransactionId transactionId;

    @JsonProperty("userId")
    private final UserId userId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public TransactionAddedEvent(@JsonProperty("transactionId") @NonNull TransactionId transactionId,
                            @JsonProperty("userId") @NonNull UserId userId,
                            @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.transactionId = Objects.requireNonNull(transactionId, "transactionId must not be null");
        this.userId = Objects.requireNonNull(userId, "userId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public TransactionId transactionId() {
        return transactionId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
