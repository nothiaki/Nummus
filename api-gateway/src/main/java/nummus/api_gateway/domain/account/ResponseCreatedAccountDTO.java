package nummus.api_gateway.domain.account;

import java.util.UUID;

public record ResponseCreatedAccountDTO(
  UUID userID,
  ResponseAccountDTO account
) {}
