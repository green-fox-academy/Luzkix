package com.example.todo.services;

public class NoMatchingOwnerException extends Throwable {
  public NoMatchingOwnerException(String message) {
    super(message);
  }
}
