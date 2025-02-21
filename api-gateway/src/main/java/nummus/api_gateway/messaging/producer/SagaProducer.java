package nummus.api_gateway.messaging.producer;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;

import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.helper.HelperJson;

public class SagaProducer implements MessagingProducerStrategy<Transaction> {
  //private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${spring.kafka.topic.start-saga}")
  private String startSagaTopic;

  HelperJson<Transaction> helperJson = new HelperJson<Transaction>(Transaction.class);

  @Override
  public void send(Transaction payload) {
    System.out.println("entrou no saga" + startSagaTopic);
    //try {
    //  String payloadStringfied = helperJson.toJson(payload);
    //  kafkaTemplate.send(startSagaTopic, payloadStringfied);
    //} catch (Exception ex) {
    //  System.out.println("Error trying send data to " + startSagaTopic);
    //}
  }
}
