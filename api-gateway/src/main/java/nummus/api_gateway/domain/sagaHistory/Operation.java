package nummus.api_gateway.domain.sagaHistory;

import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nummus.api_gateway.enumerator.ESagaStatus;

@Embeddable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
  private String source;
  private ESagaStatus status;
  private Date createdAt;
}
