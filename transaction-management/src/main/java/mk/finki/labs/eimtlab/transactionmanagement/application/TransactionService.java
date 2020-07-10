package mk.finki.labs.eimtlab.transactionmanagement.application;

import lombok.var;
import mk.finki.labs.eimtlab.transactionmanagement.domain.event.TransactionAdded;
import mk.finki.labs.eimtlab.transactionmanagement.domain.model.Transaction;
import mk.finki.labs.eimtlab.transactionmanagement.domain.model.TransactionId;
import mk.finki.labs.eimtlab.transactionmanagement.domain.repository.TransactionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public TransactionService(TransactionRepository transactionRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.transactionRepository = transactionRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public TransactionId createTransaction(@NonNull Transaction transaction){
        var newTransaction = transactionRepository.saveAndFlush(transaction);
        applicationEventPublisher.publishEvent(new TransactionAdded(newTransaction.id(), newTransaction.getPayer(), newTransaction.getPaidOn().toInstant()));
        return newTransaction.id();
    }
}
