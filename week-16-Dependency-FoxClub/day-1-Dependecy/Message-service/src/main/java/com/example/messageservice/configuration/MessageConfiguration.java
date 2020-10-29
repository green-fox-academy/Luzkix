package com.example.messageservice.configuration;
import com.example.messageservice.service.EmailService;
import com.example.messageservice.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MessageConfiguration {

  @Bean
  EmailService emailService(){
    return new EmailService();
  }

  TwitterService twitterService(){
    return new TwitterService();
  }
}
