package nummus.ms_validation_transaction.messaging.producer;

public interface MessagingProducerStrategy<T> {
  void send(T payload);
}
