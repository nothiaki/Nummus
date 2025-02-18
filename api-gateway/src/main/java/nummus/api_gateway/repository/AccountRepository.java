package nummus.api_gateway.repository;

import nummus.api_gateway.domain.account.Account;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, UUID> {}
