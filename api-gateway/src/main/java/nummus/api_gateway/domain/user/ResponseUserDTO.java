package nummus.api_gateway.domain.user;

import java.util.UUID;

public record ResponseUserDTO(
  UUID id,
  String email,
  String fullName,
  Long birth
  //ADD: accounts
) {}
