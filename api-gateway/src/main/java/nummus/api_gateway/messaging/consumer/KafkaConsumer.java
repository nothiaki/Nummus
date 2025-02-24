package nummus.api_gateway.messaging.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.helper.HelperJson;

@Component
public class KafkaConsumer implements MessagingConsumerStrategy<String> {

  HelperJson<Transaction> helperJson = new HelperJson<Transaction>(Transaction.class);

  @KafkaListener(
    groupId = "${spring.kafka.consumer.group-id}",
    topics = "${spring.kafka.topic.ms-validation-transaction-end-saga}"
  )
  @Override
  public void consume(String payload) {
    Transaction transaction = helperJson.JsonTo(payload);
    System.out.println("Reciving from ms-validation-transaction-end-saga topic payload" + transaction);
    //sagaHistoryService.endSaga(transaction);
  }
}
