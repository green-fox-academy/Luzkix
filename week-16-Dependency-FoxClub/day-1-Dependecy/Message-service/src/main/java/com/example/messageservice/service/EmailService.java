package com.example.messageservice.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class EmailService implements MessageService{

  @Override
  public String sendMessage(String message, String emailORtwitterUser) {
    return "Email sent to " + emailORtwitterUser + " with message: " + message;
  }
}
