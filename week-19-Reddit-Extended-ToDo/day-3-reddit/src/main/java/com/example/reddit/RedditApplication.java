package com.example.reddit;

import com.example.reddit.model.Post;
import com.example.reddit.service.PostService;
import com.example.reddit.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(RedditApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
  }
}
