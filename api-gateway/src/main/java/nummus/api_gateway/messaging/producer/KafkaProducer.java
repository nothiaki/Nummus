package nummus.api_gateway.messaging.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import nummus.api_gateway.domain.sagaHistory.SagaHistory;
import nummus.api_gateway.helper.HelperJson;

@Component
public class KafkaProducer implements MessagingProducerStrategy<SagaHistory> {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${spring.kafka.topic.ms-validation-transaction-start-saga}")
  private String msValidationTransactionStartSagaTopic;

  HelperJson<SagaHistory> helperJson = new HelperJson<SagaHistory>(SagaHistory.class);

  @Override
  public void send(SagaHistory sagaHistory) {
    try {
      String sagaHistoryStringfied = helperJson.toJson(sagaHistory);
      kafkaTemplate.send(msValidationTransactionStartSagaTopic, sagaHistoryStringfied);
    } catch (Exception ex) {
      System.out.println("Error trying send data to " + msValidationTransactionStartSagaTopic);
    }
  }
}
