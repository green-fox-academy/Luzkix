package com.example.todo.configuration;

import com.example.todo.models.TodoOwner;
import com.example.todo.services.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
  UserService userService;
  public CustomUserDetailsService(UserService userService) {
    this.userService = userService;
  }

  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    TodoOwner todoOwner = userService.findOwnerBasedOnUserName(username);
    return CustomUserDetails.fromTodoOwnerToCustomUserDetails(todoOwner);
  }
}
