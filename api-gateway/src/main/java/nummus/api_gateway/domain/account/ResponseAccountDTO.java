package nummus.api_gateway.domain.account;

import java.util.UUID;

public record ResponseAccountDTO(
  UUID id,
  Long balance
) {}
