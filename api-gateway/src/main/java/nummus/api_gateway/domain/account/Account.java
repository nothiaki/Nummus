package nummus.api_gateway.domain.account;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nummus.api_gateway.domain.user.User;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
  @Id
  @GeneratedValue
  private UUID id;

  private Long balance = 0L;

  @ManyToOne
  @JoinColumn(name = "userID")
  private User user;

  public Account(User user) {
    this.user = user;
  }
}
