package nummus.api_gateway.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import nummus.api_gateway.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {}
