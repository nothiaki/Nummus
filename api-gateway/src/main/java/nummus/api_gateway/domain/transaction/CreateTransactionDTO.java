package nummus.api_gateway.domain.transaction;

import jakarta.validation.constraints.NotEmpty;

public record CreateTransactionDTO(

  @NotEmpty(message = "PayerID should not be empty")
  String payerID,

  @NotEmpty(message = "PayeeID should not be empty")
  String payeeID,

  @NotEmpty(message = "Amount should not be empty")
  Long amount
) {}


