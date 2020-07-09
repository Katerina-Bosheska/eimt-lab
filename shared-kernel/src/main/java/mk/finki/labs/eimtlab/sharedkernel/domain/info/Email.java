package mk.finki.labs.eimtlab.sharedkernel.domain.info;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class Email implements ValueObject {

    private final String address;

    public Email(){
        this.address = "";
    }

    public Email(@NonNull String address) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        if(!address.matches(regex)){
            throw new IllegalArgumentException("E-mail address is invalid");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
