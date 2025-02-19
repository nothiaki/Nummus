package nummus.api_gateway.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import nummus.api_gateway.domain.user.CreateUserDTO;
import nummus.api_gateway.domain.user.ResponseUserDTO;
//import nummus.api_gateway.repository.UserRepository;

@Service
public class UserService {
  //private UserRepository userRepository;

  public ResponseUserDTO create(CreateUserDTO createUser) {
    return new ResponseUserDTO(
      UUID.randomUUID(),
      createUser.email(),
      createUser.fullName(),
      createUser.birth()
    );
  }
}
