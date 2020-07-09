package mk.finki.labs.eimtlab.sharedkernel.domain.info;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Embeddable
public class Month implements ValueObject {

    // format MM
    private String month;
    // format yy
    private String year;

    public Month(){}

    public Month(String month, String year) {
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString(){
        return month + "/" + year;
    }

    public Date convertToDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        return simpleDateFormat.parse(this.month + "/" + this.year);
    }
}
