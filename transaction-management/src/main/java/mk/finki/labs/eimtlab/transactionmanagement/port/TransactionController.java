package mk.finki.labs.eimtlab.transactionmanagement.port;

import mk.finki.labs.eimtlab.sharedkernel.domain.financial.Currency;
import mk.finki.labs.eimtlab.sharedkernel.domain.financial.Money;
import mk.finki.labs.eimtlab.sharedkernel.domain.info.Month;
import mk.finki.labs.eimtlab.transactionmanagement.application.TransactionService;
import mk.finki.labs.eimtlab.transactionmanagement.domain.model.Transaction;
import mk.finki.labs.eimtlab.transactionmanagement.domain.model.TransactionId;
import mk.finki.labs.eimtlab.transactionmanagement.domain.model.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public TransactionId createTransaction(){
        Money paid = new Money(Currency.EUR, 120);
        Month month = new Month("06","2020");
        Transaction transaction = new Transaction(new UserId("kate1"), paid, new Date(), month);
        return transactionService.createTransaction(transaction);
    }
}
