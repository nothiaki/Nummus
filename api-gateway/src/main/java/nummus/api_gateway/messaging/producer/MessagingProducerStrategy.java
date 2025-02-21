package nummus.api_gateway.messaging.producer;

public interface MessagingProducerStrategy<T> {
  void send(T payload);
}
