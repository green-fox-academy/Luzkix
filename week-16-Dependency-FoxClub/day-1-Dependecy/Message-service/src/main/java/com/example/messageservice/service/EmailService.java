package com.example.messageservice.service;

public class EmailService implements MessageService{

  @Override
  public String sendMessage(String message, String emailORtwitterUser) {
    return "Email sent to " + emailORtwitterUser + " with message: " + message;
  }
}
