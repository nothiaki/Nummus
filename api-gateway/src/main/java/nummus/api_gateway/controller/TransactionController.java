package nummus.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nummus.api_gateway.domain.transaction.CreateTransactionDTO;
import nummus.api_gateway.domain.transaction.TransactionResponseWithSagaHistoryIDDTO;
import nummus.api_gateway.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
  @Autowired
  TransactionService transactionService;

  @PostMapping
  public ResponseEntity<TransactionResponseWithSagaHistoryIDDTO> create(
    @RequestBody @Valid CreateTransactionDTO createTransactionDTO
  ) {
    TransactionResponseWithSagaHistoryIDDTO transaction = transactionService.create(createTransactionDTO);
    return ResponseEntity.ok(transaction);
  }
}
