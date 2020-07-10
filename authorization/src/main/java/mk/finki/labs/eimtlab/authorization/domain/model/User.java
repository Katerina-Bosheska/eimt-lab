package mk.finki.labs.eimtlab.authorization.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;
import mk.finki.labs.eimtlab.sharedkernel.domain.info.Email;
import mk.finki.labs.eimtlab.sharedkernel.domain.info.Image;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @SuppressWarnings("unused")
    private User(){}

    public User(UserId userId, String name, String email, String country){
        super(userId);
        this.name = name;
        this.email = new Email(email);
        this.country = country;
        this.profilePic = new Image();
        this.creditCard = null;
        this.status = Status.Invalid;
        this.notifications = new ArrayList<>();
    }

    public User(String name, String email, String country){
        super(DomainObjectId.randomId(UserId.class));
        this.name = name;
        this.email = new Email(email);
        this.country = country;
        this.profilePic = new Image();
        this.creditCard = null;
        this.status = Status.Invalid;
        this.notifications = new ArrayList<>();
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void addNewNotificaion(Notification notification){
        this.notifications.add(notification);
    }

}
