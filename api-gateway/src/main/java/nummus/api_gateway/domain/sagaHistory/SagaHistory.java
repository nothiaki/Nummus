package nummus.api_gateway.domain.sagaHistory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.enumerator.ESagaStatus;

@Entity
@Table(name = "saga_history")
@Getter
@Setter
@NoArgsConstructor
public class SagaHistory {
  @Id
  @GeneratedValue
  private UUID id;

  @Enumerated(EnumType.STRING)
  private ESagaStatus status;

  private Transaction transaction;
  private String source;
  private List<Operation> operationHistory;
  private Date createdAt;
}
