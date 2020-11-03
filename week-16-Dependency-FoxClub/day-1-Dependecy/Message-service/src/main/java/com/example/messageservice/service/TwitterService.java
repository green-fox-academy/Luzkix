package com.example.messageservice.service;

import org.springframework.stereotype.Service;

public class TwitterService implements MessageService{

  @Override
  public String sendMessage(String message, String emailORtwitterUser) {
    return "Twitter message sent to " + emailORtwitterUser + " with message: " + message;
  }
}
