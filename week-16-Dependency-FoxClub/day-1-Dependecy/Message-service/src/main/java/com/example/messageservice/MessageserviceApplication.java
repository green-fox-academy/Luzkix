package com.example.messageservice;

import com.example.messageservice.service.MessageProceeder;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageserviceApplication implements CommandLineRunner {

  @Autowired
  MessageProceeder messageProceeder;

  public static void main(String[] args) {
    SpringApplication.run(MessageserviceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //messageProceeder.processMessage("Hi Barba, How are you?", "office@greenfox.com");
    System.out.println(messageProceeder.processMessage("Hi Barba, How are you?", "office@greenfox.com"));
  }
}