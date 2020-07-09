package mk.finki.labs.eimtlab.authorization.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Embeddable
public class CreditCard implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private CreditCardType type;

    private Date expirationDate;

    private String ownerName;

    private String cardNumber;

    private String securityNumber;

    public CreditCard(){

    }

    public CreditCard(CreditCardType type, String expirationDate, String ownerName,
                      String cardNumber, String securityNumber) throws ParseException {
        if(cardNumber.equals("") || cardNumber == null){
            throw new IllegalArgumentException("Invalid card number");
        }
        if(securityNumber.equals("") || securityNumber == null){
            throw new IllegalArgumentException("Invalid security number");
        }
        if(ownerName.equals("") || ownerName == null){
            throw new IllegalArgumentException("Invalid credit card information");
        }

        this.type = type;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.securityNumber = securityNumber;
        this.expirationDate = convertToDate(expirationDate);
    }

    public Date convertToDate(String dateInput) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        return simpleDateFormat.parse(dateInput);
    }


}