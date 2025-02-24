package nummus.api_gateway.domain.transaction;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
  @Id
  @GeneratedValue
  private UUID id;

  private String payerID;
  private String payeeID;
  private Long amount;
  private TransactionType type;
  private Date createdAt;

  public Transaction(CreateTransactionDTO createTransaction) {
    this.payerID = createTransaction.payerID();
    this.payeeID = createTransaction.payeeID();
    this.amount = createTransaction.amount();
    this.type = createTransaction.type();
    this.createdAt = new Date();
  }
}
