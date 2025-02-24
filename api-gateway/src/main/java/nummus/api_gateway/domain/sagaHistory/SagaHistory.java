package nummus.api_gateway.domain.sagaHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.enumerator.ESagaStatus;

import static org.springframework.util.ObjectUtils.isEmpty;

@Entity
@Table(name = "saga_history")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SagaHistory {
  @Id
  @GeneratedValue
  private UUID id;

  @OneToOne
  @JoinColumn(name = "transactionID", referencedColumnName = "id", unique = true)
  private Transaction transaction;

  @ElementCollection
  private List<Operation> operationHistory;

  private String source;
  private Date createdAt;
  private ESagaStatus status;

  public void addOperationToOperationHistory(Operation operation) {
    if (isEmpty(operationHistory)) {
      operationHistory = new ArrayList<>();
    }

    operationHistory.add(operation);
  }
}
