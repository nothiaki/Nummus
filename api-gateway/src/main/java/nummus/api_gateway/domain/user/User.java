package nummus.api_gateway.domain.user;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nummus.api_gateway.domain.account.Account;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private UUID id;

  private String email;
  private String fullName;
  private LocalDate birth;
  private String password;

  @OneToMany(mappedBy = "user")
  private List<Account> accounts;
}
