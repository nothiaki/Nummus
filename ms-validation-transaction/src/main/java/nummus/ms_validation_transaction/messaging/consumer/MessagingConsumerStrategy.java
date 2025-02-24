package nummus.ms_validation_transaction.messaging.consumer;

public interface MessagingConsumerStrategy<T> {
  void consume(T payload);
}
