package com.example.todo.controllers;

import com.example.todo.models.Todo;
import com.example.todo.models.dto.ErrorDTO;
import com.example.todo.models.dto.FilterTodoDTO;
import com.example.todo.models.dto.FilteredTodosResponseDTO;
import com.example.todo.models.dto.UpdateTodoDTO;
import com.example.todo.services.NoMatchingOwnerException;
import com.example.todo.services.NoMatchingResultException;
import com.example.todo.services.TodoService;
import com.example.todo.services.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TodoController {
  private TodoService todoService;
  private UserService userService;

  @Autowired
  public TodoController(TodoService todoService, UserService userService) {
    this.todoService = todoService;
    this.userService = userService;

  }

  @PostMapping("/newTodo")
  ResponseEntity<?> createNewTodo(@RequestBody Todo input, Principal principal) {
    try {
      String loginName = principal.getName();

      Todo createdTodo = todoService.createTodo(input, loginName);

      return ResponseEntity.ok().body(createdTodo);
    } catch (NullPointerException e) {
      ErrorDTO error = todoService.setError("Please provide the TODO json with all required data!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
  }

  @GetMapping("/listTodos")
  ResponseEntity<?> getTodos(@RequestBody FilterTodoDTO filter) {
    try {
      FilteredTodosResponseDTO filteredTodos = todoService.filterTodos(filter);
      return ResponseEntity.ok().body(filteredTodos);
    } catch (NullPointerException e) {
      ErrorDTO error = todoService.setError("Please provide the json for filtering Todos with correct data!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    } catch (NoMatchingResultException e) {
      ErrorDTO error = todoService.setError("No matching results were found!");
      return ResponseEntity.status(HttpStatus.valueOf(404)).body(error);
    }
  }

  @PutMapping("/updateTodo")
  ResponseEntity<?> updateTodo(@RequestBody UpdateTodoDTO updatedTodoData, Principal principal) {
    try {
      String loginName = principal.getName();

      Todo updatedTodo = todoService.updateTodo(updatedTodoData, loginName);
      return ResponseEntity.ok().body(updatedTodo);
    } catch (NullPointerException e) {
      ErrorDTO error = todoService.setError("Please provide the TODO json with all required data!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    } catch (NoMatchingResultException e) {
      ErrorDTO error = todoService.setError("No ToDo with matching ID was found OR No User with matching ID was found - Todo was not updated");
      return ResponseEntity.status(HttpStatus.valueOf(404)).body(error);
    } catch (NoMatchingOwnerException e) {
      ErrorDTO error = todoService.setError("You are not the Owner of the Todo you want to change - Todo was not updated");
      return ResponseEntity.status(HttpStatus.valueOf(401)).body(error);
    }
  }


}
