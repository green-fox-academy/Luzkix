package com.example.hellodi;

import com.example.hellodi.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellodiApplication implements CommandLineRunner {
  @Autowired
  Printer text;

  public static void main(String[] args) {
    SpringApplication.run(HellodiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
  text.log("hello");
  }
}
