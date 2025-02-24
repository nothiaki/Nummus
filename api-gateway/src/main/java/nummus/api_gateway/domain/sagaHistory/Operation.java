package nummus.api_gateway.domain.sagaHistory;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nummus.api_gateway.enumerator.ESagaStatus;

@Getter
@Setter
@NoArgsConstructor
public class Operation {
  private String source;
  private ESagaStatus status;
  private Date createdAt;
}
