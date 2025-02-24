package nummus.ms_validation_transaction.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import nummus.ms_validation_transaction.domain.sagaHistory.SagaHistory;
import nummus.ms_validation_transaction.helper.HelperJson;

@Component
public class KafkaConsumer implements MessagingConsumerStrategy<String> {

  HelperJson<SagaHistory> helperJson = new HelperJson<SagaHistory>(SagaHistory.class);

  @KafkaListener(
    groupId = "${spring.kafka.consumer.group-id}",
    topics = "${spring.kafka.topic.ms-validation-transaction-start-saga}"
  )
  @Override
  public void consume(String payload) {
    SagaHistory sagaHistory = helperJson.JsonTo(payload);
    System.out.println("Reciving ms-validation-transaction-start-saga topic payload" + sagaHistory);
    sagaHistoryService.endSaga(sagaHistory);
  }
}
