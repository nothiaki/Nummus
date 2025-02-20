package nummus.api_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nummus.api_gateway.domain.transaction.CreateTransactionDTO;
import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.repository.TransactionRepository;

@Service
public class TransactionService {
  @Autowired
  TransactionRepository transactionRepository;

  public Transaction create(CreateTransactionDTO createTransaction) {
    Transaction transaction = new Transaction(createTransaction);
    return transactionRepository.save(transaction);
  }
}
