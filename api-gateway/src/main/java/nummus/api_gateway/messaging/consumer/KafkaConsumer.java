package nummus.api_gateway.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import nummus.api_gateway.domain.sagaHistory.SagaHistory;
import nummus.api_gateway.helper.HelperJson;
import nummus.api_gateway.service.SagaHistoryService;

@Component
public class KafkaConsumer implements MessagingConsumerStrategy<String> {

  @Autowired
  SagaHistoryService sagaHistoryService;

  HelperJson<SagaHistory> helperJson = new HelperJson<SagaHistory>(SagaHistory.class);

  @KafkaListener(
    groupId = "${spring.kafka.consumer.group-id}",
    topics = "${spring.kafka.topic.ms-validation-transaction-end-saga}"
  )
  @Override
  public void consume(String payload) {
    SagaHistory sagaHistory = helperJson.JsonTo(payload);
    System.out.println("Reciving from ms-validation-transaction-end-saga topic payload" + sagaHistory);
    sagaHistoryService.endSaga(sagaHistory);
  }
}
