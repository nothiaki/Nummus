package nummus.ms_validation_transaction.domain.sagaHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import nummus.ms_validation_transaction.domain.transaction.Transaction;
import nummus.ms_validation_transaction.enumerator.ESagaStatus;

import static org.springframework.util.ObjectUtils.isEmpty;

@Getter
@Setter
public class SagaHistory {

  private UUID id;
  private Transaction transaction;
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
