package nummus.api_gateway.domain.transaction;

import java.util.UUID;

public record TransactionResponseWithSagaHistoryIDDTO(
  Transaction transaction,
  UUID sagaHistoryID
) {}


