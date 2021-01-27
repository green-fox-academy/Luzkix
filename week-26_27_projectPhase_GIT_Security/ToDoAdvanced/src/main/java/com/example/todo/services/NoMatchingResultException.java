package com.example.todo.services;

public class NoMatchingResultException extends Throwable {
  public NoMatchingResultException(String message) {
    super(message);
  }
}
