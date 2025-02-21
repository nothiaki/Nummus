package nummus.api_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nummus.api_gateway.domain.transaction.CreateTransactionDTO;
import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.messaging.producer.SagaProducer;
import nummus.api_gateway.repository.TransactionRepository;

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;

  private SagaProducer sagaProducer;

  public Transaction create(CreateTransactionDTO createTransaction) {
    Transaction transaction = new Transaction(createTransaction);

    Transaction newTransaction = transactionRepository.save(transaction);

    sagaProducer.send(newTransaction);

    return newTransaction;
  }
}
