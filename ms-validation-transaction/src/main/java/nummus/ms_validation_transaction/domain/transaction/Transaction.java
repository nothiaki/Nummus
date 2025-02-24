package nummus.ms_validation_transaction.domain.transaction;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Transaction {

  private UUID id;
  private String payerID;
  private String payeeID;
  private Long amount;
  private TransactionType type;
  private Date createdAt;
}
