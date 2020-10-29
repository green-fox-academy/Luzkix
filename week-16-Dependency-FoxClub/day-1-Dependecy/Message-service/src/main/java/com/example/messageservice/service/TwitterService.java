package com.example.messageservice.service;

public class TwitterService implements MessageService{

  @Override
  public String sendMessage(String message, String emailORtwitterUser) {
    return "Twitter message sent to " + emailORtwitterUser + " with message: " + message;
  }
}
