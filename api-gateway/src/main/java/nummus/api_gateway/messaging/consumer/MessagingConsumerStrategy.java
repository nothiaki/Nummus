package nummus.api_gateway.messaging.consumer;

public interface MessagingConsumerStrategy<T> {
  void consume(T payload);
}
