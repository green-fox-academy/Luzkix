package com.example.messageservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MessageProceeder {
  MessageService messageService;

  @Autowired
  public MessageProceeder(MessageService messageService) {
    this.messageService = messageService;
  }

  public String processMessage (String message, String email) {
    return messageService.sendMessage(message, email);
  }

}
