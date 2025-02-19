package nummus.api_gateway.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import nummus.api_gateway.domain.user.CreateUserDTO;
import nummus.api_gateway.domain.user.ResponseUserDTO;
import nummus.api_gateway.domain.user.User;
import nummus.api_gateway.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public ResponseUserDTO create(CreateUserDTO createUser) {
    
    userRepository.findOneByEmail(createUser.email())
      .ifPresent(user -> {
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
      });

    User newUser = userRepository.save(new User(createUser));

    return new ResponseUserDTO(
      newUser.getId(),
      newUser.getEmail(),
      newUser.getFullName(),
      newUser.getBirth().getTime()
    );
  }
}
