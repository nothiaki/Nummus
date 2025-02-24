package nummus.ms_validation_transaction.domain.sagaHistory;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import nummus.ms_validation_transaction.enumerator.ESagaStatus;

@Builder
@AllArgsConstructor
public class Operation {
  private String source;
  private ESagaStatus status;
  private Date createdAt;
}
