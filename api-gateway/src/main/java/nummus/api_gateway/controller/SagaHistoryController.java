package nummus.api_gateway.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nummus.api_gateway.domain.sagaHistory.SagaHistory;
import nummus.api_gateway.service.SagaHistoryService;

@RestController
@RequestMapping("/saga-history")
class SagaHistoryController {
  @Autowired
  private SagaHistoryService sagaHistoryService;
  
  @GetMapping("/{id}")
  public ResponseEntity<SagaHistory> findOne(@PathVariable UUID id) {
    SagaHistory sagaHistory = sagaHistoryService.findOne(id);
    return ResponseEntity.ok(sagaHistory);
  }
}
