package mk.finki.labs.eimtlab.transactionmanagement.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;
import mk.finki.labs.eimtlab.sharedkernel.domain.financial.Money;
import mk.finki.labs.eimtlab.sharedkernel.domain.info.Month;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Transaction extends AbstractEntity<TransactionId> {

    @Embedded
    @AttributeOverride(name="id", column = @Column(name="payer_id",nullable = false))
    private UserId payer;
    @Embedded
    private Money amount;

    private Date paidOn;
    @Embedded
    private Month paidFor;

    @SuppressWarnings("unused")
    private Transaction(){}

    public Transaction(UserId payer, Money amount, Date paidOn, Month paidFor) {
        super(DomainObjectId.randomId(TransactionId.class));
        this.payer = payer;
        this.amount = amount;
        this.paidOn = paidOn;
        this.paidFor = paidFor;
    }

    public Transaction(TransactionId id, UserId payer, Money amount, Date paidOn, Month paidFor) {
        super(id);
        this.payer = payer;
        this.amount = amount;
        this.paidOn = paidOn;
        this.paidFor = paidFor;
    }
}
