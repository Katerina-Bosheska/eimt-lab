package mk.finki.labs.eimtlab.authorization.domain.model;

import lombok.Getter;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;
import mk.finki.labs.eimtlab.sharedkernel.domain.info.Email;
import mk.finki.labs.eimtlab.sharedkernel.domain.info.Image;


import javax.persistence.*;

@Entity
@Getter
public class User extends AbstractEntity<UserId> {

    @Column(nullable = false)
    private String name;
    @Embedded
    private Email email;
    @Embedded
    private Image profilePic;
    @Embedded
    private CreditCard creditCard;

    private String country;

    private String bio;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    private String subscriptionPlanId;

    public User(){}

    public User(UserId userId, String name, String email, String country){
        super(userId);
        this.name = name;
        this.email = new Email(email);
        this.country = country;
        this.profilePic = new Image();
        this.creditCard = null;
        this.status = Status.Invalid;
    }

    public User(String name, String email, String country){
        super(DomainObjectId.randomId(UserId.class));
        this.name = name;
        this.email = new Email(email);
        this.country = country;
        this.profilePic = new Image();
        this.creditCard = null;
        this.status = Status.Invalid;
    }

}
