package com.example.todo.services;

import com.example.todo.models.TodoOwner;
import com.example.todo.models.dto.UserRegistrationDTO;

public interface UserService {
  //List<Todo> findTodosByUserName(String userName);
  TodoOwner findOwnerById(Long id);

  TodoOwner findOwnerBasedOnUserName(String userName);

  TodoOwner createNewOwner(UserRegistrationDTO input) throws UsernameAlreadyExistException, NullPointerException, ShortPasswordException;

  TodoOwner loginUser(UserRegistrationDTO input) throws WrongLoginException, NullPointerException;
}
