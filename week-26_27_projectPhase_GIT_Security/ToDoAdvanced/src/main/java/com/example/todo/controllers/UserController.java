package com.example.todo.controllers;

import com.example.todo.configuration.jwt.JwtProvider;
import com.example.todo.models.TodoOwner;
import com.example.todo.models.dto.ErrorDTO;
import com.example.todo.models.dto.UserRegistrationDTO;
import com.example.todo.models.dto.UserTokenOutputDTO;
import com.example.todo.services.ShortPasswordException;
import com.example.todo.services.TodoService;
import com.example.todo.services.UserService;
import com.example.todo.services.UsernameAlreadyExistException;
import com.example.todo.services.WrongLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {
  private TodoService todoService;
  private UserService userService;
  private JwtProvider jwtProvider;
  @Autowired
  public UserController(TodoService todoService, UserService userService,JwtProvider jwtProvider) {
    this.todoService = todoService;
    this.userService = userService;
    this.jwtProvider = jwtProvider;
  }

  @PostMapping("/registration")
  ResponseEntity<?> registerNewAccount(@RequestBody UserRegistrationDTO input) {
    try {
      TodoOwner newUser = userService.createNewOwner(input);
      return ResponseEntity.ok().body(newUser);
    } catch (NullPointerException e) {
      ErrorDTO error = todoService.setError("Missing username or password!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    } catch (UsernameAlreadyExistException e) {
      ErrorDTO error = todoService.setError("Username already in database!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    } catch (ShortPasswordException e) {
      ErrorDTO error = todoService.setError(input.getPassword() + " has less than 8 characters!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
  }

  @GetMapping("/login")
  ResponseEntity<?> login(@RequestBody UserRegistrationDTO input) {
    try {
      TodoOwner loggedUser = userService.loginUser(input);
      if (loggedUser != null) {
        String token = jwtProvider.generateToken(loggedUser.getLogin());
        UserTokenOutputDTO tokenDTO = new UserTokenOutputDTO(token);
        return ResponseEntity.ok().body(tokenDTO);
      } else {
        ErrorDTO error = todoService.setError("Something went wrong!");
        return ResponseEntity.status(HttpStatus.valueOf(500)).body(error);
      }
    } catch (NullPointerException e) {
      ErrorDTO error = todoService.setError("Missing username or password in json!");
      return ResponseEntity.status(HttpStatus.valueOf(400)).body(error);
    } catch (WrongLoginException e) {
      ErrorDTO error = todoService.setError("Wrong Login - user not exists or incorrect password!");
      return ResponseEntity.status(HttpStatus.valueOf(401)).body(error);
    }
  }

}
