package nummus.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nummus.api_gateway.domain.user.CreateUserDTO;
import nummus.api_gateway.domain.user.ResponseUserDTO;
import nummus.api_gateway.service.UserService;

@RestController
@RequestMapping("/users")
class UserController {
  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<ResponseUserDTO> create(@RequestBody @Valid CreateUserDTO createUser) {
    ResponseUserDTO user = userService.create(createUser);
    return ResponseEntity.ok(user);
  }
}
