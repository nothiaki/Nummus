package nummus.api_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nummus.api_gateway.domain.sagaHistory.SagaHistory;
import nummus.api_gateway.domain.transaction.CreateTransactionDTO;
import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.domain.transaction.TransactionResponseWithSagaHistoryIDDTO;
import nummus.api_gateway.messaging.producer.MessagingProducerStrategy;
import nummus.api_gateway.repository.TransactionRepository;

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;

  @Autowired
  @Qualifier("kafkaProducer")
  private MessagingProducerStrategy<SagaHistory> messagingProducer;

  @Autowired
  SagaHistoryService sagaHistoryService;

  public TransactionResponseWithSagaHistoryIDDTO create(CreateTransactionDTO createTransaction) {
    Transaction transaction = new Transaction(createTransaction);

    Transaction newTransaction = transactionRepository.save(transaction);

    SagaHistory sagaHistory = sagaHistoryService.createSagaHistory(newTransaction);

    messagingProducer.send(sagaHistory);

    return new TransactionResponseWithSagaHistoryIDDTO(newTransaction, sagaHistory.getId());
  }
}
