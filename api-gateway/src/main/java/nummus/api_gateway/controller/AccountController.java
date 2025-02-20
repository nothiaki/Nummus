package nummus.api_gateway.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nummus.api_gateway.domain.account.ResponseAccountDTO;
import nummus.api_gateway.domain.account.ResponseCreatedAccountDTO;
import nummus.api_gateway.service.AccountService;

@RestController
@RequestMapping("/accounts")
class AccountController {
  @Autowired
  private AccountService accountService;

  @PostMapping("/{owner}")
  public ResponseEntity<ResponseCreatedAccountDTO> create(@PathVariable UUID owner) {
    ResponseCreatedAccountDTO account = accountService.create(owner);
    return ResponseEntity.ok(account);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<ResponseAccountDTO> findOne(@PathVariable UUID id) {
    ResponseAccountDTO account = accountService.findOne(id);
    return ResponseEntity.ok(account);
  }
}
