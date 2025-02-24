package nummus.api_gateway.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import nummus.api_gateway.domain.sagaHistory.Operation;
import nummus.api_gateway.domain.sagaHistory.SagaHistory;
import nummus.api_gateway.domain.transaction.Transaction;
import nummus.api_gateway.enumerator.ESagaStatus;
import nummus.api_gateway.repository.SagaHistoryRepository;

@Service
public class SagaHistoryService {

  @Autowired
  private SagaHistoryRepository sagaHistoryRepository;

  private static final String CURRENT_SOURCE = "API-GATEWAY";

  public void endSaga(SagaHistory sagaHistory) {
  }

  public SagaHistory createSagaHistory(Transaction transaction) {
    System.out.println("inside create saga history");
    SagaHistory sagaHistory = SagaHistory.builder()
                              .source(CURRENT_SOURCE)
                              .transaction(transaction)
                              .createdAt(new Date())
                              .build();

    Operation operation = Operation.builder()
                          .source(CURRENT_SOURCE)
                          .status(ESagaStatus.SUCCESS)
                          .createdAt(new Date())
                          .build();
    
    sagaHistory.addOperationToOperationHistory(operation);

    sagaHistoryRepository.save(sagaHistory);

    return sagaHistory;
  }

  public SagaHistory findOne(UUID id) {
    SagaHistory sagaHistory = sagaHistoryRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found id for saga history"));

    return sagaHistory;
  }
}
