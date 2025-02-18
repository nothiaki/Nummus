package nummus.api_gateway.domain.account;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nummus.api_gateway.domain.user.User;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class Account {
  @Id
  @GeneratedValue
  private UUID id;

  private long balance;
  private Date createdAt;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}
