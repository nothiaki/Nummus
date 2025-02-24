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
    if (sagaHistory.getStatus().equals(ESagaStatus.SUCCESS)) {
      System.out.println("Saga finished successfully" + sagaHistory);
      addOperation(sagaHistory);
    } else {
      System.out.println("Saga finished with error" + sagaHistory);
      addOperation(sagaHistory);
    }

    sagaHistoryRepository.save(sagaHistory);
  }

  public SagaHistory createSagaHistory(Transaction transaction) {
    System.out.println("inside create saga history");
    SagaHistory sagaHistory = SagaHistory.builder()
                              .source(CURRENT_SOURCE)
                              .transaction(transaction)
                              .status(ESagaStatus.PROCESSING)
                              .createdAt(new Date())
                              .build();

    addOperation(sagaHistory);

    return sagaHistory;
  }

  public void addOperation(SagaHistory sagaHistory) {
    Operation operation = Operation.builder()
                          .source(CURRENT_SOURCE)
                          .status(sagaHistory.getStatus())
                          .createdAt(new Date())
                          .build();
    
    sagaHistory.addOperationToOperationHistory(operation);
  }

  public SagaHistory findOne(UUID id) {
    SagaHistory sagaHistory = sagaHistoryRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found id for saga history"));

    return sagaHistory;
  }
}
