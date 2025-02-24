package nummus.api_gateway.messaging.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.helper.HelperJson;

@Component
public class KafkaProducer implements MessagingProducerStrategy<Transaction> {
  private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${spring.kafka.topic.ms-validation-transaction-start-saga}")
  private String msValidationTransactionStartSagaTopic;

  HelperJson<Transaction> helperJson = new HelperJson<Transaction>(Transaction.class);

  @Override
  public void send(Transaction payload) {
    try {
      String payloadStringfied = helperJson.toJson(payload);
      kafkaTemplate.send(msValidationTransactionStartSagaTopic, payloadStringfied);
    } catch (Exception ex) {
      System.out.println("Error trying send data to " + msValidationTransactionStartSagaTopic);
    }
  }
}
