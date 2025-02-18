package nummus.api_gateway.repository;

import nummus.api_gateway.domain.user.User;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, UUID> {}
