package devencarnacion.app_amf_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devencarnacion.app_amf_back.entities.Transaction;
import devencarnacion.app_amf_back.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Integer id, Transaction transaction) {
        Transaction currentTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro la categoria con el id " + id));

        if (transaction.getUser() != null) {
            currentTransaction.setUser(transaction.getUser());
        }

        if (transaction.getCategory() != null) {
            currentTransaction.setCategory(transaction.getCategory());
        }

        if (transaction.getTypeBudget() != null) {
            currentTransaction.setTypeBudget(transaction.getTypeBudget());
        }

        if (transaction.getAmount() != null) {
            currentTransaction.setAmount(transaction.getAmount());
        }

        if (transaction.getDescription() != null) {
            currentTransaction.setDescription(transaction.getDescription());
        }

        if (transaction.getDate() != null) {
            currentTransaction.setDate(transaction.getDate());
        }

        return transactionRepository.save(currentTransaction);
    }

    public void deleteTransaction(Integer id) {
        Transaction currentTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la categoría con el id " + id));

        transactionRepository.delete(currentTransaction);
    }
}
