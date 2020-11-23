package com.example.reddit.service;

import com.example.reddit.model.User;

public interface UserService {
  boolean tryToLogInTheUser(String userEmail, String userPassword);
  User loggedUser();
  boolean tryAddNewUser(String name, String email, String password);
  void logout();
  void saveUser(User user);
  boolean saveEditedAccountOfUser(User updatedUser);
}
