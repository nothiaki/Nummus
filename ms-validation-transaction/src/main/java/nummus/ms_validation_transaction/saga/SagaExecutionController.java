package nummus.ms_validation_transaction.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import nummus.ms_validation_transaction.domain.sagaHistory.SagaHistory;
import nummus.ms_validation_transaction.enumerator.ESagaStatus;
import nummus.ms_validation_transaction.messaging.producer.MessagingProducerStrategy;

public class SagaExecutionController {
  @Autowired
  @Qualifier("kafkaProducer")
  private MessagingProducerStrategy<SagaHistory> messagingProducer;

  public void handleSaga(SagaHistory sagaHistory) {
    if (sagaHistory.getStatus().equals(ESagaStatus.SUCCESS)) {
      messagingProducer.send(sagaHistory);
    } else {
      System.out.println("failed on ms-validation-transaction SEC");
    }
  }
}
