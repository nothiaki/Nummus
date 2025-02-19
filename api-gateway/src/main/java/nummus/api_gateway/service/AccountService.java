package nummus.api_gateway.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nummus.api_gateway.domain.account.Account;
import nummus.api_gateway.domain.account.ResponseAccountDTO;
import nummus.api_gateway.domain.user.User;
import nummus.api_gateway.repository.AccountRepository;

@Service
public class AccountService {
  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private UserService userService;

  public ResponseAccountDTO create(UUID owner) {
    
    User user = userService.findById(owner);

    Account newAccount = accountRepository.save(new Account(user));

    return new ResponseAccountDTO(
      newAccount.getId(),
      newAccount.getBalance(),
      newAccount.getUser().getId()
    );
  }
}
