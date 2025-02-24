package nummus.ms_validation_transaction.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nummus.ms_validation_transaction.domain.sagaHistory.Operation;
import nummus.ms_validation_transaction.domain.sagaHistory.SagaHistory;
import nummus.ms_validation_transaction.domain.transaction.TransactionType;
import nummus.ms_validation_transaction.enumerator.ESagaStatus;
import nummus.ms_validation_transaction.messaging.producer.MessagingProducerStrategy;
import nummus.ms_validation_transaction.saga.SagaExecutionController;


@Service
public class TransactionValidationService {
  @Autowired
  @Qualifier("kafkaProducer")
  private MessagingProducerStrategy<SagaHistory> messagingProducer;

  @Autowired
  private SagaExecutionController sagaExecutionController;

  private static final String CURRENT_SOURCE = "MS-VALIDATION-TRANSACTION";

  public void validateTransactionType(SagaHistory sagaHistory) {
    if (sagaHistory.getTransaction().getType() == TransactionType.DEBIT ||
    sagaHistory.getTransaction().getType() == TransactionType.CREDIT ||
    sagaHistory.getTransaction().getType() == TransactionType.PIX
    ) {
      handleSuccess(sagaHistory);
    } else {
      System.out.println("Error while proccessing handle transaction type");
      handleFail(sagaHistory);
    }

     sagaExecutionController.handleSaga(sagaHistory);
  }

  private void handleSuccess(SagaHistory sagaHistory) {
    sagaHistory.setStatus(ESagaStatus.SUCCESS);
    sagaHistory.setSource(CURRENT_SOURCE);
    addOperation(sagaHistory);
  }

  private void addOperation(SagaHistory sagaHistory) {
    Operation operation = Operation.builder()
                          .source(CURRENT_SOURCE)
                          .status(sagaHistory.getStatus())
                          .createdAt(new Date())
                          .build();
    
    sagaHistory.addOperationToOperationHistory(operation);
  }

  private void handleFail(SagaHistory sagaHistory) {
    System.out.println("failed in transaction validation");
  }
}
