package mk.finki.labs.eimtlab.transactionmanagement.domain.repository;

import mk.finki.labs.eimtlab.transactionmanagement.domain.model.Transaction;
import mk.finki.labs.eimtlab.transactionmanagement.domain.model.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
}
