package com.example.todo.services;

public class UsernameAlreadyExistException extends Exception {
  public UsernameAlreadyExistException(String message) {
    super(message);
  }
}
