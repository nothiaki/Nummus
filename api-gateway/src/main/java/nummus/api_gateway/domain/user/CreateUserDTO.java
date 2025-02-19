package nummus.api_gateway.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
  @NotEmpty(message = "Email should not be empty")
  @Email
  String email,

  @NotEmpty(message = "Full name should not be empty")
  @Size(min = 6, max = 100)
  String fullName,

  @NotEmpty(message = "Birth should not be empty")
  Long birth,

  @NotEmpty(message = "Password should not be empty")
  @Size(min = 6, max = 26)
  String password
) {}
