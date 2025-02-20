package nummus.api_gateway.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import nummus.api_gateway.domain.account.Account;
import nummus.api_gateway.domain.account.ResponseAccountDTO;
import nummus.api_gateway.domain.account.ResponseCreatedAccountDTO;
import nummus.api_gateway.domain.user.User;
import nummus.api_gateway.repository.AccountRepository;

@Service
public class AccountService {
  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private UserService userService;

  public ResponseCreatedAccountDTO create(UUID owner) {
    
    User user = userService.findById(owner);

    Account newAccount = accountRepository.save(new Account(user));

    ResponseAccountDTO accountDTO = new ResponseAccountDTO(
      newAccount.getId(),
      newAccount.getBalance()
    );

    return new ResponseCreatedAccountDTO(
      newAccount.getUser().getId(),
      accountDTO
    );
  }

  public ResponseAccountDTO findOne(UUID id) {
    Account account = accountRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));


    return new ResponseAccountDTO(
      account.getId(),
      account.getBalance()
    );
  }
}
