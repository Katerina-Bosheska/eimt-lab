package mk.finki.labs.eimtlab.sharedkernel.domain.financial;

import lombok.Getter;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.ValueObject;
import net.bytebuddy.pool.TypePool;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private final Currency currency;

    private final double amount;

    public Money(@NonNull Currency currency, @NonNull double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    private Money() {
        this.currency=null;
        this.amount = 0;
    }

    public Money convertFromUsdToEur(){
        if(this.currency.equals(Currency.EUR))
            throw new IllegalArgumentException("Currency is already EUR");
        return new Money(Currency.EUR, this.amount * 0.88);
    }

    public Money convertFromEurToUsd(){
        if(this.currency.equals(Currency.USD))
            throw new IllegalArgumentException("Currency is already EUR");
        return new Money(Currency.USD, this.amount * 1.13);
    }

}
